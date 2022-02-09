package com.gestordetareas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("updatetaskbyid/{id}")
	public String updateTaskById(@PathVariable int id, @RequestBody Task task) {
		return service.modifyTaskToDB(task, id);
	}

	@GetMapping("/gettaskbypage")
	public Page<Task> listar(@RequestParam(name="page")int page, Task task) {
	Pageable pageRequest = PageRequest.of(page, 5);
	Page<Task> tasks = service.findAll(pageRequest);
	return tasks;
}
	
	
}
