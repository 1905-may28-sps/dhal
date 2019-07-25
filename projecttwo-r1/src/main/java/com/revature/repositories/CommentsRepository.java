package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.DhalComments;


@Repository
public interface CommentsRepository extends JpaRepository<DhalComments, Integer>{
	DhalComments findByCommentsId(int id);
	
}