package com.learn.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.learn.dao.TaskServiceDao;
/**
 * when we are using a spy the real implementation is called
 * and it could result in state change for the instance of the spy bean unlike
 * mock
 * @author Cyriac Lukose
 *
 */
public class TestServiceUsingSpy {
	
	
	
	/**
	 * inject dependencies	
	 */
	@InjectMocks 
	private TaskServiceImp taskService;

	//mock the dao layer
	@Spy
	private TaskServiceDao mockDao;


	private Task task;

	private List<Task> taskList;

	@Captor
	private ArgumentCaptor<String> argementCaapture;
	
	@Before
	
	public void setUp()
	{
		
		MockitoAnnotations.initMocks(this);
		taskList=new ArrayList<>();
		 task=new Task("mongoDb", "5");
		 Task task2=new Task("Spring", "10");
		 taskList.add(task);
		 taskList.add(task2);
	}


	@Test
	public void testService() {
		
		when(mockDao.getTask("dummy")).thenReturn(task);
		Task dummyTask=taskService.getTask("dummy");
		Task javatask=taskService.getTask("java2");
		assertEquals(dummyTask,task);
		
		assertEquals(javatask,task);
		
	
	}

}
