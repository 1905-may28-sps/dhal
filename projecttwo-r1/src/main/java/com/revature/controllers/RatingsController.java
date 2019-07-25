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

import com.revature.models.DhalRatings;
import com.revature.service.RatingsService;

@RestController
@CrossOrigin("*")
public class RatingsController {

	@Autowired
	private RatingsService service;

	@RequestMapping(value = "/ratings", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DhalRatings> add(@RequestBody DhalRatings rating) {
		System.out.println(rating);
		DhalRatings u = service.add(rating);
		if (u == null)
			return new ResponseEntity<DhalRatings>(HttpStatus.CONFLICT);
		return new ResponseEntity<DhalRatings>(u, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/ratings", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DhalRatings>> findAll() {
		List<DhalRatings> dhalRatings = service.getAll();
		if(dhalRatings == null || dhalRatings.size() == 0) return new ResponseEntity<List<DhalRatings>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<DhalRatings>>(dhalRatings, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/ratings/ratings={rating}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DhalRatings> findByUsername(@PathVariable double rating) {
		DhalRatings u = service.findByRating(rating);
		if(u == null ) return new ResponseEntity<DhalRatings>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<DhalRatings>(u, HttpStatus.OK);
	}

}