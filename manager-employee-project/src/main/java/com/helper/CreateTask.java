package com.helper;

import com.entity.Task;

public class CreateTask {
	public static Task createTask(String description,String status) {
		Task task=new Task();
		task.setDescription(description);
		task.setStatus(status);
		return task;
	}
}
