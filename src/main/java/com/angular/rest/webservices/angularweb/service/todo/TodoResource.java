
package com.angular.rest.webservices.angularweb.service.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin
@RestController
public class TodoResource {
     
	@Autowired
	private HardCodedTodos hardCodedTodos;
	
	@GetMapping(path = "/user/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return hardCodedTodos.findAll();
	}
	     
	@GetMapping(path = "/user/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable long id){
		return hardCodedTodos.findById(id);
	}
	
	@DeleteMapping(path = "/user/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
		Todo todo = hardCodedTodos.deleteTodo(id);
		if(todo!=null) {
			return ResponseEntity.noContent().build();		
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping(path = "/user/{username}/todos_update/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id,
			@RequestBody Todo todo){
		Todo updatedTodo = hardCodedTodos.save(todo);
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}  
	
	@PostMapping(path = "/user/{username}/todos_added")
	public ResponseEntity<Void> addTodo(@PathVariable String username,
			@RequestBody Todo todo){
		Todo createdTodo = hardCodedTodos.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
