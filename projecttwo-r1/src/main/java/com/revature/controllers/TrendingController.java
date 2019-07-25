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

import com.revature.models.DhalTrending;
import com.revature.service.TrendingService;

@RestController
@CrossOrigin("*")
public class TrendingController {

	@Autowired
	private TrendingService service;

	@RequestMapping(value = "/trending", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DhalTrending> add(@RequestBody DhalTrending trend) {
		System.out.println(trend);
		DhalTrending u = service.add(trend);
		if (u == null)
			return new ResponseEntity<DhalTrending>(HttpStatus.CONFLICT);
		return new ResponseEntity<DhalTrending>(u, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/trending", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DhalTrending>> findAll() {
		List<DhalTrending> dhalTrend = service.getAll();
		if(dhalTrend == null || dhalTrend.size() == 0) return new ResponseEntity<List<DhalTrending>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<DhalTrending>>(dhalTrend, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/trending/trendingId={id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DhalTrending> findByUsername(@PathVariable int id) {
		DhalTrending u = service.findByTrendId(id);
		if(u == null ) return new ResponseEntity<DhalTrending>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<DhalTrending>(u, HttpStatus.OK);
	}

}