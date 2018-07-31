<template>
  <div class="collection">
    <h2 class="custom-my-title">我的收藏</h2>
    <cat-list :catData="collectionList"></cat-list>
  </div>
</template>

<script>
/* eslint-disable */
import catList from '../../components/my/cat-list.vue'
export default {
  name: 'collection',
  data () {
    return {
      collectionList: [
        {
          userPortrait: require('../../assets/logo.png'),
          name: '昵称',
          catPortrait: require('../../assets/logo.png'),
          collection: false,
          like: true
        },
        {
          userPortrait: require('../../assets/logo.png'),
          name: '昵称',
          catPortrait: require('../../assets/logo.png'),
          collection: false,
          like: true
        }
      ]
    }
  },
  methods: {

  },
  components:{
    catList
  }
}
</script>

<style>
@import "custom.css";
</style>
