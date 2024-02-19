package com.example.resttemplate.springbootresttemplate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.resttemplate.springbootresttemplate.dto.UserDetailsDTO;
import com.example.resttemplate.springbootresttemplate.service.UserService;
@RestController
@RequestMapping("/api")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
	
	
	 @GetMapping("/fetchData")
	    public ResponseEntity<List<UserDetailsDTO>> getUsersFromUrl() {
	        String url = "https://jsonplaceholder.typicode.com/users";
	        List<UserDetailsDTO> userDetailsDTOList = userService.fetchDataFromUrl(url);
	        return ResponseEntity.ok(userDetailsDTOList);
	    }

}
