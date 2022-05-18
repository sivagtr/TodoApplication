package com.sivagtr.todo.Todo.inf;

import java.util.List;

import com.sivagtr.todo.Todo.model.Task;

import lombok.NonNull;

public interface TodoServiceInf {
	String getVersion();

	List<Task> getAllTodoList();

	Task getTaskById(@NonNull String taskId);

	String createTask(@NonNull Task task);

	void updateTask(@NonNull String taskId, @NonNull Task task);

	void deleteTaskById(@NonNull String taskId);

	void deleteTaskByList(List<String> taskList);

	void deleteAllTask();
}
