package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.DhalRatings;
import com.revature.repositories.RatingsRepository;


@Service
@Transactional
public class RatingsService {

	@Autowired
	private RatingsRepository ratingsRepo;
	
	public List<DhalRatings> getAll() {
		return ratingsRepo.findAll();
	}

	public DhalRatings add(DhalRatings u) {
		return ratingsRepo.save(u);
	}

	public DhalRatings findById(int id) {
		return ratingsRepo.findOne(id);
	}

	public DhalRatings findByRating(double rating) {
		return ratingsRepo.findByRating(rating);
	}

	public DhalRatings update(DhalRatings u) {
		return null;
	}

}