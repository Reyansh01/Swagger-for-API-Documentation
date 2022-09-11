package com.Spring.SimpleSwagger.controller;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.SimpleSwagger.entity.Person;



@RestController
@RequestMapping("/api")
public class SwaggerController {
	
	ConcurrentMap<String, Person> map = new ConcurrentHashMap<>();
	
	@GetMapping(value = "/hello/{id}")
	public Person getHello(@PathVariable String id) {
		return map.get(id);
//		System.out.println("Hello this is swagger implementation..");
	}
	
	
}
