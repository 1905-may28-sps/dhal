package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.DhalTrending;

import com.revature.repositories.TrendingRepository;

@Service
@Transactional
public class TrendingService {

	@Autowired
	private TrendingRepository trendRepo;

	public List<DhalTrending> getAll() {
		return trendRepo.findAll();
	}

	public DhalTrending add(DhalTrending u) {
		return trendRepo.save(u);
	}

	public DhalTrending findById(int id) {
		return trendRepo.findOne(id);
	}

	public DhalTrending findByTrendId(int id) {
		return trendRepo.findByTrendId(id);
	}

	public DhalTrending update(DhalTrending u) {
		return null;
	}

}