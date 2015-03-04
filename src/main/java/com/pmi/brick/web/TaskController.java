package com.pmi.brick.web;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pmi.brick.domain.Task;
import com.pmi.brick.domain.TaskRequest;
import com.pmi.brick.domain.TaskRequest.Status;
import com.pmi.brick.domain.User;
import com.pmi.brick.service.TaskRequestService;
import com.pmi.brick.service.TaskService;

@Controller
public class TaskController extends MainController {

	@Autowired
	TaskService taskService;
	@Autowired
	TaskRequestService taskRequestService;

	//перегляд сторінки завдання по ID 
	//сторінка формуються в залежності від того хто її переглядає
	//якщо переглядає BOSS то є можливість редагування, прийняття заявок на виконання та 
	//відхилення заявок.
	@RequestMapping(value = "/task/{taskId}", method = RequestMethod.GET)
	public ModelAndView showTaskById(@PathVariable("taskId") Integer taskId) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("task");
		Task task = new Task();
		User boss = new User();

		task = taskService.getTaskById(taskId);
		boss = userService.getUserById(task.getBossId());

		modelAndView.addObject("currentTask", task);
		modelAndView.addObject("boss", boss);
		// незалежно від того хто переглядає сторінку, подаємо статус завдання
		Task.Status taskStatus=task.getStatus();
		 String taskStatusText = null;
			switch(taskStatus){
			case Active:
				taskStatusText = "Активний";
				break;
			case InProcess:
				taskStatusText = "Виконується";
				break;
			case Done:
				taskStatusText = "Виконано";
				break;
			case Deleted:
				taskStatusText = "Видалено";
				break;
			default:
				break;
			}
			 modelAndView.addObject("taskStatusText",taskStatusText);
		//додамо посилання на редагування завдання, якщо залогований користувач є роботодавцем
		if(getCurrentLogedUser().getId()==task.getBossId()){
		   String editTaskButton = "<a href=\"edit/"+taskId+"\"> Редагувати</a>";
		   modelAndView.addObject("editTaskButton",editTaskButton);
		   modelAndView.addObject("taskRequestsList",taskRequestService.getTaskRequestsByTaskId(taskId));
		   //якщо виконевець ще не вибраний
		   if(task.getWorkerId()==0){
			   Map<TaskRequest, User> map=new LinkedHashMap<TaskRequest, User>();
			  List<TaskRequest> list=taskRequestService.getTaskRequestsByTaskId(taskId);
			  for(TaskRequest taskRequest : list){
			   User worker=userService.getUserById(taskRequest.getWorkerId());
				  map.put(taskRequest,worker);
			  }
				  modelAndView.addObject("taskRequestAndWorkersMap",map);
			 
			  
			   
		   }
		   //якщо виконавець уже вибраний.
		   else
		   {
			   User worker=new User();
			   worker= userService.getUserById(task.getWorkerId());
			   modelAndView.addObject("worker",worker);
		   }
		}
		//в іншому випадку
		//додамо інформацію про статус запиту, якщо користувач відправив його
		else{
				if(taskRequestService.getTaskRequestByTaskIdAndUserId(getCurrentLogedUser().getId(), taskId)!=null ){
				Status status=taskRequestService.getTaskRequestByTaskIdAndUserId(getCurrentLogedUser().getId(), taskId).getStatus();
				 String requestStatusText = null;
				switch(status){
				case Declined:
					requestStatusText = "Роботодавець відхилив вашу заявку.";
					break;
				case InProcess:
					requestStatusText = "Ви уже подали заявку на виконання завдання.";
					break;
				case Terminated:
					requestStatusText = "На жаль, це завдання уже виконує інший виконавець.";
					break;
				case Withdrew:
					requestStatusText = "Ви відкликали свою заявку на виконання";
					break;
				case Submited:
					requestStatusText= "Вашу заявку підверджено.";
					break;
				default:
					break;
					
					
					
					}
			
				   modelAndView.addObject("requestStatusText",requestStatusText);
				}
				
				else{
		//додамо посилання на подачу заявки на виконання завдання,
	    //якщо залогований користувач має на це право і не відправляв заявок
				if(getCurrentLogedUser().getId()!=task.getBossId()&&task.getWorkerId()==0){
				   String takeTaskButton = "<a href=\"take/"+taskId+"\"> Виконати</a>";
				   modelAndView.addObject("takeTaskButton",takeTaskButton);
				}
				}
	
		}
		return modelAndView;

	}

	// форма створення завдання
	@RequestMapping(value = "/task/create", method = RequestMethod.GET)
	public ModelAndView showCreateTaskForm() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("createTask");

		return modelAndView;

	}

	//відсилання форми створення завдання
	@RequestMapping(value = "/task/create", method = RequestMethod.POST)
	public String createTaskFromForm(@ModelAttribute("task") Task task) {

		Date dateobj = new Date();

		task.setBossId(getCurrentLogedUser().getId());
		task.setPostDate(dateobj);
		task.setStatus(Task.Status.Active);
		taskService.addTask(task);

		return "redirect:/task/" + task.getId();

	}

	//перегляд усіх доступних завдання, переадресація на 1-шу сторінку зі списку
	@RequestMapping(value = "/task/avaible", method = RequestMethod.GET)
	public ModelAndView showAvaibleTasks() {

		return new ModelAndView("redirect:/task/avaible/1");

	}

	//перегляд доступних для виконання завдань за номером сторінки
	@RequestMapping(value = "/task/avaible/{pageNumber}", method = RequestMethod.GET)
	public ModelAndView showAllAvaibleTasks(
			@PathVariable("pageNumber") int pageNumber) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("task/avaibleTasks");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Task> tasks = taskService.getAllAvaibleTasks(getCurrentLogedUser().getId());
		int pagesCount = tasks.size() / 10 + 1; // count of pages with tasks (10
												// tasks on 1 page)
		map.put("taskObj", tasks);
		map.put("pagesCount", pagesCount);
		map.put("thisPageNumber", pageNumber);
		return new ModelAndView("task/avaibleTask", map);

	}
	//перегляд усіх створених мною, переадресація на 1-шу сторінку зі списку
		@RequestMapping(value = "/task/myTasks", method = RequestMethod.GET)
		public ModelAndView showMyTasksFirstPage() {

			return new ModelAndView("redirect:/task/myTasks/1");

		}

	//перегляд всіх створених мною завдань
	@RequestMapping(value = "/task/myTasks/{pageNumber}", method = RequestMethod.GET)
	public ModelAndView showAllMyTasks(
			@PathVariable("pageNumber") int pageNumber) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("task/avaibleTasks");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Task> tasks = taskService.getAllMyBossTasks(getCurrentLogedUser().getId());
		int pagesCount = tasks.size() / 10 + 1; // count of pages with tasks (10
												// tasks on 1 page)
		map.put("taskObj", tasks);
		map.put("pagesCount", pagesCount);
		map.put("thisPageNumber", pageNumber);
		return new ModelAndView("task/avaibleTask", map);

	}


	
	
	//редагування завдання по його ID, якщо користувач має на це право
	@RequestMapping(value = "/task/edit/{taskId}", method = RequestMethod.GET)
	public ModelAndView createEditTaskForm(@PathVariable("taskId") int taskId) {

		Task task = new Task();
		task = taskService.getTaskById(taskId);
		if (task.getBossId()==getCurrentLogedUser().getId()){
			
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("task/editTask");
			modelAndView.addObject("task", task);
		
			return modelAndView;
			
		}
		else {
		
			return (new ModelAndView("errors/error403"));
		}
	}

	//відправлення форми редагування завдання
	@RequestMapping(value = "/task/edit/{taskId}", method = RequestMethod.POST)
	public ModelAndView editTaskFromForm(
			@PathVariable("taskId") Integer taskId,
			@ModelAttribute("task") Task task) {
		Task curTask = new Task();
		curTask = taskService.getTaskById(taskId);
		curTask.setSameProperties(task);
		taskService.updateTask(curTask);

		return new ModelAndView("redirect:/task/" + taskId);
	}
	@RequestMapping(value = "/task/take/{taskId}", method = RequestMethod.GET)
	public ModelAndView takeTask(
			@PathVariable("taskId") Integer taskId) {
		
		Task task=taskService.getTaskById(taskId);
		if(getCurrentLogedUser().getId()!=task.getBossId()&&task.getWorkerId()==0){
	        TaskRequest taskRequest =new TaskRequest();
	        taskRequest.setDate(new Date());
            taskRequest.setTaskId(taskId);
            taskRequest.setWorkerId(getCurrentLogedUser().getId());
            taskRequest.setStatus(Status.InProcess);
            taskRequestService.saveTaskRequest(taskRequest);
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.setViewName("task");
            modelAndView.addObject("currentTask", taskService.getTaskById(taskId));
            modelAndView.addObject("requestMessage", "Ви подали заявку на виконання цього завдання");
			return modelAndView;
		}
		else
		return new ModelAndView("error403");
	}
	
	@RequestMapping(value = "/task/setWorker/{taskId}/{workerId}",method=RequestMethod.GET)
	public  ModelAndView setWorker(@PathVariable("taskId") Integer taskId,@PathVariable("workerId") Integer workerId) throws Exception{
		Task task=new Task();
		task=taskService.getTaskById(taskId);
		if(task.getBossId()==getCurrentLogedUser().getId()){
		taskService.setWorker(taskId.intValue(), workerId.intValue());
		return new ModelAndView("redirect:/task/"+taskId);}
		else
			return new ModelAndView("redirect:/errors/error404");
		
	}
	
}
