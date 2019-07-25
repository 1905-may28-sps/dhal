package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.DhalRatings;

@Repository
public interface RatingsRepository extends JpaRepository<DhalRatings, Integer>{
	DhalRatings findByRating(double rating);
	
}