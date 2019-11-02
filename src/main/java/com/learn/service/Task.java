package com.learn.service;

public class Task {
	
	private String taskname;
	private String taskDuration;
	
	
	/**
	 * @param taskname
	 * @param taskDuration
	 */
	public Task(String taskname, String taskDuration) {
		super();
		this.taskname = taskname;
		this.taskDuration = taskDuration;
	}
	/**
	 * 
	 * @return the taskname
	 */
	public String getTaskname() {
		return taskname;
	}
	/**
	 * @param taskname the taskname to set
	 */
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	/**
	 * @return the taskDuration
	 */
	public String getTaskDuration() {
		return taskDuration;
	}
	/**
	 * @param taskDuration the taskDuration to set
	 */
	public void setTaskDuration(String taskDuration) {
		this.taskDuration = taskDuration;
	}
	@Override
	public String toString() {
		return "Task [taskname=" + taskname + ", taskDuration=" + taskDuration + "]";
	}
	
	

}
