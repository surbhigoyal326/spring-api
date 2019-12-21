package com.angular.rest.webservices.angularweb.service.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class HardCodedTodos {

	
	private static List<Todo> todos = new ArrayList();
	private static long idCounter = 0;
	
	static {
		todos.add(new Todo(++idCounter, "admin", "learn angular", new Date(), false));
		todos.add(new Todo(++idCounter, "admin", "learn spring", new Date(), false));
		todos.add(new Todo(++idCounter, "admin", "learn hibernate", new Date(), false));
		todos.add(new Todo(++idCounter, "admin", "learn JPA", new Date(), false));
	}
	
	public Todo save(Todo todo) {
		if(todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			deleteTodo(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo deleteTodo(long id) {
		Todo todo = findById(id);
		if(todo==null) return null;
		if(todos.remove(todo)) return todo;
			return null;
		
	}
	
	public Todo findById(long id) { 
		for(Todo todo: todos) {
			if(todo.getId() == id) {
				return todo;
		}
		
	}
		return null;
}
}
