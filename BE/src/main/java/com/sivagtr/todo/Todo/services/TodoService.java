package com.sivagtr.todo.Todo.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.sivagtr.todo.Todo.constants.Constants;
import com.sivagtr.todo.Todo.exceptions.TodoException;
import com.sivagtr.todo.Todo.inf.TodoServiceInf;
import com.sivagtr.todo.Todo.model.Task;
import com.sivagtr.todo.Todo.repository.TodoRepository;

@Service
public class TodoService implements TodoServiceInf {

	@Autowired
	TodoRepository repository;

	@Autowired
	MongoOperations mongoOperations;

	public String getVersion() {
		return "v1.0";
	}

	public List<Task> getAllTodoList() {
		List<Task> all = repository.findAll();
		return all;
	}

	public Task getTaskById(String taskId) {
		Optional<Task> task = repository.findById(taskId);
		return task.orElse(null);
	}

	public String createTask(Task task) {
		task.getDetails().setCreatedAt(Instant.now().toEpochMilli());
		Task createdTask = repository.save(task);
		return createdTask.getId();
	}

	public void updateTask(String taskId, Task updatedTask) {
		Optional<Task> byId = repository.findById(taskId);
		Supplier<TodoException> todoExceptionSupplier = () -> new TodoException(Constants.UPDATE_ERROR);
		Task task = byId.orElseThrow(todoExceptionSupplier);
		if(task != null) {
			updatedTask.setId(task.getId());
			long createdAt = task.getDetails().getCreatedAt();
			updatedTask.getDetails().setCreatedAt(createdAt);
			repository.save(updatedTask);
		}
	}

	public void deleteTaskById(String taskId) {
		repository.deleteById(taskId);
	}

	public void deleteTaskByList(List<String> taskList) {
		taskList.forEach(task -> repository.deleteById(task));
	}

	public void deleteAllTask() {
		repository.deleteAll();
	}

}
