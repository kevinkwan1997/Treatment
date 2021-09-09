package com.kevinkwan.server.service;

import com.kevinkwan.server.model.Goal;
import com.kevinkwan.server.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    public List<String> getGoalNames() {
        List<String> names = new ArrayList<>();
        goalRepository.getAllNames().forEach(names::add);
        return names;
    }

    public List<Goal> getAllGoals() {
        List<Goal> goals = new ArrayList<>();
        goalRepository.findAll().forEach(goals::add);
        return goals;
    }

    public Optional<Goal> getGoal(Long id) {
        Optional<Goal> goal = null;
        goal = goalRepository.findById(id);
        return goal;
    }

   public void addGoal(Goal goal) {
        goalRepository.saveAndFlush(goal);
    }

    public void updateGoal(Long id, Goal goal) {
        goalRepository.save(goal);
    }

    public void deleteGoal(Long id) {
        goalRepository.deleteById(id);
    }

}
