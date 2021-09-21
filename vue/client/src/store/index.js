import { createStore } from 'vuex'


export default createStore({
  state: {
    currentReward: {
      reward_name: '',
      reward_desc: '',
      level: 0 
    },
    formVisible: false
  },
  mutations: {
    SET_REWARD(state, reward) {
      state.currentReward.currentReward = reward;
    },
    TOGGLE(state) {
      state.formVisible = !state.formVisible;
    }
    

  },
  actions: {
  },
  modules: {
  }
})
