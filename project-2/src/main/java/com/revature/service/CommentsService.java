package com.revature.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.DhalComments;
import com.revature.models.DhalPlaylists;
import com.revature.repositories.CommentsRepository;


@Service
@Transactional
public class CommentsService {

	@Autowired
	private CommentsRepository commentsRepo;
	
	public List<DhalComments> getAll() {
		return commentsRepo.findAll();
	}

	public DhalComments add(DhalComments u) {
		return commentsRepo.save(u);
	}

	public DhalComments findById(int id) {
		return commentsRepo.findOne(id);
	}

	public DhalComments findByCommentsId(int id) {
		return commentsRepo.findByCommentsId(id);
	}

	public DhalComments update(DhalComments u) {
		return null;
	}
	
	public List<DhalComments>  findByPlaylist(DhalPlaylists p) {
		return commentsRepo.findByPlaylist(p);
	}

}