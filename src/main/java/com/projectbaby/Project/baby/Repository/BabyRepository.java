package com.projectbaby.Project.baby.Repository;

import com.projectbaby.Project.baby.Model.Baby;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface BabyRepository extends JpaRepository<Baby, Integer> {
}
