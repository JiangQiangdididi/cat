<template>
  <div class="find-master-detail">
    <header>
      <h3>标题：{{item.title}}</h3>
      <time>{{item.date}}</time>
    </header>
    <div class="detail-content">
      {{item.content}}
    </div>
    <photo-slide></photo-slide>
    <div class="func-btn-wrap">
      <button type="button" v-if="item.isAdopted">查看喵星人的主人</button>
      <button type="button" v-else @click="changeMessageState">申请当它的主人</button>
    </div>
    <icon-state></icon-state>
    <comment v-show="isCommentShow"></comment>
    <div class="message-box" v-show="isMessageShow">
      <div class="box-wrap">
        <i @click="changeMessageState"></i>
        <p>已发起申请</p>
        <button type="button" @click="changeMessageState">确定</button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import photoSlide from '../../common/photoSlide/photoSlide'
import iconState from '../../common/iconState/iconState'
import comment from '../../common/comment/comment'
export default {
  data () {
    return {
      isMessageShow: false
    }
  },
  computed: {
    ...mapState({
      item (state) {
        return state.detailStore.itemDetail
      },
      isCommentShow (state) {
        return state.detailStore.isCommentShow
      }
    })
  },
  methods: {
    changeMessageState () {
      this.isMessageShow = !this.isMessageShow
    }
  },
  components: {
    'photo-slide': photoSlide,
    'icon-state': iconState,
    'comment': comment
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">
  div.find-master-detail
    header
      line-height 60px
      position relative
      h3
        background transparent url('diary-cat-paw.png') no-repeat 2px center
        font-size 20px
        font-weight normal
        padding-left 30px
        padding-right 150px
      time
        color #666666
        font-size 12px
        position absolute
        top 0
        right 0
    div.detail-content
      margin 15px 0
      text-indent 2em
    div.func-btn-wrap
      text-align center
      button
        background transparent
        border 2px solid #fc8d59
        border-radius 5px
        box-sizing border-box
        color #fc8d59
        display inline-block
        font-size 20px
        line-height 38px
        width 200px
    div.message-box // 消息框
      background rgba(255,255,255,0.5)
      position fixed
      top 0
      bottom 0
      left 0
      right 0
      z-index 99
      div.box-wrap
        background #ffffff
        border 4px solid #fc8d59
        border-radius 5px
        text-align center
        position absolute
        top 200px
        left 50%
        margin-left -300px
        height 300px
        width 600px
        i
          background transparent url('detail-close.png') no-repeat 0 0
          cursor pointer
          position absolute
          top 6px
          right 6px
          height 19px
          width 19px
        p
          font-size 24px
          line-height 170px
          text-align center
        button
          background #fc8d59
          border-style none
          border-radius 5px
          color #ffffff
          font-size 16px
          margin-top 25px
          height 40px
          width 100px
</style>
