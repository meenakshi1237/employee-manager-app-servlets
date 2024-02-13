package com.helper;

import java.util.ArrayList;
import java.util.List;

import com.entity.Task;
import com.entity.Users;


public class CreateUser {
	public static Users createUser(String name,String email,String password,String role,String designation,double salary) {
		Users user=new Users();
		List<Task> tasks=new ArrayList<Task>();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);
		user.setDesignation(designation);
		user.setSalary(salary);
		user.setTasks(tasks);
		return user;
	}
}
