package com.kevinkwan.server.controller;

import com.kevinkwan.server.model.Reward;
import com.kevinkwan.server.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class RewardController {

    @Autowired
    RewardService rewardService;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/rewards/highlight")
    public String getRewardHighlight() {
        return rewardService.getRewardHighlight();
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/rewards")
    public List<Reward> getAllRewards() {
        return rewardService.getAllRewards();
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/reward-names")
    public List<String> getAllRewardNames() { return rewardService.getRewardNames(); }

    @RequestMapping("/rewards/{id}")
    public Optional<Reward> getRewardById(@PathVariable Long id) {
        return rewardService.getReward(id);
    }

    @RequestMapping("/rewardtotal")
    public BigDecimal getTotalForRewards() { return rewardService.getTotalPriceOfRewards();}

    @RequestMapping(method = RequestMethod.POST, value = "/rewards")
    public void addReward(@RequestBody Reward rwd) {
        rewardService.addReward(rwd);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/rewards/{id}")
    public void updateReward(@PathVariable Long id, @RequestBody Reward rwd) {
        rewardService.updateReward(id, rwd);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/rewards/{id}")
    public void deleteReward(@PathVariable Long id) {
        rewardService.deleteReward(id);
    }

    @RequestMapping("/rewards/high")
    public List<String> getHighDiffRewards() { return rewardService.getHighDiffReward();}

}
