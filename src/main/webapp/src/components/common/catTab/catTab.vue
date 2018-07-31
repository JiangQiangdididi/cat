<template>
  <div class="cat-tab-btn">
    <ul>
      <li v-for="(tab,index) in tabs" :key="index">
        <router-link :to="tab.src">
          <span class="tab-item">{{tab.text}}</span>
          <i class="tab-trans"></i>
        </router-link>
      </li>
    </ul>
  </div>
</template>

<script>
// import { mapState } from 'vuex'
export default {
  data () {
    return {
      currentTab: 'find-master',
      tabs: [
        { name: 'find-master', text: '为喵星人寻找主人', src: '/diary' },
        { name: 'cat-story', text: '我和喵星人的故事', src: '/publish' }
      ]
    }
  },
  methods: {

  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .cat-tab-btn
    width 1080px
    margin 0 auto
    ul
      font-size 0
      li
        display inline-block
        text-align center
        position relative
        width 50%
        a
          display block
          padding 40px 0 50px
          &.router-link-exact-active
            font-weight 600
            .tab-trans
              display block
        span.tab-item
          color #666
          cursor pointer
          font-size 24px
        i.tab-trans
          display none
          position absolute
          bottom 5px
          left 50%
          margin-left -18px
          height 0
          width 0
          border-width 20px 18px // 36 * 40
          border-color orange transparent transparent transparent
          border-style solid
</style>
