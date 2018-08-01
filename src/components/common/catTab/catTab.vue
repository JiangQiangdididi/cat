<template>
  <div class="cat-tab-btn">
    <ul>
      <li v-for="(tab,index) in tabs" :key="index">
        <router-link
          :to="linkUrl(tab.name)"
          class="tab-item">{{tab.text}}</router-link>
        <i class="tab-trans"></i>
      </li>
    </ul>
  </div>
</template>

<script>
// import { mapState } from 'vuex'
export default {
  props: ['linkName'],
  data () {
    return {
      currentTab: 'findMaster',
      tabs: [
        { name: 'findMaster', text: '为喵星人寻找主人' },
        { name: 'catStory', text: '我和喵星人的故事' }
      ]
    }
  },
  methods: {
    linkUrl (str) {
      return '/' + this.linkName + '/' + str
    }
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
        a.tab-item
          color #666
          cursor pointer
          font-size 24px
          &.router-link-active
            font-weight 600
            ~ i.tab-trans
              display block
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
