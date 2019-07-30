package com.revature.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.DhalComments;
import com.revature.models.DhalPlaylists;


@Repository
public interface CommentsRepository extends JpaRepository<DhalComments, Integer>{
	
	DhalComments findByCommentsId(int id);
	
	List<DhalComments> findByPlaylist(DhalPlaylists p);
		
	}
	
