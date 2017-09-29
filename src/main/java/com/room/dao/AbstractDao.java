package com.room.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public  abstract class AbstractDao {

	@Autowired
	   private SessionFactory sessionFactory;
		
	   protected Session getSession(){
		    return this.sessionFactory.getCurrentSession();
	   }
}
