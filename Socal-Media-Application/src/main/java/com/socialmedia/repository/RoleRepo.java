package com.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialmedia.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
