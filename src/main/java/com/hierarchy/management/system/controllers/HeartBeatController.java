package com.hierarchy.management.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/heartbeat")
@CrossOrigin
public class HeartBeatController {
	
	@Autowired
	ObjectMapper mapper;
	
	@GetMapping("/check")
	public ResponseEntity<ObjectNode> checkAppStatus(){
		String message = "success";
		ObjectNode responseObject = mapper.createObjectNode();
		responseObject.put("attempt", message);
		return new ResponseEntity<ObjectNode>(responseObject, HttpStatus.OK);
	} 
	

}
