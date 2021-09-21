<template>
  <transition name="fade">
        <div class="preloader">
            <div class="logo">

            </div>
        </div>
  </transition>
</template>

<script>
export default {
    name: 'preloader'
}
</script>

<style>

.preloader {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    position: absolute;
    width: 100%;
    height: 100%;
    background-color: white;
    z-index: 9999999
}

.logo {
    width: 50rem;
    height: 20rem;
    background-image: url(../assets/logo.png);
    background-repeat: no-repeat;
    margin-left: 160px;
}

</style>