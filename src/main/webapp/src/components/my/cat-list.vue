<template>
  <ul class="cat-list">
    <li v-for="(list,index) in catData" :key="index">
      <div class="cat-list-portrait">
        <img :src="list.catPortrait" alt="">
        <span :class="[list.collection?'el-icon-star-on':'el-icon-star-off']" @click="collection(index)"></span>
      </div>
      <div class="cat-list-footer">
        <div>
          <img :src="list.userPortrait" alt="">
          <p>{{list.name}}</p>
        </div>
        <div>
          <span class=""></span>
          <span class="el-icon-warning"></span>
        </div>
      </div>
    </li>
  </ul>
</template>

<script>
/* eslint-disable */
  export default {
    props: ['catData'],
    methods: {
      collection(index){
        this.catData[index].collection = !this.catData[index].collection
      }
    }
  }
</script>

<style scoped>
  .cat-list{
    display: flex;
    flex-wrap: wrap;
    margin: 0;
    padding: 0;
  }
  .cat-list li{
    flex: 32%;
    max-width: 32%;
    padding-right: 2%;
    padding-bottom: 3em;
  }
  .cat-list li:nth-child(3n){
    padding-right: 0;
  }
  .cat-list-portrait{
    position: relative;
  }
  .cat-list-portrait img{
    width: 100%;
    background: #ccc;
  }
  .cat-list-portrait span{
    position: absolute;
    top: 9px;
    right: 9px;
    font-size: 38px;
    color: #fee090;
    cursor: pointer;
  }
  .cat-list-footer{
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding-top: 8px;
  }
  .cat-list-footer>div:first-child{
    display: flex;
    align-items: center;
    padding-left: 10px;
  }
  .cat-list-footer>div:first-child img{
    width: 40px;
    background: aquamarine;
    border-radius: 50%;
  }
  .cat-list-footer>div:first-child p{
    margin: 0 0 0 8px;
    font-size: 14px;
    color: #555;
  }
  .cat-list-footer>div:last-child span{
    font-size: 20px;
    color: #757575;
    margin-left: 10px;
  }
</style>
