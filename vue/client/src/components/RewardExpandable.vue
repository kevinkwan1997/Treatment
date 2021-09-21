<template>
   <div class="main">
          <div class = "list" v-for="reward in rewards" v-bind:key=reward>
              <h2 id = "reward-text">{{reward.reward_name}}</h2> <span id="desc2"> {{reward.reward_desc}}</span><span id = "desc">Price: {{reward.price}}</span> 
         </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
    data(){
        return{
             rewards: []
        }
    },
    mounted() {
        axios.get('http://localhost:8080/rewards/')
        .then((response) => {
            console.log(response)
            this.rewards = response.data})
    },

}
</script>

<style scoped>
.main{
    display: flex;
    flex-direction: column;
}

.goal-list{
    list-style: none;
    background-color: rgb(250, 250, 250);
    padding: 2px;
}

.list {
    background-color: lightblue;
    border-radius: none;
    margin-bottom: 5px;
    align-items: center;
    display: flex;
    border: 1px solid black;
}


.list:hover {
    transition: 1s;
    transform: translateX(10px);
    background-color: lightcoral;
    cursor: pointer;
}

.list:focus {
    box-shadow: -10px black;
    height: 200px;
    transition: 0.3s ease-in;
}

#desc{
    opacity: 0;
    color: white;
    margin-left: 20px;
    float: right;
    margin-right: 30px;
    position: absolute;
}

#desc2{
    opacity: 0;
    color: white;
    float: left;
    position: absolute;
    margin-left: 20px;
    margin-right: 20px;
}

.list:hover #desc{
    opacity: 1;
    transition: 1.7s;
    right: 0;
}

.list:hover #desc2{
    opacity: 1;
    transition: 0.8s;
    left: 0;
}

.list:hover #reward-text{
    opacity: 0;
    transition: 0.6s;
}



#reward-text {
    font-size: 20px;
    padding: 2px;
    padding-left: 20px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow:ellipsis;
    margin-top: 8px;
}

</style>