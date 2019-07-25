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

import com.revature.models.DhalComments;
import com.revature.service.CommentsService;

@RestController
@CrossOrigin("*")
public class CommentsController {

	@Autowired
	private CommentsService service;

	@RequestMapping(value = "/comments", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DhalComments> add(@RequestBody DhalComments comments) {
		System.out.println(comments);
		DhalComments u = service.add(comments);
		if (u == null)
			return new ResponseEntity<DhalComments>(HttpStatus.CONFLICT);
		return new ResponseEntity<DhalComments>(u, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/comments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DhalComments>> findAll() {
		List<DhalComments> dhalComments = service.getAll();
		if(dhalComments == null || dhalComments.size() == 0) return new ResponseEntity<List<DhalComments>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<DhalComments>>(dhalComments, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/comments/commentId={id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DhalComments> findByUsername(@PathVariable int id) {
		DhalComments u = service.findByCommentsId(id);
		if(u == null ) return new ResponseEntity<DhalComments>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<DhalComments>(u, HttpStatus.OK);
	}

}