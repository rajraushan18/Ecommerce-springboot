package com.project.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.user.beans.User;

public interface UserRepository extends JpaRepository<User, String> {

}
