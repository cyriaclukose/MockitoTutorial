package com.learn.service;

import java.util.List;

import com.learn.dao.TaskServiceDao;
import com.learn.dao.taskDoa;

public class TaskServiceImp implements TaskService {

	private taskDoa taskServiceDao;

	public TaskServiceImp(taskDoa taskServiceDao) {
		this.taskServiceDao = taskServiceDao;
	}

	@Override
	public void createTask(Task task) {
		// TODO Auto-generated method stub

	}

	@Override
	public Task getTask(String name) {
		// TODO Auto-generated method stub
		return taskServiceDao.getTask(name);
	}

	@Override
	public List<Task> getAllTAsks() {
		// TODO Auto-generated method stub
		return taskServiceDao.getAllTask();
	}

	@Override
	public Task deleteTask(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
