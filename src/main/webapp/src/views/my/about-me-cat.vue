<template>
  <div class="about-me-cat">
    <h2 class="custom-my-title">关于我和喵星人</h2>
    <ul class="about-list">
      <li v-for="(list,index) in aboutList" :key="index">
        <div class="warp">
          <div class="warp-left">
            <h1>标题：{{list.title}}</h1>
            <p>{{list.content}}</p>
            <a href="javacript:void(0);">查看全文<span class="el-icon-arrow-right"></span></a>
          </div>
          <div class="warp-right">
            <p>{{list.timer}}</p>
            <img :src="list.picture" alt="">
          </div>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'about-me-cat',
  data () {
    return {
      aboutList: [
        {
          title: 'xxxxx',
          content: 'xxxxxxxxxxxxxxxxxxxxxx',
          timer: '2018年7月12日 11:53',
          picture: require('../../assets/logo.png')
        }
      ]
    }
  }
}
</script>

<style>
@import "custom.css";
.about-list{
  margin: 0;
}
.about-list li{
  border-bottom: 1px solid #ccc;
  padding: 10px 20px;
}
.about-list li .warp{
  display: flex;
}
.about-list .warp-left{
  width: calc(100% - 200px);
  padding-right: 46px;
  position: relative;
}
.about-list .warp-left h1{
  margin: 0;
  font-size: 18px;
  font-weight: normal;
  line-height: 40px;
  color: #757575;
}
.about-list .warp-left p{
  margin: 0;
  padding-left: 2em;
  text-indent: 1em;
  display: inline-block;
  word-break: break-word;
  width: 100%;
  box-sizing: border-box;
  line-height: 1.5;
  color: #757575;
}
.about-list .warp-left a{
  position: absolute;
  bottom: 0;
  right: 46px;
  color: #fd7031;
  font-size: 14px;
  text-decoration: none;
}
.about-list .warp-right p{
  margin: 0;
  text-align: right;
  color: #999;
  font-size: 14px;
}
.about-list .warp-right img{
  border-radius: 6px;
}
</style>
