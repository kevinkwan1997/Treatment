<template>
   <div class="main">
       <ul>
         <li id = "list" v-for="goal, i in goals" :key=goal @mouseenter="activate(i)" @mouseleave="deactivate()" :class="{ active : active_el == i }">
              <p id = "goal-text">{{goal.goal_name}}</p> 
              <span id = "desc2">{{goal.goal_desc}}</span>
              <span id = "desc">Difficulty: {{goal.difficulty}}<button class="complete" v-on:click="complete(goal.goal_id, goal.difficulty)">Finish</button><button class="remove" v-on:click="deleteGoal(goal.goal_id)">Delete</button></span> 

         </li>
        </ul>
  </div>
</template>

<script>
import store from '../store/index.js'
import axios from 'axios';
export default {
    data(){
        return{
             goals: [],
             active_el: 0
        }
    },
    mounted() {
        axios.get('http://localhost:8080/goals/')
        .then((response) => {
            console.log(response)
            this.goals = response.data});
    },
    methods: {
        activate:function(el) {
            this.active_el = el;
            
        },
        deactivate:function() {
            this.active_el = null;
        },
        deleteGoal: function(id) {
            axios.delete('http://localhost:8080/goals/' + id).then(resp => {
                const index = this.goals.findIndex(goal => goal.goal_id === id)
                if (~index) {
                    this.goals.splice(index, 1)
                }
                console.log(resp);
            });
        },
        complete: function(id, diff) {
            let payload = {
                level: diff
            }
            this.deleteGoal(id);
            axios.post('http://localhost:8080/reward', payload).then((resp) => {
                store.commit('SET_REWARD', resp.data);
                id = resp.data.id;
                console.log(resp);
            })
            this.$router.push({name: 'reward'});
        }
    }

}
</script>

<style scoped>
/* Buttons */
.complete, .remove {
    background-color:rgb(255, 185, 160);
    display: inline-flex;
    align-items: center;
    justify-content: center;
    color: white;
    height: 20px;
    width: 50px;
    margin: 5px;
    border: none;
    box-shadow: none;
}

.complete:hover, .remove:hover {
    background-color: rgb(255, 160, 97);
    display: inline-flex;
    align-items: center;
    justify-content: center;
    height: 20px;
    width: 50px;
    border: none;
    box-shadow: none;
}
/* Container */
.expandable button{
    width: 50px;
    height: 15px;
    z-index: 100000;
    position: relative;
}
.goal-list{
    list-style: none;
    background-color: rgb(250, 250, 250);
    padding: 2px;
    overflow: hidden;
    text-overflow:ellipsis;
}

#list {
    background-color: rgb(69, 60, 75);
    border-radius: none;
    margin-bottom: 5px;
    height: 75px;
    align-items: center;
    display: flex;
    border-radius: 4px;
    
}


#list:hover {
    transition: 0.6s ease-in-out;
    transform: translateX(10px);
    
    background-color: lightcoral;
    cursor: pointer;

}

.active {
    transition: height 0.4s linear ease-in-out;
    height: 100px;
}


/* Text and animations for text */
#desc{
    opacity: 0;
    color: white;
    margin-right: 20px;
    float: right;
    position: absolute;
}

#desc2{
    opacity: 0;
    color: white;
    float: left;
    position: absolute;
    width: 80%;
    text-overflow: ellipsis;
    overflow: hidden;
    margin-left: 20px;
    margin-right: 20px;
}

#list:hover #desc{
    opacity: 1;
    transition: 0.7s ease-in-out;
    transition-delay: 400ms;
    right: 0;
    transform: translateY(-15px);
}

#list:hover #desc2{
    opacity: 1;
    transition: 0.7s ease-in-out;
    transition-delay: 400ms;
    left: 0;
    transform: translateY(15px);
}

#list:hover #goal-text{
    transition: 0.7s ease-in-out;
    transition-delay: 400ms;
    transform: translateY(-15px);
}

#goal-text {
    font-size: 20px;
    padding: 2px;
    padding-left: 20px;
    white-space: nowrap;
    width: 55%;
    text-overflow: ellipsis;
    overflow: hidden;
    color: white;
}

.main {
    padding: 5px;
     box-shadow: 0 0 8px 2px #888; 

}

ul {
    padding: 0;
    margin: 0;
}

@media(max-width: 800px){
    
    #goal-text{
        text-align: center;
        width: 100%;
    } 

    #list:hover {
        transition: 0.7s ease-in-out;
        transition-delay: 400ms;
        transform: none;
        background-color: lightcoral;
        cursor: pointer;

    }
    #list:hover #goal-text{
        display: none;
    }

    #list.active {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    #list:hover #desc {
        right:unset;
    }

    #desc {
        float: none;
        margin-right: 0;
    }
    #list:hover #desc2{
        left: unset;
        margin: 0;
        text-align: center;
    }

}

</style>