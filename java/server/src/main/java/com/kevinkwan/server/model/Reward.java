package com.kevinkwan.server.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "rewards")
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "reward_name")
    private String reward_name;

    @Column(name = "reward_desc")
    private String reward_desc;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name ="level")
    private Integer level;


    public Reward(String reward_name, String reward_desc, BigDecimal price, Integer level){
        this.id = id;
        this.reward_name = reward_name;
        this.reward_desc = reward_desc;
        this.price = price;
        this.level = level;
    }

    public Reward() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReward_name() {
        return reward_name;
    }

    public void setReward_name(String reward_name) {
        this.reward_name = reward_name;
    }

    public String getReward_desc() {
        return reward_desc;
    }

    public void setReward_desc(String reward_desc) {
        this.reward_desc = reward_desc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}