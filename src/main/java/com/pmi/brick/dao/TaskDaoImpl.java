package com.pmi.brick.dao;

import java.util.ArrayList;
import java.util.List;

import com.pmi.brick.domain.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pmi.brick.domain.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

@Transactional
@Repository("taskDao")
public class TaskDaoImpl implements TaskDao {

	@Autowired
	protected SessionFactory sessionFactory;
	
	
	@Override
	public void saveTask(Task task) {
		sessionFactory.getCurrentSession().save(task);
		
	}

	@Override
	public void updateTask(Task task) {
		Session session=sessionFactory.getCurrentSession();
			 session.update(task); 
		
	}

	@Override
	public Task getTaskById(int id) {
		Task task=new Task();
		Session session = null;

		session = sessionFactory.openSession();

		Criteria cr = session.createCriteria(Task.class);
		cr.add(Restrictions.eq("id", id));
		List<Task> results = cr.list();
		 session.close();
		if (results.isEmpty())
			return task;
		else
			task = results.get(0);
		
		return task;
	}
	 
	@Override
	public List<Task> getAllAvaibleTasks(int userId){
		Session session = null;

		session = sessionFactory.openSession();

		Criteria cr = session.createCriteria(Task.class);
		cr.add(Restrictions.eq("status", Task.Status.Active));
		cr.add(Restrictions.not(Restrictions.eq("bossId", userId)));
		List<Task> results =  cr.list();
        session.close();
		return results;
		
	}
	

}
