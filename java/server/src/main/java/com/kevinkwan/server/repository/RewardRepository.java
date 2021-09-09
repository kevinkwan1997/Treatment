package com.kevinkwan.server.repository;

import com.kevinkwan.server.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface RewardRepository extends JpaRepository <Reward, Long> {

    public Optional<Reward> findById(Long goal_id);

    @Query("SELECT SUM(r.price) FROM Reward r")
    public BigDecimal getTotal();

    @Query(value = "SELECT r.reward_name FROM Reward r GROUP BY reward_name, r.price HAVING r.price > (SUM(r.price)/2)")
    public List<String> getHighDiff();

    @Query(nativeQuery = true, value = "SELECT r.reward_name FROM Rewards r ORDER BY price DESC LIMIT 1")
    public String getRewardHighlight();

    @Query(value = "SELECT r.reward_name FROM Reward r")
    public List<String> getRewardNames();


}
