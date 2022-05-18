package com.sivagtr.todo.Todo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sivagtr.todo.Todo.model.Task;

@Repository("Todo")
public interface TodoRepository extends MongoRepository<Task, String> {
}
