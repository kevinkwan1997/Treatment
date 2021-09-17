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

    @Query(nativeQuery = true, value = "SELECT * FROM Rewards r WHERE level = 3 ORDER BY random() LIMIT 1")
    public Reward getHighDiff();
    
    @Query(nativeQuery = true, value = "SELECT * FROM Rewards r WHERE level = 2 ORDER BY random() LIMIT 1")
    public Reward getMidDiff(); 
    
    @Query(nativeQuery = true, value = "SELECT * FROM Rewards r WHERE level = 1 ORDER BY random() LIMIT 1")
    public Reward getLowDiff();

    @Query(nativeQuery = true, value = "SELECT * FROM Rewards r ORDER BY price ASC LIMIT 1")
    public Reward getDefaultReward();

    @Query(value = "SELECT r.reward_name FROM Reward r")
    public List<String> getRewardNames();


}
