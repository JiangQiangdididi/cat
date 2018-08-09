<template>
  <div class="layout">
    <!--头部-->
    <v-header></v-header>
    <!--路由出口-->
    <div class="layout-content">
      <keep-alive>
        <router-view></router-view>o
        
      </keep-alive>
    </div>
    <!--脚部-->
    <v-footer></v-footer>
  </div>
</template>

<script>
import vHeader from '../components/header/header.vue'
import vFooter from '../components/footer/footer.vue'
export default {
  components: {
    vHeader,
    vFooter
  }
}
</script>

<style scoped>

</style>
