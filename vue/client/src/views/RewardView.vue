<template>
    <div class="wrapper">

        <div id="inner">
            <h1>Your reward: {{reward.currentReward.reward_name}}</h1>
            <p>Description: {{reward.currentReward.reward_desc}}</p>
            <h3>Level: {{reward.currentReward.level}}</h3>
            <p>Price: {{reward.currentReward.price}}</p>
        </div>

    </div>

</template>

<script>
import store from '../store/index.js'
export default {
    data() {
        return {
            reward: {
            }
        }
    },
    created() {
           this.reward = store.state.currentReward
    }

}
</script>

<style scoped>

.wrapper {
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
    justify-content: space-evenly;
}

#inner {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

#inner h1 {
    height: 50px;
    text-align: center;
}

#inner p {
    height: 50px;
    text-align: center;
}

#inner h3 {
    height: 50px;
    text-align: center;
}

#inner:nth-child(2) {
    width: 100%;
}
</style>