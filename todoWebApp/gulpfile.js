var gulp = require('gulp');
var plugins = require('gulp-load-plugins')();
var bowerFiles = require('main-bower-files');
var browserSync = require('browser-sync').create();
var es = require('event-stream');
var del = require('del');
var Q = require('q');
var fs = require('fs');
var pkg = JSON.parse(fs.readFileSync('./package.json'));

// == PATH STRINGS ========
var paths = {
    scripts: './app/**/*.js',
    styles: ['./app/**/*.css', './app/**/*.scss'],
    images: './images/**/*',
    index: './app/index.html',
    partials: ['app/**/*tmpl.html', '!app/index.html'],
    app: "./app/**",
    distDev: './dist.dev',
    distProd: './dist.prod',
    distScriptsProd: './dist.prod/scripts',
    fontAwesome: './app/assets/fontAwesome/**',
};

var vendorScriptsOrder = ['jquery.js', 'angular.js'];

// === PIPE SEGMENTS === //
var pipes = {};
pipes.app = {};
pipes.dev = {};
pipes.prod = {};

// == APP PIPES == //

//reloads browser
pipes.app.browserReload = function(done) {
    browserSync.reload();
    done();
};

// validate app scripts
pipes.app.validateScripts = function() {
    return gulp.src(paths.scripts)
        .pipe(plugins.jshint())
        .pipe(plugins.jshint.reporter('jshint-stylish'));
};

//validate app htmls
pipes.app.validateHtml = function() {
    return gulp.src(paths.index)
        .pipe(plugins.htmlhint())
        .pipe(plugins.htmlhint.reporter());
};

//validate partial app htmls
pipes.app.validatePartialHtmls = function() {
    return gulp.src(paths.partials)
        .pipe(plugins.htmlhint({
            'doctype-first': false
        }))
        .pipe(plugins.htmlhint.reporter());
};

pipes.app.orderedVendorScripts = function() {
    return plugins.order(vendorScriptsOrder);
};

// == DEV PIPES == //

//validate all partial html and copy to distDev
pipes.dev.buildPartialHtmls = function() {
    return pipes.app.validatePartialHtmls()
        .pipe(gulp.dest(paths.distDev));
};

// copy and order all bower components to distDev
pipes.dev.buildVendorScripts = function() {
    return gulp.src(bowerFiles())
        .pipe(plugins.order(['jquery.js', 'angular.js']))
        .pipe(gulp.dest('dist.dev/bower_components'));
};

// build ordered app scripts to distDev
pipes.dev.buildAppScripts = function() {
    return pipes.app.validateScripts()
        .pipe(gulp.dest(paths.distDev))
        .pipe(plugins.angularFilesort());
};

// compile scss files to distDev
pipes.dev.buildStyles = function() {
    return gulp.src(paths.styles)
        .pipe(plugins.sass())
        .pipe(gulp.dest(paths.distDev));
};

//validate and move all partial html to distDev
pipes.dev.buildPartials = function() {
    return pipes.app.validatePartialHtmls()
        .pipe(gulp.dest(paths.distDev));
};

//copy images to distDev
pipes.dev.processImages = function() {
    return gulp.src(paths.images)
        .pipe(gulp.dest(paths.distDev + '/images/'));
};
//copy mdi fonts to distDev
pipes.dev.processFontAwesome = function() {
    return gulp.src(paths.fontAwesome)
        .pipe(gulp.dest(paths.distDev + '/fonts/'));
};
//build index for distDev
pipes.dev.buildIndex = function() {
    var vendorScripts = pipes.dev.buildVendorScripts();
    var appScripts = pipes.dev.buildAppScripts();
    var appStyles = pipes.dev.buildStyles();

    return pipes.app.validateHtml()
        .pipe(gulp.dest(paths.distDev))
        .pipe(plugins.inject(vendorScripts, {
            relative: true,
            name: 'bower'
        }))
        .pipe(plugins.inject(appScripts, {
            relative: true
        }))
        .pipe(plugins.inject(appStyles, {
            relative: true
        }))
        .pipe(gulp.dest(paths.distDev));
};

pipes.dev.build = function() {
    return es.merge(
        pipes.dev.buildIndex(), pipes.dev.buildPartials(), pipes.dev.processImages(), pipes.dev.processFontAwesome()
    );
};
//delete distDev folder
pipes.dev.clean = function() {
    var deferred = Q.defer();
    del(paths.distDev, function() {
        deferred.resolve();
    });
    return deferred.promise;
};

