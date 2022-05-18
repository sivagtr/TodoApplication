package com.sivagtr.todo.Todo.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Details implements Serializable {
	private String description;
	private long createdAt;
	private Priority priority = Priority.MEDIUM;
}
