package com.projectbaby.Project.baby.repository;

import com.projectbaby.Project.baby.activity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ActivityRepository extends JpaRepository <Activity, Long> {

}