pipes.dev.serve = function() {

};

// PROD PIPES
// TODO: clean
pipes.prod.clean = function() {
    var deferred = Q.defer();
    del(paths.distProd, function() {
        deferred.resolve();
    });
    return deferred.promise;
};

pipes.prod.buildVendorScripts = function() {
    return gulp.src(bowerFiles('**/*.js'))
        .pipe(pipes.orderedVendorScripts())
        .pipe(plugins.concat('vendor.min.js'))
        .pipe(plugins.uglify())
        .pipe(gulp.dest(paths.distScriptsProd));
};

// TODO: converts partials to javascript using html2js
pipes.prod.html2js = function() {
    return pipes.app.validatedPartialHtmls()
        .pipe(plugins.htmlhint.failReporter())
        .pipe(plugins.htmlmin({
            collapseWhitespace: true,
            removeComments: true
        }))
        .pipe(plugins.ngHtml2js({
            moduleName: "partialTmpls"
        }));
};

// TODO: builds app for production
pipes.prod.build = function() {

};

// TODO: runs app server for production
pipes.runProd = function() {

};

// === DEFAULT TASK === //
gulp.task('default', ["serve-dev"]);

// === DEVELOPMENT TASKS === //

//clean dist.dev directory
gulp.task('clean-dev', pipes.dev.clean);

//clean and build dist.dev directory
gulp.task('build-dev', function(done) {
    pipes.dev.build();
    done();
});

//builds index.html into dev invironment
gulp.task('build-index-dev', pipes.dev.buildIndex);
gulp.task("watch-index-dev", ["build-index-dev"], pipes.app.browserReload);

//moves app scripts into dev invironment
gulp.task('build-scripts-dev', pipes.dev.buildAppScripts);
gulp.task("watch-scripts-dev", ["build-scripts-dev"], pipes.app.browserReload);

//moves partial scripts into dev invironment
gulp.task('build-partials-dev', pipes.dev.buildPartialHtmls);
gulp.task("watch-partials-dev", ["build-partials-dev"], pipes.app.browserReload);

gulp.task("watch-styles-dev", function() {
    return pipes.dev.buildStyles()
        .pipe(browserSync.stream());
});

// clean, build, and watch live changes to the dev environment
gulp.task('serve-dev', ["build-dev"], function() {

    //start server
    browserSync.init({
        server: {
            baseDir: "./dist.dev"
        }
    });

    //setup watchers for file changes
    gulp.watch(paths.index, ['watch-index-dev']);
    gulp.watch(paths.scripts, ['watch-scripts-dev']);
    gulp.watch(paths.partials, ['watch-partials-dev']);
    gulp.watch(paths.styles, ['watch-styles-dev']);
});

// === PRODUCTION TASKS === //
// TODO: write code for production environment
gulp.task('build-vendor-scripts-prod', function() {
    return gulp.src(bowerFiles('**/*.js'))
        .pipe(pipes.app.orderedVendorScripts())
        .pipe(plugins.uglify())
        .pipe(plugins.concat('vendor.min.js'))
        .pipe(gulp.dest(paths.distScriptsProd));
});

pipes.app.htlmtojs = function () {
    return pipes.app.validatePartialHtmls()
        .pipe(plugins.htmlhint.failReporter())
        .pipe(plugins.htmlmin({
            collapseWhitespace: true,
            removeComments: true
        }))
        .pipe(plugins.ngHtml2js({
            moduleName: "todoPartials"
        }));
};

gulp.task('build-app-scripts-prod', function() {
    var scriptedPartials = pipes.app.htlmtojs();
    var validatedAppScripts = pipes.app.validateScripts();

    return es.merge(scriptedPartials, validatedAppScripts)
        .pipe(pipes.orderedAppScripts())
        .pipe(plugins.sourcemaps.init())
        .pipe(plugins.concat('app.min.js'))
        .pipe(plugins.uglify())
        .pipe(plugins.sourcemaps.write())
        .pipe(gulp.dest(paths.distScriptsProd));
});

gulp.task('clean-prod', pipes.prod.clean);
gulp.task('build-prod', pipes.prod.build);
gulp.task('serve-prod', function() {
    //start server
    browserSync.init({
        server: {
            baseDir: "./dist.prod"
        }
    });
});
