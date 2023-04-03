package com.projectbaby.Project.baby.repository;

import com.projectbaby.Project.baby.model.entity.activity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ActivityRepository extends JpaRepository <Activity, Long> {

}