package com.learn.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.learn.dao.TaskServiceDao;
import com.learn.dao.taskDoa;

@RunWith(MockitoJUnitRunner.class)
public class TestTaskServiceImplWithRunner {
	
	
	
/**
 * inject dependencies	
 */
@InjectMocks 
private TaskServiceImp taskService;

//mock the dao layer
@Mock
private taskDoa mockDao;


private Task task;

private List<Task> taskList;

@Captor
private ArgumentCaptor<String> argementCaapture;




@Before
public void setUp()
{
	
//	MockitoAnnotations.initMocks(this);
	
	taskList=new ArrayList<>();
	 task=new Task("mongoDb", "james");
	 Task task2=new Task("Spring", "george");
	 taskList.add(task);
	 taskList.add(task2);
	}




/**
 * here we will verify the 
 * arguments
 * check the behaviour 
 * verify the method calls
 */

@Test
public void testGetTask()
{

	when(mockDao.getTask(anyString())).thenReturn(task);
	when(mockDao.getAllTask()).thenReturn(taskList);
	List<Task> allTask=taskService.getAllTAsks();
	Task dummytask1=taskService.getTask("dummy1");
	Task dummytask2=taskService.getTask("dummy2");    
	
	//check the behavior
	assertEquals(task,dummytask1);
	assertEquals(2,allTask.size());
	
	//verifyMethod calls
  
    verify(mockDao,times(2)).getTask(argementCaapture.capture());
    List<String> values=argementCaapture.getAllValues();
    //cpature the argument
    
    assertEquals("dummy1",values.get(0));
    assertEquals("dummy2",values.get(1));
    verify(mockDao,atLeastOnce()).getAllTask();
    verify(mockDao,never()).createTask(any(Task.class));
  
    InOrder inorder=inOrder(mockDao);
    inorder.verify(mockDao).getAllTask();
    inorder.verify(mockDao,times(2)).getTask(anyString());
   
   
    
    
}

}
