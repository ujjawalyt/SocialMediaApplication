package com.socialmedia.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class Users {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(name ="user_name", nullable =  false, length =100)
	private String username;
	
	@Column(name ="display_name", nullable =  false, length =100)
	private String displayName;
	
	private String email;
	
	private String password;
	
	private String bio;
	@Column(name ="created_At", nullable =  false, length =100)
	
	private LocalDateTime createAt;
	

	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	List<Tweets> tweets = new ArrayList<>();
	
	@OneToMany(mappedBy = "users",cascade =  CascadeType.ALL)
	List<Likes> likes = new ArrayList<>();
	
	@OneToMany(mappedBy = "users",cascade =  CascadeType.ALL)
	List<Follower> follower =new ArrayList<>();
	
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="user_role",
	joinColumns = @JoinColumn(name="user_id",referencedColumnName = "userId"),
    inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "roleId")
			)
	private List<Role>roles = new ArrayList<>();

}
