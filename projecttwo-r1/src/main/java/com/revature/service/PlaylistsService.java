package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.DhalPlaylists;
import com.revature.repositories.PlaylistsRepository;


@Service
@Transactional
public class PlaylistsService {

	@Autowired
	private PlaylistsRepository playlistsRepo;
	
	public List<DhalPlaylists> getAll() {
		return playlistsRepo.findAll();
	}

	public DhalPlaylists add(DhalPlaylists u) {
		return playlistsRepo.save(u);
	}

	public DhalPlaylists findById(int id) {
		return playlistsRepo.findOne(id);
	}

	public DhalPlaylists findByPlaylistId(int id) {
		System.out.println("in find by username");
		return playlistsRepo.findByPlaylistId(id);
	}

	public DhalPlaylists update(DhalPlaylists u) {
		return null;
	}

	

}