package com.learn.dao;

import java.util.List;

import com.learn.service.Task;

public interface taskDoa {
	
	
	
	
	/**
	 * 
	 * @param task
	 */
	public void createTask(Task task);
	
	
	/**
	 * 
	 * @param taskName
	 * @return
	 */
	public Task getTask(String taskName);
	
	
	/**
	 * 
	 * @param taskName
	 * @return
	 */
	 public List<Task >getAllTask();
	
	

}
