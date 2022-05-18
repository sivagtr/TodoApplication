package com.sivagtr.todo.Todo.constants;

public interface Constants {
	String BASE_API_V1 = "/api/v1";

	String UPDATE_ERROR = "Unable to update the task";
	String VERSION_API = "/version";

	String TASK_API = "/task";
	String TASK_ALL_API = TASK_API + "/all";
	String TASK_WITH_ID_API = TASK_API + "/{id}";
	String TASK_LIST_API = TASK_API + "/list";
}
