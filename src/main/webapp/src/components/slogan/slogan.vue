<template>
  <div class="box-slogan">
    <div class="img-wrapper">
      <img src="./slogan-cat.png">
    </div>
    <div class="text-wrapper">
      <span class="text">关于猫的公益</span>
    </div>
    <div class="einstein-wrapper">
      <div class="text-saying">
        <span>如果你无法简洁的表达你的想法，那只能说明你还不够了解它。</span>
      </div>
      <div class="author">
        <div class="line">
        </div>
        <div class="text-author"><span>阿尔伯特·爱因斯坦</span></div>
      </div>
    </div>
    <div class="btn-wrapper">
      <div class="btn joinus" @click="gotoRegister()"><span>加入我们</span></div>
      <div class="btn lookaround" @click="gotoSY()"><span>逛逛社区</span></div>
    </div>
  </div>
</template>

<script type='text/ecmascript-6'>
/* eslint-disable */
import router from "../../router";
export default {
  methods: {
    gotoRegister() {
      router.push("/register");
    },
    gotoSY() {
      router.push("/");
    }
  }
};
</script>
<style lang='stylus' rel='stylesheet/stylus'>
.box-slogan {
  height: 100%;
  width: 100%;
  position: absolute;
  top: 0px;
  bottom: 0px;
  background: #fdd1bd;
  text-align: center;

  .img-wrapper {
    height: 78px;
    margin-top: 200px;

    img {
      height: 78px;
      width: 298px;
    }
  }

  .text-wrapper {
    margin-top: 30px;

    .text {
      font-family: 'miao';
      font-size: 72px;
    }
  }

  .einstein-wrapper {
    margin-top: 100px;

    .text-saying span {
      font-size: 24px;
    }

    .author {
      height: 24px;
      width: 280px;
      margin-top: 40px;
      margin-left: 60%;

      .line {
        display: inline-block;
        border-top: 2px solid black;
        height: 0;
        width: 60px;
        line-height: 24px;
        margin-bottom: 6px;
      }

      .text-author {
        display: inline-block;
        font-size: 24px;
        line-height: 24px;
      }
    }
  }

  .btn-wrapper {
    text-align: center;
    width: 240px;
    margin: 0 auto;

    .btn {
      width: 240px;
      height: 80px;
      background: #fc8d59;
      text-align: center;
      line-height: 80px;
      margin-top: 20px;
      cursor: pointer;

      span {
        font-size: 28px;
        color: #fff;
      }
    }
  }
}
</style>
