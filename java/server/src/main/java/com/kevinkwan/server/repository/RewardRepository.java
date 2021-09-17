package com.kevinkwan.server.repository;

import com.kevinkwan.server.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface RewardRepository extends JpaRepository <Reward, Long> {

    public Optional<Reward> findById(Long goal_id);

    @Query("SELECT SUM(r.price) FROM Reward r")
    public BigDecimal getTotal();

    @Query(value = "SELECT r.reward_name, r.reward_desc, r.price, r.level FROM Reward r WHERE r.level = 3")
    public List<Reward> getHighDiff();
    
    @Query(value = "SELECT r.reward_name, r.reward_desc, r.price, r.level FROM Reward r WHERE r.level = 2")
    public List<Reward> getMidDiff(); 
    
    @Query(value = "SELECT r.reward_name, r.reward_desc, r.price, r.level FROM Reward r WHERE r.level = 1")
    public List<Reward> getLowDiff();

    @Query(nativeQuery = true, value = "SELECT * FROM Rewards r ORDER BY price ASC LIMIT 1")
    public Reward getDefaultReward();

    @Query(value = "SELECT r.reward_name FROM Reward r")
    public List<String> getRewardNames();


}
