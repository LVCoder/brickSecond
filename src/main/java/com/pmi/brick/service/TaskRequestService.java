package com.pmi.brick.service;

import java.util.List;

import com.pmi.brick.domain.TaskRequest;

public interface TaskRequestService {
	
	public void saveTaskRequest(TaskRequest taskRequest);
	public void deleteTaskRequest(TaskRequest taskRequest);
	public List<TaskRequest> getTaskRequstsByWorkerId(int workerId);
	public List<TaskRequest> getTaskRequestsByTaskId(int taskId);
	public TaskRequest getTaskRequestById(int id);
	public boolean checkIfRequestFromUserExist(int userId,int taskId);
    public TaskRequest getTaskRequestByTaskIdAndUserId(int userId,int taskId);

}
