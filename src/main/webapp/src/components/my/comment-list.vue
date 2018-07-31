<template>
  <ul class="custom-tabs-list">
    <li v-for="(list,index) in commentList" :key="index" class="comment-list" v-if="!praiseList">
      <div class="comment-header">
        <img :src="list.portrait" alt="">
      </div>
      <div class="comment-text">
        <h1>{{list.name}}<span>{{list.time}}</span></h1>
        <p>{{list.text}}</p>
      </div>
      <button type="button" class="custom-reply-btn" @click="reply()">
        回复
      </button>
    </li>
    <li v-for="(list,index) in praiseList" class="praise-list" :key="index" v-if="praiseList">
      <div class="praise-header">
        <img :src="list.portrait" alt="">
      </div>
      <div class="praise-text">
        <h1>{{list.name}}<span>{{list.time}}</span></h1>
        <p>赞了我的日记</p>
      </div>
    </li>
  </ul>
</template>

<script>
/* eslint-disable */
  export default {
    props: ['commentList','praiseList'],
    methods:{
      reply(){
        this.$emit('click')
      }
    }
  }
</script>

<style scoped>
  .custom-tabs-list{
    margin: 10px 0 0 0;
    padding: 0;
  }
  .custom-tabs-list .comment-header img,.custom-tabs-list .praise-header img{
    display: block;
    width: 100%;
  }
  .custom-tabs-list .comment-text,.custom-tabs-list .praise-text{
    width: 100%;
  }
  .comment-list,.praise-list{
    background: #fff;
    border: 1px solid #ccc;
    border-radius: 4px;
    padding: 5px 5px 30px;
    position: relative;
    display: flex;
    align-items: flex-start;
    margin-bottom: 2em;
  }
  .praise-list{
    padding: 5px;
  }
  .comment-list .comment-header,.praise-list .praise-header{
    position: relative;
    border-radius: 50%;
    overflow: hidden;
    width: 50px;
    flex: none;
    z-index: 2;
  }
  .comment-list .comment-text h1,.praise-list .praise-text h1{
    margin: 0 0 0 8px;
    font-size: 14px;
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
  }
  .comment-list .comment-text span,.praise-list .praise-text span{
    font-weight: normal;
    color: #999;
    font-size: 12px;
  }
  .comment-list .comment-text p,.praise-list .praise-text p{
    margin: 0 0 0 8px;
    color: #777;
    font-size: 14px;
  }
  .custom-tabs-list .comment-list:first-child:after,.custom-tabs-list .praise-list:first-child:after{
    content: '';
    display: block;
    position: absolute;
    left: 20px;
    top: -8px;
    width: 15px;
    height: 15px;
    background: #fff;
    box-sizing: border-box;
    transform: rotate(45deg);
    border-left: 1px solid #ccc;
    border-top: 1px solid #ccc;
  }
  .custom-tabs-list .praise-list:first-child:after{
    left: 100px;
  }
  .custom-tabs-list li:last-child{
    margin-bottom: 0;
  }
  .custom-reply-btn{
    position: absolute;
    right: 0;
    bottom: 5px;
    border: 0;
    background: 0;
    color: #ff6363;
    cursor: pointer;
    font-size: 14px;
  }
</style>
