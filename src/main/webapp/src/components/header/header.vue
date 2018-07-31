<template>
  <header class="header">
    <div class="header-left">
      <div class="header-logo" style="width: 15rem;height: 3rem;background: red;">
        <img src="" alt="">
      </div>
      <nav>
        <router-link to="/" exact>
          首页
        </router-link>
        <router-link to="/" exact>
          社区
        </router-link>
        <router-link to="/diary" exact>
          日记
        </router-link>
        <router-link to="/publish" exact>
          发布
        </router-link>
        <router-link to="/my">
          我的
        </router-link>
      </nav>
    </div>
    <div class="header-right">
      <div class="header-right-btn" v-if="!login">
        <router-link to="/login">
          <button type="button">登录</button>
        </router-link>
        <router-link to="/register">
          <button type="button">注册</button>
        </router-link>
      </div>
      <div class="header-right-info" v-if="login">
        <div class="portrait">
          <img src="" alt="">
          <div></div>
        </div>
        <p>Susie</p>
        <div class="badge">
          <i class="el-icon-message"></i>
          <span>17</span>
        </div>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  data () {
    return {
      login: false
    }
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .header
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 1140px;
    margin: 0 auto;
    background: transparent;
    flex:none;
  .header-left
    display: flex;
    justify-content: center;
    align-items: center;
    a
      text-decoration: none;
      color: #555;
      display: inline-block;
      box-sizing: border-box;
      line-height: 3rem;
      width: 5rem;
      text-align: center;
      &.router-link-active
        background: #fc8d59;
        color: #fff;
  .header-right-btn
    button
      border: 1px solid #fc8d59;
      background: #fc8d59;
      color: #fff;
      padding: 2px 8px;
      border-radius: 6px;
      margin-left: 1rem;
  .header-right-info
    display: flex;
    align-items: center;
    .portrait
      >div
        width: 2rem;
        height: 2rem;
        background: #7676f3;
        border-radius: 50%;
        margin-right: 4px;
    p
      margin: 0;
      color: #333;
    .badge
      position: relative;
      margin-left: 20px;
      color: #777;
      i
        font-size: 24px
      span
        position: absolute;
        background: #fc8d59;
        color: #fff;
        width: 1rem;
        height: .8rem;
        line-height: .8rem;
        top: -5px;
        left: -.8rem;
        font-size: 12px;
        text-align: center;
</style>
