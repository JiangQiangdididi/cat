<template>
  <div class="my-layout">
    <div class="my-layout-left">
      <h1>设置</h1>
      <ul class="my-nav">
        <li v-for="(list,index) in nav" :key="index">
          <router-link :to="list.link">
            {{list.name}}
          </router-link>
        </li>
      </ul>
    </div>
    <div class="my-layout-right">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
export default {
  name: 'my-layout',
  data () {
    return {
      nav: [
        {
          name: '个人资料',
          link: '/my'
        },
        {
          name: '消息通知',
          link: '/my/notify'
        },
        {
          name: '我的收藏',
          link: '/my/collection'
        },
        {
          name: '关于领养',
          link: '/my/about-adopt'
        },
        {
          name: '关于我和喵星人',
          link: '/my/about-me-cat'
        }
      ]
    }
  }
}
</script>

<style scoped>
.my-layout{
  display: flex;
}
.my-layout-left{
  flex: none;
  width: 250px;
}
.my-layout-left h1{
  padding: 0;
  margin: 0;
  font-size: 16px;
  color: #333;
  font-weight: 800;
  font-family: 'PingFang-SC-Bold';
}
.my-nav{
  padding: 0;
  margin: 10px 0;
  font-size: 14px;
}
.my-nav li{
  list-style-type: none;
}
.my-nav a{
  display: block;
  line-height: 35px;
  color: #333;
  text-decoration: none;
}
.my-nav a.router-link-exact-active{
  color: #d73027;
}
.my-layout-right{
  width: 100%;
  padding-top: 1.6rem;
}
</style>
