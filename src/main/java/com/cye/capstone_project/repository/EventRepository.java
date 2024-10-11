package com.cye.capstone_project.repository;

import com.cye.capstone_project.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
