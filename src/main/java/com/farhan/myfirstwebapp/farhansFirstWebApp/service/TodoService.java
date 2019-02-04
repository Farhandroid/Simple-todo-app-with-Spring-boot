package com.farhan.myfirstwebapp.farhansFirstWebApp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.springframework.stereotype.Service;

import com.farhan.myfirstwebapp.farhansFirstWebApp.model.Todo;

@Service
public class TodoService {
	private static ArrayList<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;

	static {
		todos.add(new Todo(1, "in28Minutes", "Learn Spring MVC", new Date(), false));
		todos.add(new Todo(2, "in28Minutes", "Learn Struts", new Date(), false));
		todos.add(new Todo(3, "in28Minutes", "Learn Hibernate", new Date(), false));
	}

	public ArrayList<Todo> retrieveTodos(String user) {
		ArrayList<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo : todos) {
			if(todo!=null)
			{
				if (todo.getUser().equals(user)) {
					filteredTodos.add(todo);
				}
			}
			
		}
		return filteredTodos;
	}

	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
	}

	public void deleteTodo(int id) {
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}
	}
	
	public Todo retrieveTodo(int id) {
		for (Todo todo : todos) {
			if (todo.getId() == id)
				return todo;
		}
		return null;
	}

	public void updateTodo(Todo todo) {
		todos.remove(todo);
		todos.add(todo);
	}
}
