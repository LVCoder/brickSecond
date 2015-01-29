package com.pmi.brick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmi.brick.dao.TaskDao;
import com.pmi.brick.dao.TaskRequestDao;
import com.pmi.brick.domain.TaskRequest;

@Service
public class TaskRequestServiceImpl implements TaskRequestService {

	@Autowired
	private TaskRequestDao taskRequestDao;

	@Override
	public void saveTaskRequest(TaskRequest taskRequest) {

		taskRequestDao.saveTaskRequest(taskRequest);
	}

	@Override
	public void deleteTaskRequest(TaskRequest taskRequest) {
		taskRequestDao.deleteTaskRequest(taskRequest);

	}

	@Override
	public List<TaskRequest> getTaskRequstsByWorkerId(int workerId) {
		
		return taskRequestDao.getTaskRequstsByWorkerId(workerId);
	}

	@Override
	public List<TaskRequest> getTaskRequestsByTaskId(int taskId) {
		
		return taskRequestDao.getTaskRequestsByTaskId(taskId);
	}

	@Override
	public TaskRequest getTaskRequestById(int id) {
		
		return taskRequestDao.getTaskRequestById(id);
	}

}
