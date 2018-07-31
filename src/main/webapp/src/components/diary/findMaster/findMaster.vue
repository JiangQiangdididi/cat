<template>
  <div class="find-master">
    <div class="pub-btn-wrap">
      <router-link to="/publish" exact>发布</router-link>
    </div>
    <cat-info-list></cat-info-list>
  </div>
</template>

<script>
import catInfoList from '../../common/catInfoList/catInfoList'
export default {
  components: {
    'cat-info-list': catInfoList
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">
  .find-master
    div.pub-btn-wrap
      margin-bottom 15px
      text-align center
      a
        background transparent
        border 1px solid #fc8d59
        border-radius 5px
        box-sizing border-box
        color #fc8d59
        display inline-block
        font-size 18px
        line-height 28px
        width 100px
</style>
