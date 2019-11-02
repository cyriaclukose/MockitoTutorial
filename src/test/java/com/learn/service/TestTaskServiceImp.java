package com.learn.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.learn.dao.TaskServiceDao;

public class TestTaskServiceImp {
	
	
	@InjectMocks
	private TaskServiceImp taskServiceImp;
	
	@Mock
	private  TaskServiceDao mocktaskServiceDao;
	
	private Task task1;
	
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
	   task1=new Task("java1","1");
	}
	
	@Test
	public void testCreateTask()
	{
		Mockito.when(mocktaskServiceDao.getTask(anyString())).thenReturn(task1);
		Task actual=taskServiceImp.getTask("dummy");
		
		assertEquals(task1,actual);
		verify(mocktaskServiceDao,times(1)).getTask(anyString());
		
	}

}
