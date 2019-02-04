package com.farhan.myfirstwebapp.farhansFirstWebApp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.farhan.myfirstwebapp.farhansFirstWebApp.model.Todo;
import com.farhan.myfirstwebapp.farhansFirstWebApp.service.TodoRepository;
import com.farhan.myfirstwebapp.farhansFirstWebApp.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@Autowired
	TodoService todoService;
	
	@Autowired
	TodoRepository repository;

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodo(ModelMap modelMap) {
		modelMap.put("todoList", repository.findByUser(getLoggedInUserName(modelMap)));
		///modelMap.put("todoList", todoService.retrieveTodos(getLoggedInUserName(modelMap)));
		return "list-todos";
	}

	private String getLoggedInUserName(ModelMap modelMap) {
		return (String) modelMap.get("name");
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddOrUpdateTodoPage(ModelMap modelMap) {
		modelMap.addAttribute("todo", new Todo());
		return "addOrUpdateTodo";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(@Valid Todo todo,BindingResult result,ModelMap modelMap) {
		if(result.hasErrors())
		{
			return "addOrUpdateTodo";
		}
		
		todo.setUser(getLoggedInUserName(modelMap));
		repository.save(todo);
		///todoService.addTodo(getLoggedInUserName(modelMap), todo.getDesc(), todo.getTargetDate(), false);
		return "redirect:/list-todos";
	}
	

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		repository.deleteById(id);
		//todoService.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id,ModelMap modelMap) {
		Todo todo=repository.getOne(id);
		///Todo todo=todoService.retrieveTodo(id);
		modelMap.put("todo", todo);
		return "addOrUpdateTodo";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(@Valid Todo todo,BindingResult result,ModelMap modelMap) {
         System.out.println("todo data ; "+todo.toString());
		if(result.hasErrors())
		{
			return "addOrUpdateTodo";
 
		}
		todo.setUser(getLoggedInUserName(modelMap));
		repository.save(todo);
		//todoService.updateTodo(todo);
		return "redirect:/list-todos";
	}
}
