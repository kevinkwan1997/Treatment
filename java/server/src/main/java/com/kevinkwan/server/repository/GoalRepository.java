package com.kevinkwan.server.repository;

import com.kevinkwan.server.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GoalRepository extends JpaRepository<Goal, Long> {

    public Optional<Goal> findById(Long goal_id);

    @Query(value = "SELECT g.goal_name FROM Goal g")
    public List<String> getAllNames();

}
