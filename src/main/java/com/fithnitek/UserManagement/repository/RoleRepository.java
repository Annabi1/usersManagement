package com.fithnitek.UserManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fithnitek.UserManagement.model.Role;

public interface RoleRepository extends JpaRepository<Role,String> {

}
