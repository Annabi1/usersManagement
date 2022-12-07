package com.fithnitek.UserManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fithnitek.UserManagement.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findUserByEmail(String emaill);

}
