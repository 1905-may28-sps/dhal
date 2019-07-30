package com.revature.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.DhalComments;
import com.revature.models.DhalPlaylists;


@Repository
public interface PlaylistsRepository extends JpaRepository<DhalPlaylists, Integer>{
	
	DhalPlaylists findByPlaylistId(int id);

	DhalPlaylists findByOwnerId(int id);

	DhalPlaylists findByName(String name);

	List<DhalPlaylists> findListByOwnerId(int id);
	


	
}