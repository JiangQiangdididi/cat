<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
@import "assets/css/reset.css";
#app {
  /*font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;*/
  height: 100%;
}
.layout{
  display: flex;
  flex-direction: column;
  height: 100%;
}
.layout-content {
  width: 1235px;
  padding: 30px 60px;
  margin: 0 auto;
  box-sizing: border-box;
  flex:1 1 100%;
}
</style>
