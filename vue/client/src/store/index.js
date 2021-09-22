import { createStore } from 'vuex'


export default createStore({
  state: {
    currentReward: {
    },
    formVisible: false
  },
  mutations: {
    SET_REWARD(state, reward) {
      state.currentReward.currentReward = reward;
    },
    TOGGLE(state) {
      state.formVisible = !state.formVisible
    }
    

  },
  actions: {
  },
  modules: {
  }
})
