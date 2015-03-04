package com.pmi.brick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pmi.brick.dao.TaskDao;
import com.pmi.brick.dao.UserDao;
import com.pmi.brick.domain.Task;

public interface TaskService {

	
	
	public void addTask(Task task);
	public void  updateTask(Task task);
	
	
	public Task getTaskById(int id);
	
	public List<Task> getAllAvaibleTasks(int userId);
	
	public List<Task> getAllMyBossTasks(int userId);
	
	public List<Task> getAllMyWorkerTasks(int userId);
	
	
	public void setWorker(int taskId,int workerId) throws Exception;
}
