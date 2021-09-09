package com.kevinkwan.server.service;

import com.kevinkwan.server.model.Reward;
import com.kevinkwan.server.repository.GoalRepository;
import com.kevinkwan.server.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RewardService {

    @Autowired
    private RewardRepository rewardRepository;

    public String getRewardHighlight() {
        String highlight = rewardRepository.getRewardHighlight();
        return highlight;
    }

    public List<String> getRewardNames() {
        List<String> names = rewardRepository.getRewardNames();
        return names;
    }

    public List<Reward> getAllRewards() {
        List<Reward> rewards = new ArrayList<>();
        rewardRepository.findAll().forEach(rewards::add);
        return rewards;
    }

    public Optional<Reward> getReward(Long id) {
        Optional<Reward> goal = null;
        goal = rewardRepository.findById(id);
        return goal;
    }

    public BigDecimal getTotalPriceOfRewards() {
        List<Reward> rewards = new ArrayList<>();
        return rewardRepository.getTotal();
    }
    public void addReward(Reward rwd) {
        rewardRepository.saveAndFlush(rwd);
    }

    public void updateReward(Long id, Reward rwd) {
        rewardRepository.save(rwd);
    }

    public void deleteReward(Long id) {
        rewardRepository.deleteById(id);
    }

    public List<String> getHighDiffReward() {
        List<String> rewards = null;
        rewards = rewardRepository.getHighDiff();
        return rewards;
    }



}
