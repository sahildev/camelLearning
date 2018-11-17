package com.spring.myapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.myapp.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * 
	 * @return
	 */
	@GetMapping("/getUser")
	public Map<String, Object> getRandomUser() {

		return userService.getRandomUser();

	}

}
