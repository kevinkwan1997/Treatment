<template>
      <goal-expandable/>
        <div class="btn">
            <button v-on:click="toggle" type="button" class="goal-btn">Add Goals</button>
            <div v-if="watchFormVisible" id="pop-up">
                <new-goal id="new-goal"/>
            </div>
            <button class="goal-btn">Select Random Goal</button>
        </div>
</template>

<script>
import store from '../store/index.js';
import axios from 'axios';
import NewGoal from './NewGoal.vue';
import GoalExpandable from './GoalExpandable.vue';
export default {
  components: { NewGoal, GoalExpandable },
    data() {
        return {
            goals: [],
            visible: false,
            viewFullGoal: false
        }
    },
    mounted() {
        axios.get('http://localhost:8080/goals/')
        .then((response) => {
            console.log(response)
            this.goals = response.data})
    },
    methods: {
        toggle() {
            store.commit('TOGGLE');
        }
    },
    computed: {
        watchFormVisible() {
            return store.state.formVisible
        }
    }

}
</script>

<style scoped>

#pop-up{
    top: 0;
    right: 0;
    height: 100%;
    width: 100%;
    display: flex;
    position: absolute;
    justify-content: center;
    align-items: center;
    opacity: 1;
    z-index: 9999;
}

.btn{
    display: flex;
    justify-content: space-evenly;
    height: 50px;
    margin-top: 45px;
}

.btn button{
    width: 49%;
    background-color: rgb(144, 210, 226);
    box-shadow: none;
}

.btn button:hover{
    transition: 0.5s;
    background-color: rgb(133, 233, 200);
    
    
}
.goal-list{
    list-style: none;
    background-color: rgb(250, 250, 250);
    padding: 2px;
    height:auto;
}

.main {
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
    overflow-y: scroll;
    scrollbar-width: none;
    height: 60%;
}

.list {
    background-color: rgb(84, 91, 94);
    border-radius: 5px;
    margin-bottom: 5px;
    align-items: center;
    display: flex;
}


.list:hover {
    transition: 1s ease-in-out;
    transform: translateX(10px);
    background-color: lightcoral;
    cursor: pointer;
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

.list:hover #goal-text{
    opacity: 0;
    transition: 0.6s;
}

#new-goal{
    width: 85%;
    height: 85%;
}

@media(min-height: 1024px){
    #close{
    margin-right: -325px;
}
}

@media(min-height: 1200px){
    #close{
    margin-right: -400px;
}
}
</style>