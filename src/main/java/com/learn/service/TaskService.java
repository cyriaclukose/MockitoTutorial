package com.learn.service;

import java.util.List;

public interface TaskService {
	
	
  public void createTask(Task task);
  
  public Task getTask(String name);
  
  public List<Task> getAllTAsks();
  
  public Task deleteTask(String name);

}
