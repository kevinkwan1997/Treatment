<template>
    <div class="main">
    <nav-bar id="nav"/>
    <router-view/>
  </div>

</template>

<script>
import NavBar from './components/Navbar.vue'
  export default {
    components: {
      NavBar
    }
  }
</script>

<style>

#nav {
  width: 100%;
  height: 50px;
  position: absolute;
  background-color: rgb(48, 44, 58);
  top: 0;
  display: flex;
}

body {
  padding: 0;
  margin: 0;
}

#app {
  background-image: url("../src/assets/bg.jpg");
  background-size: cover;
  font-family: 'Lato', sans-serif;
  font-style: none;
  font-weight: lighter;
  color: #2c3e50;
}

.main {
  width: 100%;
  height: 100vh;
}

</style>
