package com.gestordetareas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.gestordetareas.model.Task;

public interface CrudRepo extends JpaRepository<Task, Integer>, PagingAndSortingRepository<Task, Integer> {

}
