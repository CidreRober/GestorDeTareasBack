package com.gestordetareas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gestordetareas.model.Task;
import com.gestordetareas.repo.CrudRepo;

@Service
public class CrudService {

	@Autowired
	public CrudRepo repo;
	
	public List<Task> fetchtaskList() {
		return repo.findAll();
	}
	
	public Task saveTaskToDB(Task task) { 
		return repo.save(task);
	}
	
	public Optional<Task> fetchTaskById(int id) {
		return repo.findById(id);
	}
	
	public String deleteTaskById(int id) {
		String result;
		try {
			repo.deleteById(id);
			result = "task deleted succesfull";
		} catch (Exception e) {
			result = "task with id is not deleted";
		}
		
		return result;
	}
	
	public String modifyTaskToDB(Task task, int id) {
		String result;
		try {
			repo.save(task);
			result = "task modified succesfull";
		} catch (Exception e) {
			result = "task with id is not modified";
		}
		return result;
	}
	
	public Page<Task> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}
}
