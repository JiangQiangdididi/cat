<template>
  <div class="publish-find-master">
    <!--头像-->
    <div class="user-photo">
      <img src="" alt="">
    </div>
    <!--文本框-->
    <div class="text">
      <textarea name="" id=""></textarea>
    </div>
    <!--上传图片-->
    <div class="upload-wrap">
      <el-upload
        class="upload-demo"
        action="https://jsonplaceholder.typicode.com/posts/"
        :limit = "9"
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :on-success = "handleSuccess"
        :file-list="fileList"
        list-type="picture-card">
        <el-button size="small" type="primary">点击添加图片</el-button>
      </el-upload>
      <div class="cat-pic">
        <img :src="uploadPic" alt="">
      </div>
    </div>
    <!--城市选择器-->
    <div class="city-select-wrap">
      <city-select :citySelectData="citySelectData"></city-select> <!-- *传递数据到citySelect组件-->
    </div>
    <!--发布按钮-->
    <div class="pub-btn">
      <el-button
        @click="handlePub"
        :loading="pubBtnState.isLoading">发布</el-button>
    </div>
  </div>
</template>

<script>
import citySelect from '../../common/citySelect/citySelect' // *调用城市select组件
import { mapState } from 'vuex' // *引入vuex的state
export default {
  data () {
    return {
      fileList: [
        {
          name: 'food.jpeg',
          url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
        },
        {
          name: 'food2.jpeg',
          url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
        }
      ],
      citySelectData: { // *父组件调用时，传入级联选择器的参数
        order: 2, // *级联选择器需要的级数，根据需要来进行修改，可供选择的范围有1，2，3
        phStr: '所在位置', // *级联选择器的placeholder内容，不需要时设置为空字符串
        className: 'publish-city-select' // *级联选择器的class，两种样式，pub-city-select、index-city-select、community-city-select
      },
      pubBtnState: {
        isLoading: false
      }
    }
  },
  computed: {
    ...mapState({
      chosenCity (state) { // *城市选择后，父组件的此计算属性相应改变
        return state.citySelect.cityArr
      }
    }),
    uploadPic () {
      let firstItem = this.fileList[0]
      return firstItem ? firstItem.url : ''
    }
  },
  methods: {
    handleRemove (file, fileList) {
      this.fileList = fileList
      console.log(file, fileList)
    },
    handlePreview (file) {
      console.log(file)
    },
    handleSuccess (response, file, fileList) {
      this.fileList = fileList
    },
    handlePub () {

    }
  },
  components: {
    'city-select': citySelect
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">
  .publish-find-master
    padding-left 120px
    position relative
    .user-photo
      background #ccc
      border-radius 50%
      position absolute
      left 0
      top 0
      height 80px
      width 80px
      img
        height 100%
        width 100%
    .text
      width 100%
      textarea
        border 1px solid #ccc
        border-radius 5px
        box-sizing border-box
        font-size 14px
        min-height 188px
        padding 20px 10px
        resize none
        width 100%
        &:focus
          -webkit-box-shadow: 0px 0px 5px #ddd
          -moz-box-shadow: 0px 0px 5px #ddd
          box-shadow: 0px 0px 5px #ddd
          -webkit-transition: all .2s
          -moz-transition: all .2s
          -ms-transition: all .2s
          -o-transition: all .2s
          transition: all .2s
    .upload-wrap
      margin-top 30px
      overflow hidden
      .upload-demo
        box-sizing: border-box;
        float left
        position relative
        padding-top 60px
        margin-right 400px
        padding-left 90px
        padding-right: 400px;
        width: 100%;
        div.el-upload.el-upload--picture-card
          height auto
          width auto
          border none
          line-height normal
          position absolute
          top 0
          left 0
          .el-button
            background #fc8d59
            border-color #fc8d59
            padding 8px 23px
            &:hover
              background #fca86c
              border-color #fca86c
        ul
          li
            margin 0 30px 30px 0
            height 80px
            width 80px
      .cat-pic
        float right
        margin-left -100%
        height 400px
        width 400px
        img
          height 100%
          width 100%
    .city-select-wrap
      margin-top 30px
    .pub-btn
      margin-top 100px
      text-align center
      button
        background #fc8d59
        border-style none
        color #ffffff
        font-size 26px
        width 500px
</style>
