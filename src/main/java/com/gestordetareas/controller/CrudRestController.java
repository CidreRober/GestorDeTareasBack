package com.gestordetareas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestordetareas.model.Task;
import com.gestordetareas.services.CrudService;

@RestController
public class CrudRestController {
	
	@Autowired
	private CrudService service;
	
	@GetMapping("/gettasklist")
	public List<Task> fetchTaskList(){
		List<Task> tasks = new ArrayList<Task>();
		tasks = service.fetchtaskList();
		return tasks;
	}
	
	@PostMapping("/addtask")
	public Task saveTask(@RequestBody Task task){
		return service.saveTaskToDB(task);
	}
	
	@GetMapping("/gettaskbyid/{id}")
	public Task fetchTaskById(@PathVariable int id){
		return service.fetchTaskById(id).get();
	}
	
	@DeleteMapping("/deletetaskbyid/{id}")
	public String deleteTaskById(@PathVariable int id){
		return service.deleteTaskById(id);
	}
	
	@PutMapping ("updatetaskbyid/{id}")
	public String updateTaskById(@PathVariable int id, @RequestBody Task task) {
		return service.modifyTaskToDB(task, id);
	}

	
	
}
