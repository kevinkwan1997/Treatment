<template>
  <div class="wrapper">
    <div class="goals">
    <h1 id = "overview-header">Goals</h1>
      <overview-goals/>
    </div>
    <div class="rewards">
      <h1 id="reward-header">Rewards</h1>
      <overview-rewards/>
    </div>
  </div>
</template>

<script>
import OverviewGoals from './OverviewGoals.vue';
import OverviewRewards from './OverviewRewards.vue';
export default {
  data() {
    return {
    
    }
  },
  components: {
      OverviewGoals,
      OverviewRewards
  },
  methods: {
  }

}
</script>

<style scoped>
.wrapper{
    margin-top: 40px;
    display: flex;
    width: 90%;
    max-height: 85%;
    background-color: rgba(255, 255, 255, 0.8);
    position: fixed;
    top: 48%;
    left: 50%;
    transform: translate(-50%, -50%);
    height: 85%; 
    overflow-y: hidden;
    overflow-x: hidden;
    justify-content: space-evenly;

}

#overview-header{
  padding: 0;
}

.goals {
  width: 65%;
}

.rewards {
  width: 25%;
}

#reward-header{
  padding-left: 0;
}

@media(max-width: 800px){
  .rewards{
    display: none;
  }

  .wrapper{
    display: flex;
    justify-content: center;
    padding: 0;
    margin-top: 50px;
  }

  .goals{
    width: 75%;
    margin-top: 50px;
  }
}


</style>