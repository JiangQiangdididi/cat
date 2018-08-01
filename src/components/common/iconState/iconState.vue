<template>
  <div class="article-state">
    <span @click="saveToCollect" :class="{collected : isCollect}">
      <i class="collect"></i>
      <strong>{{item.articleState.collect}}</strong>
    </span>
    <span @click="openComment">
       <i class="comment"></i>
      <strong>{{item.articleState.comment}}</strong>
    </span>
   <span @click="likeArticle" :class="{liked: isLike}">
     <i class="like"></i>
     <strong>{{item.articleState.like}}</strong>
   </span>
  </div>
</template>

<script>
import { mapState } from 'vuex'
export default {
  data () {
    return {
      isCollect: false,
      isLike: false
    }
  },
  computed: {
    ...mapState({
      item (state) {
        return state.detailStore.itemDetail
      }
    })
  },
  methods: {
    saveToCollect () {
      this.isCollect = !this.isCollect
      if (this.isCollect) {
        ++this.item.articleState.collect
      } else {
        --this.item.articleState.collect
      }
      this.$store.commit('changeItem', this.item)
    },
    openComment () {
      this.$store.commit('changeCommentState')
    },
    likeArticle () {
      this.isLike = !this.isLike
      if (this.isLike) {
        ++this.item.articleState.like
      } else {
        --this.item.articleState.like
      }
      this.$store.commit('changeItem', this.item)
    }
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">
.article-state
  text-align right
  span
    -webkit-user-select: none
    -moz-user-select: none
    -ms-user-select: none
    user-select: none
    cursor pointer
    display inline-block
    margin 0 42px
    text-align center
    &.collected,&.liked
      strong
        color #fc8d59
    i
      background-repeat no-repeat
      background-color transparent
      background-position 0 0
      display inline-block
      margin-right 2px
      vertical-align middle
      &.collect
        background-image url("collect.png")
        height 18px
        width 18px
      &.comment
        background-image url("comment.png")
        height 17px
        width 17px
      &.like
        background-image url("like.png")
        height 16px
        width 20px
    strong
      color #666666
      font-weight normal
      font-size 13px
      vertical-align middle
</style>
