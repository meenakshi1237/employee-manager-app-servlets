package com.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateEntitys {
		public static EntityManagerFactory factory=Persistence.createEntityManagerFactory("vikas");
		public static EntityManager manager=factory.createEntityManager();
		public static EntityTransaction transaction=manager.getTransaction();
		
}
