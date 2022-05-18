package com.sivagtr.todo.Todo.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Task")
public class Task implements Serializable {

	@Id
	private String id;
	private String name;
	private Details details;
}
