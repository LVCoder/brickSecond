package com.pmi.brick.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pmi.brick.domain.TaskRequest;
@Transactional
@Repository("taskRequestDao")

public class TaskRequestDaoImpl implements TaskRequestDao {

	@Autowired
	protected SessionFactory sessionFactory;
	
	@Override
	public void saveTaskRequest(TaskRequest taskRequest) {
		sessionFactory.getCurrentSession().save(taskRequest);
		

	}

	@Override
	public void deleteTaskRequest(TaskRequest taskRequest) {
		sessionFactory.getCurrentSession().delete(taskRequest);
	}

	@Override
	public List<TaskRequest> getTaskRequstsByWorkerId(int workerId) {
		Session session = null;
		session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(TaskRequest.class);
		cr.add(Restrictions.eq("workerId", workerId));
		@SuppressWarnings("unchecked")
		List<TaskRequest> results = cr.list();
        session.close();
		return results;
		
	}

	@Override
	public List<TaskRequest> getTaskRequestsByTaskId(int taskId) {
		Session session = null;
		session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(TaskRequest.class);
		cr.add(Restrictions.eq("taskId", taskId));
		@SuppressWarnings("unchecked")
		List<TaskRequest> results = cr.list();
        session.close();
		return results;
	}
	@Override
	public TaskRequest getTaskRequestById(int id) {
		Session session = null;
		session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(TaskRequest.class);
		cr.add(Restrictions.eq("id", id));
		TaskRequest result = (TaskRequest) cr.uniqueResult();
        session.close();
		return result;
	}

}
