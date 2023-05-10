package com.socialmedia.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class Users  implements UserDetails{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	private String username;
	
	
	private String displayName;
	
	private String email;
	
	private String password;
	
	private String bio;

	
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


	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<SimpleGrantedAuthority> authorities =	this.roles.stream()
				.map((role)->new SimpleGrantedAuthority(role.getName()))
						.collect(Collectors.toList());
			
			return authorities;
		
	}
	
	@Override
	public String getUsername() {
		
		return this.email;
	}


	@Override
	public boolean isAccountNonExpired() {

		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}


	@Override
	public boolean isEnabled() {
	
		return true;
	}

}
