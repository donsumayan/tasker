# Tasker - A simple todo application #
---
## Instructions to run WebApp ##

**To run on local dev environment, Make sure you to have these installed:**

1. git from https://git-scm.com/
3. node from https://nodejs.org/en/

**Once you downloaded and installed node, run these commands:**

1. run **"npm install -g bower"** to install the bower package to global
2. run **"npm install -g gulp-cli"** to install gulp to global
3. run **"bower install"** to install all front end dependencies
4. run **"npm install"** to install all development dependencies

**You can run the dev-server by running either of these commands:**

* **"npm start"** or
* **"gulp serve-dev"**

Once you entered those commands, it will automatically open a browser showing the WebApp running on local server

---

## Instructions to run WebService ##

###Prerequisites###

* JDK 8
> * Be sure that your JAVA_HOME environment variable points to the jdk1.8.0 folder extracted from the JDK download.

* MySQL database
> * If you are planning on using a different database other than the default database used by the project, please use a MySQL database.
For a quick installation/setup of MySQL and a local MySQL database on Windows, please head over to: http://dev.mysql.com/downloads/installer/ and download the appropriate installer for your system (32/64 bit).

* Database configuration
> * The project is set to connect to the "todo" MySQL database located at 107.180.102.51.
To configure the project to connect your local MySQL database, open the jdbc.properties file located at src/main/webapp/WEB-INF directory and change the values to your corresponding local database's properties.
> * To create the necessary tables for an empty database, open the hibernate.cfg.xml file located at src/main/resources directory and change the value for the "hibernate.hbm2ddl.auto" property from "update" to "create" and run the project.

###Working with Tasker in Eclipse/STS###

###Prequisites###

**The following items should be installed in your system:**

+ Maven 2.9
> git command line tool (https://help.github.com/articles/set-up-git)
+ Eclipse with the m2e plugin (m2e is installed by default when using the STS (http://www.springsource.org/sts) distribution of Eclipse)
> Note: when m2e is available, there is an m2 icon in Help -> About dialog. If m2e is not there, just follow the install process here: http://eclipse.org/m2e/download/

+ Apache Tomcat/Pivotal tc Server
> Eclipse's guide on installing a Tomcat server (http://help.eclipse.org/mars/index.jsp?topic=%2Forg.eclipse.jst.server.ui.doc.user%2Ftopics%2Ftomcat.html)
> Note: If you are using STS, you may use the bundled Pivotal tc Server.

**Steps:**

1. Check out sources
	In the command line:
		git clone https://bitbucket.org/isr_project_team/todo_app.git
2. Inside Eclipse/STS
* File -> Import -> Maven -> Existing Maven project
* Eclipse/STS should download all the dependencies automatically, however, if you want to make sure that the dependencies are downloaded, you may right-click the project and select Maven -> Update project.

3. After all the dependencies have been downloaded, compile, build the project and run the project on the server.

**Documentation**

* Tasker's API documentation can be found here: http://104.199.150.68/tasker-api/swagger-ui.html

---

## Setting up JUnit and Mockito: ##

Inorder for you to run and test Tasker web app's test classes inside src/test/controllers,
you need to install JUnit and Mockito dependencies in your pom.xml file.
Append these code stub in your pom.xml file:

    <dependencies>
    
    <!-- Test start-->
         <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.7</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>1.10.19</version>
        </dependency>

    <!-- Test end-->

    </dependencies>

By appending these code stub, you are allowing your project to utilize JUnit and Mockito utilities.

** Testing the Web application: **

Check your project in your Package Explorer and go to src/test/controllers,
you can see 4 (test) classes namely, AuthTest.java, RoleTest.java, TodoTest.java and UserTest.java. To test these test clasees, all you need to do is simply right click one of the test classes, e.g. AuthTest.java, and hover over the 'Run As' option and choose JUnit Test.

** Other Setup: **

If by any chance you cannot see the JUnit Test when you hover over the 'Run As' option of your desired test class, just right click the src/test directory and hover over the 'Build Path' option. From there, you can see this option 'Use as Source Folder', simply click on it and hoose your desired test class to test by right clicking on it, hover the 'Run As' option and click the JUnit Test.

** Checking the results: **

To check whether it contains Failures or Errors in your test classes, check the JUnit windows (if you cannot find it, check the 'Windows' menu item in your STS, hover to 'Show View' and 'Other' and key in 'JUnit' and click it away.) In that window, we can see items such as Runs, Errors and Failures. These items(Rnus, Errors and Failures) item will display the total methods performed by the JUnit, the total errors performed by the JUnit and the total failures performed by the JUnit respectively. If you got 1 error under Errors item, that means you have an error in your code, perhaps you have an exception. As for the Failures item, if you have this, possibly it indicates that one of your test cases fail. Cheers!

----

**Authors:***

* **Alajas, Fealrone** -- Test, Server Side Development
* **Montesclaros, Vincent** -- API, Server Side Development
* **Sumayan,Donraedel P. Sumayan** -- Client Side Design & Development

