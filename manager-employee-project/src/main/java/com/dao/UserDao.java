package com.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.entity.Task;
import com.entity.Users;
import com.helper.CreateEntitys;

public class UserDao {
	Users user=new Users();
	EntityManagerFactory entityfactory=CreateEntitys.factory;
	EntityManager entitymanager=CreateEntitys.manager;
	EntityTransaction entitytransaction=CreateEntitys.transaction;
	public Users saveUser(Users user) {
		entitytransaction.begin();
		entitymanager.persist(user);
		entitytransaction.commit();
		return user;
	}
	
	public Users loginUser(String email,String password) {
		Users user=null;
		Query qry=entitymanager.createQuery("select user from Users user where user.email=?1 and user.password=?2");
		qry.setParameter(1, email);
		qry.setParameter(2, password);
		List<Users> users=qry.getResultList();
		if(users!=null && users.size()>0) {
			user=users.get(0);
		}
		return user;
	}
	
	public List<Task> viewTasks(Users user){
		List<Task> tasks=user.getTasks();
		return tasks;
	}
	
	public List<Users> getAllUsers(){
		Query qry=entitymanager.createQuery("select user from Users user where user.role='Employee'");
		List<Users> users=qry.getResultList();
		if(users!=null) {
			return users;
		}
		else {
			return null;
		}
	}
	
	public List<Task> getEmployeeTasks(Users user){
		List<Task> tasks=user.getTasks();
		if(tasks!=null && tasks.size()>0) {
			for(int i=0;i<tasks.size();i++) {
				for(int j=i+1;j<tasks.size();j++) {
					if(tasks.get(i).getStatus().charAt(0)>tasks.get(j).getStatus().charAt(0)) {
						Task temp=tasks.get(i);
						tasks.set(i, tasks.get(j));
						tasks.set(j, temp);
					}
				}
			}
			return tasks;
		}
		else {
			return null;
		}
		
	}
	
	
	
}
