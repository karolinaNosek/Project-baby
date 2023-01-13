package com.projectbaby.Project.baby.repository;

import com.projectbaby.Project.baby.model.Baby;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface BabyRepository extends JpaRepository<Baby, Integer> {

}
