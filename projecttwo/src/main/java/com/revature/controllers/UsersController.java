package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.DhalUsers;
import com.revature.service.UsersService;

@RestController
@CrossOrigin("*")
public class UsersController {

	@Autowired
	private UsersService service;

	@RequestMapping(value = "/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DhalUsers> add(@RequestBody DhalUsers user) {
		System.out.println(user);
		DhalUsers u = service.add(user);
		if (u == null)
			return new ResponseEntity<DhalUsers>(HttpStatus.CONFLICT);
		return new ResponseEntity<DhalUsers>(u, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DhalUsers>> findAll() {
		List<DhalUsers> dhalUsers = service.getAll();
		if(dhalUsers == null || dhalUsers.size() == 0) return new ResponseEntity<List<DhalUsers>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<DhalUsers>>(dhalUsers, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users/username={name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DhalUsers> findByUsername(@PathVariable String name) {
		DhalUsers u = service.findByUsername(name);
		if(u == null ) return new ResponseEntity<DhalUsers>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<DhalUsers>(u, HttpStatus.OK);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DhalUsers> findByUsername(@RequestBody DhalUsers loginInfo){
		System.out.println(loginInfo.toString());
		DhalUsers user = service.login(loginInfo);
		if (user != null) {
			user.setPassword("");
			return new ResponseEntity<DhalUsers>(user, HttpStatus.OK);
		}
		return new ResponseEntity<DhalUsers>(HttpStatus.UNAUTHORIZED);
	}
	
}