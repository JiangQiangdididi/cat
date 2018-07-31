<template>
  <div class="personal-data">
    <h2 class="custom-my-title">个人资料</h2>
    <form>
      <div class="my-row">
        <div class="input-row upload-header">
          <div class="warpper">
            <span v-if="!user.clippedPictures"></span>
            <img :src="user.clippedPictures">
          </div>
          <div>
            <span class="upload-header-input">浏览 <input type="file" class="custom-file" @change="onFileChange($event)"></span>
            <p>请选择jpg、gif格式，小于2M的图片（使用高质量图片，可生成高清头像）</p>
          </div>
        </div>
      </div>
      <div class="my-row">
        <label class="asterisk">昵称：</label>
        <div class="input-row">
          <input type="text" placeholder="请输入昵称" v-model="user.name">
        </div>
      </div>
      <div class="my-row">
        <label class="asterisk">性别：</label>
        <div class="input-row">
          <label class="custom-radio">
            <span class="custom-radio-input">
              <input type="radio" class="custom-radio-original" name="sex" value="boy" v-model="user.sex">
              <span class="custom-radio-inner"></span>
            </span>
            <span class="custom-radio-label">男</span>
          </label>
          <label class="custom-radio">
            <span class="custom-radio-input">
              <input type="radio" class="custom-radio-original" name="sex" value="girl" v-model="user.sex">
              <span class="custom-radio-inner"></span>
            </span>
            <span class="custom-radio-label">女</span>
          </label>
        </div>
      </div>
      <div class="my-row">
        <label class="asterisk">生日：</label>
        <div class="input-row">
          <custom-data @timechange="changeTime"></custom-data>
        </div>
      </div>
      <div class="my-row">
        <label class="asterisk">手机号：</label>
        <div class="input-row">
          <input type="text" placeholder="请输入手机号码" v-model="user.phone">
        </div>
      </div>
      <div class="my-row">
        <label class="asterisk">现居地址：</label>
        <div class="input-row">
          <input type="text" placeholder="请输入您所在的地址" v-model="user.address">
        </div>
      </div>
      <div class="my-submit-btn">
        <button type="button" @click="submitClick">提交</button>
      </div>
    </form>
    <cropper v-if="showCropper"
             ref="cropper"
             :img="src"
             :autoCrop="options.autoCrop"
             :autoCropWidth="options.autoCropWidth"
             :autoCropHeight="options.autoCropHeight"
             :fixedBox="options.fixedBox"
             @clickConfirm="confirmUpload()"
             @close="closeUpload()"
    ></cropper>
  </div>
</template>

<script>
/* eslint-disable */
import Cropper from '../../components/my/cropper.vue'
import customData from '../../components/my/custom-date.vue'
export default {
  name: 'personal-data',
  data () {
    return {
      birthday: '',
      showCropper: false,
      src: '',
      user: {
        clippedPictures: '',
        name: '',
        sex: 'boy',
        birthday: '',
        phone: '',
        address: ''
      },
      imgData: {
        accept: 'image/gif, image/jpeg , image/jpg'
      },
      options:{
        autoCrop: true,
        autoCropWidth: 200,
        autoCropHeight: 200,
        fixedBox: true
      },
      nowdata: '',
      mindata: '',
      maxdata: '',
    }
  },
  created: function () {
    let vm = this;
    let d = new Date(),
        y = d.getFullYear(),
        m = d.getMonth() + 1;
    vm.nowdata = y + '' + m;
  },
  methods: {
    onFileChange (event) {
      let file = event.target.files[0]
      let fileSize = file.size
      let reader = new FileReader()
      let self = this
      let data
      if (!/\.(gif|jpg|jpeg|png|bmp|GIF|JPG|PNG)$/.test(event.target.value)) {
        self.$message('图片类型必须是.gif,jpeg,jpg,png,bmp中的一种')
        return false
      }
//      reader.readAsDataURL(file)
      reader.onloadend = function (e) {
        if(fileSize > 2*1024*1024){
          self.$message("头像大小不能超过2MB")
          return false
        }else {
          if(typeof e.target === 'object'){
            data = window.URL.createObjectURL(new Blob([e.target.result]))
          }else {
            data = e.target.result
          }
          self.src = data
          self.showCropper = true
        }
      }
      reader.readAsArrayBuffer(file)
    },
    confirmUpload () {
      this.$refs.cropper.getCropData((data) => {
        this.user.clippedPictures = data
        this.closeUpload()
      })
    },
    closeUpload () {
      this.showCropper = false
    },
    changeTime (time) {
      this.user.birthday = time;
    },
    submitClick () {
      console.log(this.user.birthday)
      console.log(this.user.name)
      console.log(this.user.sex)
      console.log(this.user.phone)
//      console.log(this.clippedPictures)
    }
  },
  components: {
    Cropper,
    customData
  }
}
</script>

<style>
@import "custom.css";
.personal-data{
  width: 100%;
}
.upload-header{
  display: flex;
  align-items: flex-start;
  margin-left: 2em;
}
.upload-header>.warpper {
  position: relative;
  width: 100px;
  height: 100px;
  flex: none;
  background: #eee;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #555;
}
.upload-header>div:last-child{

}
.upload-header>.warpper img{
  width: 100%;
  height: 100%;
}
.upload-header p{
  margin: 5px 0 0 10px;
  color: #333;
  font-size: 12px;
}
.my-row{
  display: flex;
  align-items: center;
  margin-bottom: 1em;
}
.my-row>label{
  font-size: 14px;
  color: #333;
  width: 6em;
  text-align: right;
}
.my-row input[type='text']{
  border: 1px solid #999;
  border-radius: 4px;
  padding: 6px 10px;
  width: 200px;
  color: #777;
}
.my-submit-btn{
  margin-top: 50px;
  margin-left: 2rem;
}
.my-submit-btn button{
  background: #fc8d59;
  border: 1px solid #fc8d59;
  color: #fff;
  width: 60px;
  height: 30px;
  border-radius: 5px;
  cursor: pointer;
  font-size: 14px;
}
.asterisk:before{
  content: '*';
  color: red;
  vertical-align: sub;
}
.upload-header-input{
  position: relative;
  border: 1px solid #999;
  color: #999;
  border-radius: 5px;
  font-size: 12px;
  width: 40px;
  height: 20px;
  box-sizing: border-box;
  display: inline-block;
  text-align: center;
  line-height: 20px;
  margin-left: 10px;
  margin-top: 8px;
}
.el-scrollbar__wrap{
  overflow-x: hidden;
  height: 300px;
}
</style>
