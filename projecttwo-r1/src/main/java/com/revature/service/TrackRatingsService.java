package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.DhalTrackRatings;
import com.revature.repositories.TrackRatingsRepository;


@Service
@Transactional
public class TrackRatingsService {

	@Autowired
	private TrackRatingsRepository trackRepo;
	
	public List<DhalTrackRatings> getAll() {
		return trackRepo.findAll();
	}

	public DhalTrackRatings add(DhalTrackRatings u) {
		return trackRepo.save(u);
	}

	public DhalTrackRatings findById(int id) {
		return trackRepo.findOne(id);
	}

	public DhalTrackRatings findByRateId(double id) {
		System.out.println("in find by username");
		return trackRepo.findByRateId(id);
	}

	public DhalTrackRatings update(DhalTrackRatings u) {
		return null;
	}

}