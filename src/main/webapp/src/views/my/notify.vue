<template>
  <div class="notify">
    <div class="custom-tabs">
      <ul class="custom-tabs-item" ref="tabsItem">
        <li @click="tabClick(index)" v-for="(item,index) in ['收到的评论','收到的赞']" :key="index" :class="[index==idx?'active': '']">
          {{item}}
        </li>
      </ul>
      <div class="custom-tabs-content">
        <comment-list :commentList="commentList" @click="reply" v-if="idx==0"></comment-list>
        <comment-list :praiseList="praiseList" v-if="idx==1"></comment-list>
        <!--<ul class="custom-tabs-praise" v-if="idx == 1">
          <li v-for="(list,index) in praiseList" :key="index">
            <div class="praise-header">
              <img :src="list.portrait" alt="">
            </div>
            <div class="praise-text">
              <h1>{{list.name}}<span>{{list.time}}</span></h1>
              <p>赞了我的日记</p>
            </div>
          </li>
        </ul>-->
      </div>
    </div>
  </div>
</template>

<script>
/* eslint-disable */
import commentList from '../../components/my/comment-list.vue'
export default {
  name: 'notify',
  data () {
    return {
      idx: 0,
      commentList: [
        {
          name: '昵称',
          time: '2018年7月12日 11:53',
          text: 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx',
          portrait: require('../../assets/logo.png')
        },
        {
          name: '昵称',
          time: '2018年7月12日 11:53',
          text: 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx',
          portrait: require('../../assets/logo.png')
        }
      ],
      praiseList: [
        {
          name: '昵称',
          time: '2018年7月12日 11:53',
          portrait: require('../../assets/logo.png')
        },
        {
          name: '昵称',
          time: '2018年7月12日 11:53',
          portrait: require('../../assets/logo.png')
        }
      ]
    }
  },
  methods: {
    tabClick (index) {
      this.idx = index
    },
    reply () {
       console.log('reply')
    }
  },
  components: {
    commentList
  }
}
</script>

<style>
@import "custom.css";
</style>
