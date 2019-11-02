package com.learn.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.learn.service.Task;

/**
 * 
 * @author Cyriac Lukose
 *
 */
public class TaskServiceDao implements taskDoa {
	
	
	private static Map<String,Task> TaskMap=new HashMap<>();
	
	
	
	public  static  void  LoadTasks()
	{
		
		Task task1=new Task("java1","1");
		Task task2=new Task("spring1","5");
		Task task3=new Task("java2","4");
		Task task4=new Task("spring2","8");
		TaskMap.put(task1.getTaskname(), task1);
		TaskMap.put(task2.getTaskname(), task2);
		TaskMap.put(task3.getTaskname(), task3);
		TaskMap.put(task4.getTaskname(), task4);
		
	}
	
	
	/**
	 * 
	 * @param task
	 */
	public void createTask(Task task)
	{
		TaskMap.put(task.getTaskname(), task);
	}
	
	
	/**
	 * 
	 * @param taskName
	 * @return
	 */
	public Task getTask(String taskName)
	{
		System.out.println("implementation for getTask is called with name : "+taskName);
		LoadTasks();
		return TaskMap.get(taskName);
	}
	
	
	/**
	 * 
	 * @param taskName
	 * @return
	 */
	 public List<Task >getAllTask()
	{
		 System.out.println("implementation for getAllTask is called");
		 LoadTasks();
		return (List<Task>) TaskMap.values();
	}
	

}
