package com.pmi.brick.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.pmi.brick.dao.UserDao;
import com.pmi.brick.dao.UserDaoImpl;
import com.pmi.brick.domain.Task;
import com.pmi.brick.domain.User;
import com.pmi.brick.exception.EmailAlreadyExistsException;
import com.pmi.brick.service.TaskService;
import com.pmi.brick.service.TaskServiceImpl;
import com.pmi.brick.service.UserService;
import com.pmi.brick.service.UserServiceImpl;

@Controller
public class TaskController extends MainController {

	@Autowired
	TaskService taskService;

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
		//додамо посилання на редагування завдання, якщо залогований користувач є роботодавцем
		if(getCurrentLogedUser().getId()==task.getBossId()){
		   String editTaskButton = "<a href=\"edit/"+taskId+"\"> Редагувати</a>";
		   modelAndView.addObject("editTaskButton",editTaskButton);
		}
		//додамо посилання на подачу заявки на виконання завдання,
	    //якщо залогований користувач має на це право
				if(getCurrentLogedUser().getId()!=task.getBossId()&&task.getWorkerId()==0){
				   String takeTaskButton = "<a href=\"take/"+taskId+"\"> Виконати</a>";
				   modelAndView.addObject("takeTaskButton",takeTaskButton);
				}
		return modelAndView;

	}

	@RequestMapping(value = "/task/create", method = RequestMethod.GET)
	public ModelAndView showCreateTaskForm() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("createTask");

		return modelAndView;

	}

	@RequestMapping(value = "/task/create", method = RequestMethod.POST)
	public String createTaskFromForm(@ModelAttribute("task") Task task) {

		Date dateobj = new Date();

		task.setBossId(getCurrentLogedUser().getId());
		task.setPostDate(dateobj);
		task.setStatus("1");
		taskService.addTask(task);

		return "redirect:/task/" + task.getId();

	}

	@RequestMapping(value = "/task/avaible", method = RequestMethod.GET)
	public ModelAndView showAvaibleTasks() {

		return new ModelAndView("redirect:/task/avaible/1");

	}

	@RequestMapping(value = "/task/avaible/{pageNumber}", method = RequestMethod.GET)
	public ModelAndView showAllAvaibleTasks(
			@PathVariable("pageNumber") int pageNumber) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("task/avaibleTasks");
		Map map = new HashMap();
		List<Task> tasks = taskService.getAllAvaibleTasks();
		int pagesCount = tasks.size() / 10 + 1; // count of pages with tasks (10
												// tasks on 1 page)
		map.put("taskObj", tasks);
		map.put("pagesCount", pagesCount);
		map.put("thisPageNumber", pageNumber);
		return new ModelAndView("task/avaibleTask", map);

	}

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
	     
			return new ModelAndView("/task/"+taskId);
		}
		else
		return new ModelAndView("error403");
	}
}
