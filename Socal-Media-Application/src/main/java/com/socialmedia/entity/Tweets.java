package com.socialmedia.entity;

import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "tweets")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tweets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tweetId;
	
	@Column(name ="content",  length =280)
	private String content;
	
	@Column(name ="created_At", length =100)
	private LocalDateTime createAt;
	
	@ManyToOne
	@JoinColumn(name ="user_id")
	private Users users;
	
	
	
}
