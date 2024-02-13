package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transaction;

import com.entity.Task;
import com.entity.Users;
import com.helper.CreateEntitys;

public class TaskDao {
	
	EntityManagerFactory entitymanagerfactory=CreateEntitys.factory;
	EntityManager entitymanager=CreateEntitys.manager;
	EntityTransaction entitytransaction=CreateEntitys.transaction;
	
	public Task addTask(Task task,int empid) {
		if(task!=null) {
			Users user=entitymanager.find(Users.class, empid);
			List<Task> tasks=user.getTasks();
			tasks.add(task);
			user.setTasks(tasks);
			
			entitytransaction.begin();
			entitymanager.persist(task);
			entitymanager.merge(user);
			entitytransaction.commit();
			
			return task;
		}
		else {
			return null;
		}
	}
	public List<Task> getAllTasks(){
		Query  qry=entitymanager.createQuery("select tasks from Task tasks");
		List<Task> tasks=qry.getResultList();
		if(tasks!=null && tasks.size()>0) {
			return tasks;
		}
		return  null;
	}
	
	public Task changeStatus(int taskid,String status) {
		Task task=entitymanager.find(Task.class, taskid);
		
		if(task!=null) {
			task.setStatus(status);
			entitytransaction.begin();
			entitymanager.merge(task);
			entitytransaction.commit();
		}
		return task;
	}
}
