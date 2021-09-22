<template>
  <form class="form">
      <button id="close" v-on:click="toggle">X</button>
      <input type="text" class="name" placeholder="Name" v-model="goal.goal_name" required>
      <input type="text" class="desc" placeholder="Description" v-model="goal.goal_desc" required >
      <input type="range" min ="1" max="3" class="difficulty" placeholder="Difficulty" v-model="goal.difficulty">
      <input type="submit" @click.stop.prevent="sendGoal"> 
  </form>
</template>

<script>
import store from '../store/index.js'
import axios from 'axios';
export default {
    data() {
        return {
            goal: {
                goal_name: "Untitled Goal",
                goal_desc: "n/a",
                difficulty: 1
            }
        }
    },
    methods: {
        sendGoal() {
            if(this.goal.goal_name === "Untitled Goal" || 
               this.goal.goal_desc === "n/a" || 
               this.goal.goal_name === "" || 
               this.goal.goal_desc === "") {
                this.goal.goal_name = '';
                this.goal.goal_desc = '';
                alert("Please enter values for both fields.");
                return;
            }
            axios.post('http://localhost:8080/goals/', this.goal)
            .then(function (resp) {
                console.log(resp);
                this.goal_name = '';
                this.goal_desc = '';
                alert("Successfully added goal!");

            })
            .catch(function (error) {
                console.log(error);
            })
            this.toggle();
            location.reload();
        },
        toggle() {
            store.commit('TOGGLE');
        }
    }
    

}
</script>

<style scoped>
.form{
    border-radius: 5px;
    width: 100vh;
    height: 100vh;
    background-color: white;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    position: absolute;
}

input{
    margin-top: 10px;
    width: 45%;
}

#close{
    width: 30px;
    height: 30px;
    position: absolute;
    top: 0;
    right: 0;
    margin: 25px;

}


</style>