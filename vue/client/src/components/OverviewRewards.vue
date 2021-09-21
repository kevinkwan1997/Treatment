<template>
      <reward-expandable/>
        <div class="btn">
            <button v-on:click="toggle" type="button" class="goal-btn">Add Goals</button>
            <div v-if="visible" id="pop-up">
                <button id="close" v-on:click="toggleOff">X</button>
                <new-goal/>
            </div>
            <button class="goal-btn">Select Random Goal</button>
        </div>
</template>

<script>
import NewGoal from './NewGoal.vue';
import RewardExpandable from './RewardExpandable.vue';
export default {
  components: { NewGoal, RewardExpandable },
    data() {
        return {
            rewards: [],
            visible: false,
            viewFullGoal: false
        }
    },

    methods: {
        toggle() {
            this.visible = !this.visible
        },
        toggleOff() {
            this.visible = !this.visible
            location.reload();
        }
    }

}
</script>

<style scoped>

#pop-up{
    width: 500vh;
    position: fixed;
    height: 300vh;
    top: 0;
    display: flex;
    opacity: 1;
    z-index: 9999;
    background-color: rgba(0, 0, 0, 0.4);
    justify-content: center;
}

#close{
    width: 30px;
    height: 30px;
    position: absolute;
    margin-top: 185px;
    margin-right: -225px;

}

.btn{
    display: flex;
    justify-content: space-evenly;
    height: 20%;
    margin-top: 30px;
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
    background-color: lightblue;
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

#goal-text {
    font-size: 20px;
    padding: 2px;
    padding-left: 20px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow:ellipsis;
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