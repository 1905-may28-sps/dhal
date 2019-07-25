package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.DhalTrending;

@Repository
public interface TrendingRepository extends JpaRepository<DhalTrending, Integer>{
	DhalTrending findByTrendId(int id);
	
}