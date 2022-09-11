package com.Spring.SimpleSwagger.controller;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.SimpleSwagger.entity.Person;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/apianother")
public class AnotherController {
		
	ConcurrentMap<String, Person> map = new ConcurrentHashMap<>();
		
	@ApiOperation(value = "but this is bye..",
			notes = "This is basically a Bye API",
			response = Person.class)
	@GetMapping(value = "/bye/{id}")
	public Person getHello(@PathVariable String id) {
		return map.get(id);
//			System.out.println("Hello this is swagger implementation..");
	}
}
