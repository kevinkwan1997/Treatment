<template>
    <div id="btn-wrapper">
      <div class="nav-button"><p>Overview</p></div>
      <div class="nav-button"><p>Goals</p></div>
      <div class="nav-button"><p>Rewards</p></div>
      <div class="nav-button"><p>About</p></div>
    </div>
</template>

<script>
export default {

}
</script>

<style>
.nav-button {
  width: 150px;
  text-align: center;
}

.nav-button p {
  font-weight: normal !important;
  color: white;
}

.nav-button:hover {
  background-color: black;
  transition: 0.5s ease-in-out;
}

#btn-wrapper {
  width: 50%;
  display: flex;
  flex-direction: row;
}
</style>