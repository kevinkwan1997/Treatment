package com.kevinkwan.server.controller;

import com.kevinkwan.server.model.Goal;
import com.kevinkwan.server.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class GoalController {

    @Autowired
    GoalService goalService;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/goals/names")
    public List<String> getGoalNames() {
        return goalService.getGoalNames();
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/goals")
    public List<Goal> getAllGoals() {
        return goalService.getAllGoals();
    }

    @RequestMapping("/goals/{id}")
    public Optional<Goal> getGoalById(@PathVariable Long id) {
        return goalService.getGoal(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/goals")
    public void addGoal(@RequestBody Goal goal) {
        goalService.addGoal(goal);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/goals/{id}")
    public void updateGoal(@PathVariable Long id, @RequestBody Goal goal) {
        goalService.updateGoal(id, goal);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/goals/{id}")
    public void deleteGoal(@PathVariable Long id) {
        goalService.deleteGoal(id);
    }

}
