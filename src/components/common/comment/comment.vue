<template>
  <div class="comment">
    <div class="reply-wrap">
      <img src="" alt="" >
      <input type="text" placeholder="说点什么..." v-model.trim="newReply" ref="reply" />
      <i class="reply-tran"><i></i></i>
      <button type="button" @click="reviewArticle">评论</button>
    </div>
    <div class="reply-list">
      <ul>
        <li v-for="(item,index) in replyList" :key="index">
          <img :src="item.photo" alt="">
          <div class="reply-content">
            <div>
              <span>{{item.name}}<i>：</i></span>
              <p>{{item.content}}</p>
            </div>
            <time>{{item.date}}</time>
          </div>
          <button type="button" @click="focusInput" >回复</button>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      replyList: [
        {
          photo: '',
          name: '不将就的皮皮喵',
          content: '你一路走来，扬起漫天尘埃；我一路陪你，剪断牵绊挂碍,你一路走来，扬起漫天尘埃；我一路陪你，剪断牵绊挂碍,你一路走来，扬起漫天尘埃；我一路陪你，剪断牵绊挂碍,你一路走来，扬起漫天尘埃；我一路陪你，剪断牵绊挂碍,你一路走来，扬起漫天尘埃；我一路陪你，剪断牵绊挂碍,你一路走来，扬起漫天尘埃；我一路陪你，剪断牵绊挂碍,你一路走来，扬起漫天尘埃；我一路陪你，剪断牵绊挂碍,',
          date: '05:23'
        }
      ],
      newReply: '',
      focusState: false
    }
  },
  methods: {
    formatDate(date = new Date()) { // TODO 日期格式化
      let str = ''
      return str
    },
    focusInput () { // 触发input框的聚焦事件
      this.$refs.reply.focus()
    },
    reviewArticle () { // 回复评论
      let item = {
        photo: '',
        name: '',
        content: this.newReply,
        date: this.formatDate()
      }
      if(this.newReply){
        this.replyList.push(item)
      }
    }
  },
  directives: {
    focus: {
      inserted: function (el) {
        el.focus()
      }
    }
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">
  .comment
    .reply-wrap
      margin-top 30px
      position relative
      padding 0 90px 0 50px
      img
        background #cccccc
        border-radius 50%
        position absolute
        top 5px
        left 0
        height 30px
        width 30px
      i.reply-tran
        border-width 9px 16px
        border-style solid
        border-color transparent transparent #cccccc transparent
        height 0px
        width 0px
        position absolute
        top -18px
        right 180px
        i
          border-width 9px 16px
          border-style solid
          border-color transparent transparent #f6f6f6 transparent
          height 0px
          width 0px
          position absolute
          top -8px
          left -16px
      input
        background transparent
        border 1px solid #cccccc
        box-sizing border-box
        resize none
        line-height 24px
        padding 8px 20px
        height 40px
        width 100%
        &:focus
          background #ffffff
          transition all .2s
          ~i
            i
              border-color transparent transparent #ffffff transparent
              transition all .2s
      button
        background #fc8d59
        border-style none
        border-radius 5px
        color #fff
        font-size 12px
        height 24px
        width 40px
        position absolute
        top 8px
        right 30px
        &:hover
          background #fc6e26
          -webkit-box-shadow: 0px 0px 5px #fcbea3
          -moz-box-shadow: 0px 0px 5px #fcbea3
          box-shadow: 0px 0px 5px #fcbea3
          transition all .2s
    .reply-list
      border-top 1px solid #cccccc
      margin-top 20px
      ul
        padding 0px 10px
        li
          border-bottom 1px solid #cccccc
          padding 6px 40px
          position relative
          img
            background #cccccc
            border-radius 50%
            position absolute
            top 8px
            left 0
            height 30px
            width 30px
          div.reply-content
            font-size 12px
            width 100%
            div
              span
                color #fc8d59
                float left
                line-height 20px
                i
                  color #333333
                  font-style normal
              p
                line-height 20px
            time
              color #666666
          button
            background transparent
            border-style none
            color #666666
            padding 0
            position absolute
            bottom 8px
            right 10px
            &:hover
              color #000000
</style>
