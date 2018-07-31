<template>
  <div class="box-forget">
    <div class="text-wrapper">
      <span>欢迎加入猫公益</span>
    </div>
    <div class="register-wrapper">
      <span>修改密码</span>
    </div>
    <div class="form-wrapper">
      <form class="form">
        <label for="username" class="label">新密码：&nbsp;</label>
        <input type="text" name="username" class="input" placeholder="请设置新密码" autocomplete="off" v-model="newPassword1"><br>
        <div class="line-bottom"></div><br><br>
        <label for="password" class="label">新密码：&nbsp;</label>
        <input type="password" name="password" class="input" placeholder="请再次输入新密码" autocomplete="off" v-model="newPassword2"><br>
        <div class="line-bottom"></div><br><br>
        <label for="email" class="label">邮箱：&nbsp;&nbsp;&nbsp;&nbsp;</label>
        <input type="email" name="email" class="input" placeholder="请输入您注册时使用的邮箱" autocomplete="off" v-model="email_forget"><br>
        <div class="line-bottom"></div><br><br>
        <label for="varidate" class="label">验证码:&nbsp;&nbsp;&nbsp;</label>
        <input type="text" name="varidate" class="input" placeholder="请输入您的验证码" autocomplete="off" v-model="varidate_forget">
        <div class="varidate-btn">获取验证码</div>
        <div class="line-bottom"></div>
      </form>
    </div>
    <div class="btn-wrapper">
      <div class="btn">确认修改</div>
    </div>
    <div class="already-wrapper">
      <span>改变主意，直接</span><span class="color" @click="gotoLogin()">登录</span>
    </div>
  </div>
</template>

<script type='text/ecmascript-6'>
/* eslint-disable */
import router from "../../router";
export default {
  data() {
    return {
      newPassword1: "",
      newPassword2: "",
      email_forget: "",
      varidate_forget: "",
      varidate_forget_real: ""
    };
  },
  methods: {
    gotoLogin() {
      router.push("/login");
    },
    submit_forget(event) {
      if (!this.varidate_forget === this.varidate_forget_real) {
        alert("验证码错误");
        return false;
      }
      var uPattern = /^[a-zA-Z0-9_-]{4,16}$/;
      if (!uPattern.test(this.username_login)) {
        alert("请输入4-16位只包含数字、字母、下划线及减号的用户名");
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
      formdata.append("email", this.email_register);
      formdata.append("varidate", this.varidate_forget);
      let config = {
        headers: {
          "Content-Type": "multipart/form-data"
        }
      };
      this.$ajax.post("", formData, config).then(response => {
        //传入参数位置及
        if (response.data === -1) {
          alert("新密码不能与原密码相同");
        } else {
          alert("修改成功");
          router.push({
            path: "", //进入首页并传递参数至首页
            query: { username: this.username }
          });
        }
      });
    },
    submit_varidata_forget(event) {
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
        alert("已发送验证码,注意查收");
        this.varidate_forget_real = response.data;
      });
    }
  }
};
</script>
<style lang='stylus' rel='stylesheet/stylus'>
.box-forget {
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
