package com.farhan.myfirstwebapp.farhansFirstWebApp.service;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhan.myfirstwebapp.farhansFirstWebApp.model.Todo;


public interface TodoRepository extends JpaRepository<Todo, Integer> {
	ArrayList<Todo> findByUser(String user);
}
