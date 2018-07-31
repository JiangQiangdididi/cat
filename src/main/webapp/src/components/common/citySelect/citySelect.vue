<template>
  <div class="city-select" :class="citySelectData.className">
    <el-cascader
      :options="options"
      change-on-select
      :placeholder="citySelectData.phStr"
      size="medium"
      @change="getChosenLocation"
    ></el-cascader>
  </div>
</template>
<script>
import axios from 'axios'
export default {
  props: ['citySelectData'],
  data () {
    return {
      options: [],
      mapJson: '../../static/json/map.json'
    }
  },
  methods: {
    getCityData () { // 使用axios获取数据
      let that = this
      axios.get(this.mapJson).then(function (res) {
        that.options = that.convertJsonKey(res.data)
      }).catch(function (error) {
        console.log(typeof +error)
      })
    },
    convertJsonKey (arr) { // 转换Json的key为需要的key值
      let option = this.recursionReplace(arr, this.citySelectData.order)
      return option
    },
    recursionReplace (arr, order, num = 1) { // 递归替换key函数
      let newArr
      let that = this
      newArr = arr.map(function (item, index) {
        let obj = {}
        for (let a in item) {
          if (a === 'code') {
            obj['value'] = item[a]
          } else if (a === 'name') {
            obj['label'] = item[a]
          } else {
            if (num !== order) {
              num++
              obj[a] = that.recursionReplace(item[a], order, num)
              num = 1 // 重置
            }
          }
        }
        return obj
      })
      return newArr
    },
    getChosenLocation (val) { // 选中后得到的数组值
      console.log(val)
      this.$store.commit('changeCity', val) // 触发vuex，citySelect.js中的mutation方法
    }
  },
  created () {
    this.getCityData()
  }
}
</script>
<style lang="stylus" rel="stylesheet/stylus">
  .publish-city-select // 发布的级联选择器样式
    input.el-input__inner
      background transparent url("pub-pos.png") no-repeat 8px center
      border-color #cccccc
      height: 50px;
      line-height: 50px;
      padding-left: 42px;
      width 500px
    span.el-input__suffix
      display none
    span.el-cascader__label
      line-height: 50px;
      padding: 0 25px 0 42px!important;
  .index-city-select,.community-city-select
    input.el-input__inner
      background transparent
      border-color #91bfdb
      width 150px
    span.el-input__suffix
      display none
</style>
