package com.socialmedia.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "retweets")
public class Retweets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int retweetId;
	
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id")
	    private Users users;
	 

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "tweet_id")
	    private Tweets tweets;
	
	
	
}
