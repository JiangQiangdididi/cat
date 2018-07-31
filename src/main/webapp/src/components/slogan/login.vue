<!--  -->
<template>
  <div class="box-login">
    <div class="text-wrapper">
      <span>欢迎加入猫公益</span>
    </div>
    <div class="login-wrapper">
      <span>登录</span>
    </div>
    <div class="form-wrapper">
      <form class="form">
        <label for="username" class="label">账号：&nbsp;</label>
        <input type="text" name="username" class="input" placeholder="请输入您的账号" autocomplete="off" v-model="username_login"><br>
        <div class="line-bottom"></div><br><br><br><br>
        <label for="password" class="label">密码：&nbsp;</label>
        <input type="password" name="password" class="input" placeholder="请输入6位以上字符密码" autocomplete="off" v-model="password_login"><br>
        <div class="line-bottom"></div><br><br>
        <input type="checkbox" class="checkbox" @click="ifCheck()"><span style="font-size:14px;">记住我30天</span>
      </form>
    </div>
    <div class="btn-wrapper">
      <div class="btn" @click="submit_login($event)" >登录</div>
    </div>
    <div class="forget-wrapper" @click="gotoForget()">
      <span class="color-login">忘记密码？</span>
    </div>
    <div class="gotoRegister-wrapper" @click="gotoRegister()">
      <span>没有账号？</span><span class="color-login">注册账号</span>
    </div>
  </div>
</template>

<script type='text/ecmascript-6'>
/* eslint-disable */
import router from "../../router";
export default {
  data() {
    return {
      username_login: "",
      password_login: "",
      check_box: false
    };
  },
  methods: {
    gotoRegister() {
      router.push("/register");
    },
    gotoForget() {
      router.push("/forget");
    },
    ifCheck() {
      this.check_box = !this.check_box;
    },
    submit_login(event) {
      var uPattern = /^[a-zA-Z0-9_-]{4,16}$/;
      if (!uPattern.test(this.username_login)) {
        alert("请输入正确的用户名");
        return false;
      }
      if (this.password_login.length < 6) {
        alert("请输入大于六位的密码");
        return false;
      }
      event.preventDefault();
      var formdata = new Formdata();
      formdata.append("username", this.username_login);
      formdata.append("password", this.password_login);
      formdata.append("ifcheck", this.check_box);
      let config = {
        headers: {
          "Content-Type": "multipart/form-data"
        }
      };
      this.$ajax.post("", formData, config).then(response => {
        //传入参数位置及表单
        if (response.data === -1) {
          alert("账户或密码不正确,请重试");
          return false;
        } else {
          router.push({
            path: "", //进入首页并传递参数至首页
            query: { username: this.username }
          });
        }
      });
    }
  }
};
</script>
<style lang='stylus' rel='stylesheet/stylus'>
.box-login {
  height: 100%;
  width: 100%;
  position: absolute;
  top: 0px;
  bottom: 0px;
  background: #fff;
  text-align: center;

  .text-wrapper {
    margin-top: 165px;

    span {
      font-size: 60px;
      font-family: 'miao';
    }
  }

  .login-wrapper {
    margin-top: 25px;
    height: 36px;

    span {
      color: #fc8d59;
      font-size: 36px;
      height: 36px;
      text-align: center;
      line-height: 36px;
      font-weight: bold;
    }
  }

  .form-wrapper {
    width: 400px;
    margin: 0 auto;

    .form {
      display: block;
      height: 180px;
      margin-top: 60px;
      text-align: left;

      .label {
        display: inline-block;
        font-size: 20px;
        font-weight: bold;
        color: #666;
      }

      .input {
        border: none;
        outline: none;
        display: inline-block;
      }

      .line-bottom {
        width: 400px;
        height: 0;
        border: 1px solid #ccc;
        margin-top: 10px;
      }
    }
  }

  .btn-wrapper {
    width: 350px;
    height: 60px;
    background: #fc8d59;
    margin: 0 auto;
    cursor: pointer;
    margin-top: 50px;
    border-radius: 10px;

    .btn {
      width: 100%;
      height: 30px;
      color: #fff;
      text-align: center;
      font-size: 30px;
      font-weight: lighter;
      padding-top: 15px;
    }
  }

  .forget-wrapper {
    margin: 28px;

    .color-login {
      font-size: 14px;
      color: #fc8d59;
      cursor: pointer;
    }
  }

  .gotoRegister-wrapper {
    margin-top: 28px;

    .color-login {
      font-size: 18px;
      color: #fc8d59;
      cursor: pointer;
    }
  }
}
</style>
