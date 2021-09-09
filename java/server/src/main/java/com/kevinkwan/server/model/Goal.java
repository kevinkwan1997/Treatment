package com.kevinkwan.server.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "goals")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long goal_id;
    @Column(name="goal_name")
    private String goal_name;
    @Column(name="goal_desc")
    private String goal_desc;
    @Column(name="difficulty")
    private Integer difficulty;

    public Goal(String goal_name, String goal_desc, Integer difficulty) {
        this.goal_id = goal_id;
        this.goal_name = goal_name;
        this.goal_desc = goal_desc;
        this.difficulty = difficulty;
    }

    public Goal() {

    }

    public String getGoal_name() {
        return goal_name;
    }

    public void setGoal_name(String goal_name) {
        this.goal_name = goal_name;
    }

    public String getGoal_desc() {
        return goal_desc;
    }

    public void setGoal_desc(String goal_desc) {
        this.goal_desc = goal_desc;
    }

    public long getGoal_id() {
        return goal_id;
    }

    public void setGoal_id(long id) {
        this.goal_id = id;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

}
