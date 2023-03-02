package com.projectbaby.Project.baby.repository;

import com.projectbaby.Project.baby.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {

}
