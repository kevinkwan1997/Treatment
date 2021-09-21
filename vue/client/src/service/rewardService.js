import axios from 'axios'

const http = axios.create({
    baseURL: "http://localhost:8080"
})

export default {
    getRandomReward(difficulty) {
       http.post('/rewards/random', difficulty).then((resp) => {
           const reward = resp.data;
           return reward;
       })
    }
}