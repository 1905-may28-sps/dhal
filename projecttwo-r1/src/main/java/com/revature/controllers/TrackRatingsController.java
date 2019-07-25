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

import com.revature.models.DhalTrackRatings;
import com.revature.service.TrackRatingsService;

@RestController
@CrossOrigin("*")
public class TrackRatingsController {

	@Autowired
	private TrackRatingsService service;

	@RequestMapping(value = "/trackrating", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DhalTrackRatings> add(@RequestBody DhalTrackRatings rating) {
		System.out.println(rating);
		DhalTrackRatings u = service.add(rating);
		if (u == null)
			return new ResponseEntity<DhalTrackRatings>(HttpStatus.CONFLICT);
		return new ResponseEntity<DhalTrackRatings>(u, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/trackrating", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DhalTrackRatings>> findAll() {
		List<DhalTrackRatings> dhalTrackRatings = service.getAll();
		if(dhalTrackRatings == null || dhalTrackRatings.size() == 0) return new ResponseEntity<List<DhalTrackRatings>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<DhalTrackRatings>>(dhalTrackRatings, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/trackrating/trackratingId={id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DhalTrackRatings> findByUsername(@PathVariable int id) {
		DhalTrackRatings u = service.findByRateId(id);
		if(u == null ) return new ResponseEntity<DhalTrackRatings>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<DhalTrackRatings>(u, HttpStatus.OK);
	}

}