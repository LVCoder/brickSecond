package com.pmi.brick.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pmi.brick.domain.Task;
import com.pmi.brick.domain.User;

@Component
public interface TaskDao {
	
	public void saveTask(Task task);
	
	public void updateTask(Task task);
	
	public Task getTaskById(int id);
	
	public List<Task> getAllAvaibleTasks(int userID);
	public List<Task> getAllMyBossTasks(int userId);
	
	public List<Task> getAllMyWorkerTasks(int userId);
	

}
