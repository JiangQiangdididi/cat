<template>
  <div class="box-register">
    <div class="text-wrapper">
      <span>欢迎加入猫公益</span>
    </div>
    <div class="register-wrapper">
      <span>注册账号</span>
    </div>
    <div class="form-wrapper">
      <form class="form">
        <label for="username" class="label">昵称：&nbsp;</label>
        <input type="text" name="username" class="input" placeholder="请输入您的昵称" autocomplete="off" v-model="username_register"><br>
        <div class="line-bottom"></div><br><br>
        <label for="password" class="label">密码：&nbsp;</label>
        <input type="password" name="password" class="input" placeholder="请输入6位以上字符密码" autocomplete="off" v-model="password_register"><br>
        <div class="line-bottom"></div><br><br>
        <label for="email" class="label">邮箱：&nbsp;</label>
        <input type="email" name="email" class="input" placeholder="请输入您的常用邮箱" autocomplete="off" v-model="email_register"><br>
        <div class="line-bottom"></div><br><br>
        <label for="varidate" class="label">验证码:</label>
        <input type="text" name="varidate" class="input" placeholder="请输入您的验证码" autocomplete="off" v-model="varidate_register">
        <div class="varidate-btn" @click="submit_varidata_register()">获取验证码</div>
        <div class="line-bottom"></div>
      </form>
    </div>
    <div class="agree-wrapper">
      <span>点击注册账号，表示同意</span><span class="color">服务条款</span><span>和</span><span class="color">隐私条款</span>
    </div>
    <div class="btn-wrapper">
      <div class="btn" @click="submit_register($event)">注册账号</div>
    </div>
    <div class="already-wrapper">
      <span>已有账号，直接</span><span class="color" @click="gotoLogin()">登录</span>
    </div>
  </div>
</template>

<script type='text/ecmascript-6'>
/* eslint-disable */
import router from "../../router";
export default {
  data() {
    return {
      username_register: "",
      password_register: "",
      email_register: "",
      varidate_register: "",
      varidate_register_real: ""
    };
  },
  methods: {
    gotoLogin() {
      router.push("/login");
    },
    submit_register(event) {
      var uPattern = /^[a-zA-Z0-9_-]{4,16}$/;
      if (!uPattern.test(this.username_login)) {
        alert("请输入4-16位只包含数字、字母、下划线及减号的用户名");
        return false;
      }
      if (this.password_login.length < 6) {
        alert("请输入大于六位的密码");
        return false;
      }
      if (!this.varidate_register_real === varidate_register) {
        alert("验证码错误");
        return false;
      }
      event.preventDefault();
      var formdata = new Formdata();
      formdata.append("username", this.username_login);
      formdata.append("password", this.password_login);
      formdata.append("email", this.email_register);
      formdata.append("varidate", this.varidate_register);
      let config = {
        headers: {
          "Content-Type": "multipart/form-data"
        }
      };
      this.$ajax.post("", formData, config).then(response => {
        //传入参数位置及表单
        if (response.data === -1) {
          alert("用户已存在");
          return false;
        } else {
          alert("注册成功");
          router.push({
            path: "", //进入首页并传递参数至首页
            query: { username: this.username }
          });
        }
      });
    },
    submit_varidata_register(event) {
      var ePattern = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
      if (!ePattern.test(this.email_register)) {
        alert("请输入正确的邮箱");
        return false;
      }
      event.preventDefault();
      var formdata = new Formdata();
      formdata.append("email", this.email_register);
      let config = {
        headers: {
          "Content-Type": "multipart/form-data"
        }
      };
      this.$ajax.post("", formData, config).then(response => {
        //传入参数位置及表单
        alert("已发送验证码,请注意查收");
        this.varidate_register_real = response.data;
      });
    }
  }
};
</script>
<style lang='stylus' rel='stylesheet/stylus'>
.box-register {
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

  .register-wrapper {
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
      height: 280px;
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

      .varidate-btn {
        display: inline-block;
        width: 80px;
        height: 30px;
        float: right;
        background: #fc8d59;
        text-align: center;
        line-height: 30px;
        border-radius: 4px;
        margin-top: -5px;
        color: #fff;
        font-size: 14px;
        cursor: pointer;
      }
    }
  }

  .agree-wrapper {
    margin-top: 10px;

    span {
      font-size: 14px;
    }

    .color {
      color: #fc8d59;
      text-decoration: underline;
      cursor: pointer;
    }
  }

  .btn-wrapper {
    width: 350px;
    height: 60px;
    background: #fc8d59;
    margin: 0 auto;
    cursor: pointer;
    margin-top: 30px;
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

  .already-wrapper {
    margin-top: 30px;

    span {
      font-size: 22px;
    }

    .color {
      color: #fc8d59;
      cursor: pointer;
    }
  }
}
</style>
