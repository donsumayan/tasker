package com.comp.tasker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.comp.tasker.constants.Views;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * Model for a todo.
 * 
 * @author Vincent Montesclaros
 *
 */
@Entity
@Table(name = "TODO")
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private long id;

	@Column(name = "note", nullable = false)
	private String note;

	@Column(name = "is_done", nullable = false)
	private Boolean isDone;

	@Column(name = "date_created", nullable = false)
	private Date dateCreated;

	@Column(name = "date_updated", nullable = false)
	private Date dateUpdated;

	@JsonView(Views.Admin.class)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	public Todo() {

	}

	public Todo(String note, Boolean isDone, Date dateCreated, Date dateUpdated, User user) {
		this.note = note;
		this.isDone = isDone;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
