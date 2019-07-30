package com.revature.models;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="dhal_playlists")
public class DhalPlaylists {
	
	@Id
	@Column(name="playlist_id")
	@SequenceGenerator(name="dhal_playlist_trigger", sequenceName="dhal_playlists_seq", allocationSize=1)
	@GeneratedValue(generator="dhal_playlist_trigger", strategy=GenerationType.SEQUENCE)
	private int playlistId;
	
	@Column(name="track_id", nullable=false)
	private int trackId;
	
	@Column(name="comment_id", nullable=false)
	private int commentId;
	
	@Column(name="owner_id", nullable=false)
	private int ownerId;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="user_playlist_id", nullable=false)
	private int userPlaylistId;
	
//	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinColumn(name="comment_id")
//	private DhalComments id;
//	
//	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinTable(name="user_comments",
//	joinColumns=@JoinColumn(name="user_playlist_id"),
//	inverseJoinColumns=@JoinColumn(name="comment_id"))
//	private List<DhalComments> userComments;
//	
//	@OneToMany(mappedBy="playlist", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	private List<DhalComments> comment;
//	

	public DhalPlaylists() {}


	public DhalPlaylists(int playlistId, int trackId, int commentId, int ownerId, String name, int userPlaylistId,
			DhalComments id, List<DhalComments> userComments, List<DhalComments> comment) {
		super();
		this.playlistId = playlistId;
		this.trackId = trackId;
		this.commentId = commentId;
		this.ownerId = ownerId;
		this.name = name;
		this.userPlaylistId = userPlaylistId;
	
	}


	public int getPlaylistId() {
		return playlistId;
	}


	public void setPlaylistId(int playlistId) {
		this.playlistId = playlistId;
	}


	public int getTrackId() {
		return trackId;
	}


	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}


	public int getCommentId() {
		return commentId;
	}


	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}


	public int getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getUserPlaylistId() {
		return userPlaylistId;
	}


	public void setUserPlaylistId(int userPlaylistId) {
		this.userPlaylistId = userPlaylistId;
	}
//
//
//	public DhalComments getId() {
//		return id;
//	}
//
//
//	public void setId(DhalComments id) {
//		this.id = id;
//	}
//
//
//	public List<DhalComments> getUserComments() {
//		return userComments;
//	}
//
//
//	public void setUserComments(List<DhalComments> userComments) {
//		this.userComments = userComments;
//	}
//
//
//	public List<DhalComments> getComment() {
//		return comment;
//	}


//	public void setComment(List<DhalComments> comment) {
//		this.comment = comment;
//	}




	
}