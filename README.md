# MockitoTutorial
mockito basics
Here we will demonstrate how we can use mockito mocks in the unit testing of a class
Mocks(the object instances which simulate the behaviour of class) helps in unit testing
of class with out the undesirable side effects of the dependent class.Usually mockito is used in
conjunction with junit framework

There are many steps

1.Adding the junit and mockito dependencies

</dependency>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
		</dependency>
		<dependency>
			<groupId>org.mockito</groupId>
			<artifactId>mockito-all</artifactId>
			<version>1.10.19</version>
		</dependency>

2.Informing the test class to use mockito frame work to init mocks.The following are the ways of doing that
 a.Annote with @RunWith(MockitoJUnitRunner.class)
 or 
 b.MockitoAnnotation.initMOcks(CLass<?>)
 
 3.Create the mocks  using @mock annotation
 
  @Mock
  private taskDoa mockDao;
  4.Inject the mocks into the class under test using @InjectMocks annotation
     @InjectMocks 
     private TaskServiceImp taskService;
  5. @Captor annottation can be used to capture the arguments
  
  @Captor
   private ArgumentCaptor<String> argementCaapture;

 6.@Spy annotation can be used instead of @Mock if we want to make the real calls
 
 
7. mock the behaviour of the mock method calls using wehn and thenReturn or doReturn and When

   when(mockDao.getTask(anyString())).thenReturn(task);
	when(mockDao.getAllTask()).thenReturn(taskList);
  
   argunment matchers lie anyString or anyInt or anyClass(class<?>) can used to mock the method arguments
   
8.Perform the test on the class  and match the expexted and actual result with assert statement.
  We could also verify the method calla using the verify method and capture the arguments using argumentcaptor and 
  verify the order of the calls using inorder method


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


