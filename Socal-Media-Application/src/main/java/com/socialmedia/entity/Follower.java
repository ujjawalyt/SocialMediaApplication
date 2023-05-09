package com.socialmedia.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Follower {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int followerId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_user_id")
    private Users followerUser;
	
	
	
}
