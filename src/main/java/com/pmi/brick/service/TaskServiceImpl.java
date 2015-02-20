package com.pmi.brick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pmi.brick.dao.TaskDao;
import com.pmi.brick.domain.Task;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao taskDao;
	
	@Override
	public void addTask(Task task) {
		taskDao.saveTask(task);
		
	}

	@Override
	public Task getTaskById(int id) {
		
		
	
		return taskDao.getTaskById(id);
	
	}
	
	@Override
	public List<Task> getAllAvaibleTasks(int userId){
		
		
		return taskDao.getAllAvaibleTasks(userId);
		
	}

	@Override
	public void updateTask(Task task) {
    
		taskDao.updateTask(task);
	
	}


	public void setWorker(int taskId, int workerId) throws Exception {
		Task task=new Task();
		task=taskDao.getTaskById(taskId);
		if(task.getWorkerId()==0){
		task.setWorkerId(workerId);
		task.setStatus(Task.Status.InProcess);
		taskDao.updateTask(task);
		}
		else throw new Exception("Worker is already setted");
	}

}
