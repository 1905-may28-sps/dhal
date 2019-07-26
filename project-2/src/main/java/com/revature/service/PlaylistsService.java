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
	
		return playlistsRepo.findByPlaylistId(id);
	}
	
	public DhalPlaylists findByName(String name) {

		return playlistsRepo.findByName(name);
	}
	
	public DhalPlaylists findByOwnerId(int id) {

		return playlistsRepo.findByOwnerId(id);
	}

	public DhalPlaylists update(DhalPlaylists u) {
		return null;
	}

	

}