<template>
  <div class="cat-list-wrap">
    <section v-for="(item,index) in diaryList" :key="index">
      <header>
        <h3>标题：{{item.title}}</h3>
        <time>{{item.date}}</time>
      </header>
      <div class="info-details-wrap">
        <div class="info-text-wrap">
          <div class="info-text">
            {{item.content}}
          </div>
          <button>查看全文&gt;</button>
        </div>
        <img :src="item.photo" alt="">
      </div>
    </section>
    <p class="loading-alert" v-show="isLoading">正在加载，请稍候...</p>
  </div>
</template>

<script>
export default {
  data () {
    return {
      diaryList: [
        {
          title: 'XXXXXXXXXXXX',
          content: '你个话痨小孩！说实话我觉得活泼张扬、清新单纯的你是还不错，就像肯德基柚香鸡腿堡，柚子酱搭配烤鸡腿，酸甜鲜嫩，另外你的约定我勉强答应了！#红黑双堡敢爱敢怼#今年夏天约上你的兄弟也一起来肯德基分享全新红黑双堡吧。',
          date: '2018-7-12 11:53',
          photo: 'http://p2.ifengimg.com/fck/2016_44/0ee3cb8c9ddfc96_w1000_h1000.png'
        },
        {
          title: 'XXXXXXXXXXXX',
          content: '你个话痨小孩！说实话我觉得活泼张扬、清新单纯的你是还不错，就像肯德基柚香鸡腿堡，柚子酱搭配烤鸡腿，酸甜鲜嫩，另外你的约定我勉强答应了！#红黑双堡敢爱敢怼#今年夏天约上你的兄弟也一起来肯德基分享全新红黑双堡吧。',
          date: '2018-7-12 11:53',
          photo: 'http://p2.ifengimg.com/fck/2016_44/0ee3cb8c9ddfc96_w1000_h1000.png'
        }
      ],
      isLoading: true
    }
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">
  .cat-list-wrap
    section
      border-bottom 1px solid #cccccc
      margin-bottom 15px
      padding-bottom 30px
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
      div.info-details-wrap
        height 180px
        overflow hidden
        div.info-text-wrap
          float left
          height 100%
          margin 0 230px 0 30px
          position relative
          div.info-text
            text-indent 2em
          button
            background transparent
            border none
            color #fc8d59
            font-size 14px
            position absolute
            bottom 0
            right 0
        img
          box-sizing border-box
          float right
          border-radius 5px
          margin-left -100%
          height 180px
          width 180px
    p.loading-alert
      color #fc8d59
      text-align center
</style>
