package com.pmi.brick.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pmi.brick.domain.TaskRequest;

@Component
public interface TaskRequestDao {
	
	public void saveTaskRequest(TaskRequest taskRequest);
	public void deleteTaskRequest(TaskRequest taskRequest);
	public List<TaskRequest> getTaskRequstsByWorkerId(int workerId);
	public List<TaskRequest> getTaskRequestsByTaskId(int taskId);
	public TaskRequest getTaskRequestById(int id);
	
	

}
