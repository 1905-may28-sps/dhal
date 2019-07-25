package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.DhalTrackRatings;


@Repository
public interface TrackRatingsRepository extends JpaRepository<DhalTrackRatings, Integer>{
	DhalTrackRatings findByRateId(double id);
	
}