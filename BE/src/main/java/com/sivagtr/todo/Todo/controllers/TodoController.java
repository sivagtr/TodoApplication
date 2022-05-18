package com.sivagtr.todo.Todo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivagtr.todo.Todo.constants.Constants;
import com.sivagtr.todo.Todo.exceptions.TodoException;
import com.sivagtr.todo.Todo.model.Task;
import com.sivagtr.todo.Todo.services.TodoService;

@RestController
@RequestMapping(Constants.BASE_API_V1)
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping(Constants.VERSION_API)
	public ResponseEntity<String> getVersion() {
		return ResponseEntity.ok(todoService.getVersion());
	}

	@GetMapping(Constants.TASK_ALL_API)
	public ResponseEntity<List<Task>> getAllTodoList() {
		try {
			List<Task> all = todoService.getAllTodoList();
			return ResponseEntity.ok(all);
		} catch(TodoException ex) {
			return ResponseEntity.internalServerError().build();
		}
	}


	@GetMapping(Constants.TASK_WITH_ID_API)
	public ResponseEntity<Task> getTaskById(@PathVariable("id") String taskId) {
		Task task = todoService.getTaskById(taskId);
		return ResponseEntity.ok(task);
	}

	@PostMapping(Constants.TASK_API)
	public ResponseEntity<String> createTask(@RequestBody Task task) {
		String id = todoService.createTask(task);
		return ResponseEntity.ok(id);
	}

	@PutMapping(Constants.TASK_WITH_ID_API)
	public ResponseEntity<Void> updateTask(@PathVariable("id") String taskId, @RequestBody Task task) {
		todoService.updateTask(taskId, task);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(Constants.TASK_WITH_ID_API)
	public ResponseEntity<Void> deleteTaskById(@PathVariable("id") String taskId) {
		todoService.deleteTaskById(taskId);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(Constants.TASK_LIST_API)
	public ResponseEntity<Void> deleteTaskByList(@RequestBody List<String> taskList) {
		todoService.deleteTaskByList(taskList);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(Constants.TASK_ALL_API)
	public ResponseEntity<Void> deleteAllTask() {
		todoService.deleteAllTask();
		return ResponseEntity.noContent().build();
	}

}
