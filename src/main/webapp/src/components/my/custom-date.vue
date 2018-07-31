<template>
  <div class="components-date">
    <div ref="year">
      <div class="components-select">
        <input type="text" placeholder="请选择" v-model="yearContent.year" readonly>
        <button type="button" @click="num == 0 ? num = -1 : num = 0">
          <i class="el-icon-arrow-down"></i>
        </button>
        <transition name="el-zoom-in-top">
          <el-scrollbar class="components-option" v-if="num == 0">
            <ul>
              <li v-for='(n,index) in yearContent.yearData' :data-value="n" @click="yearChange(index)" :class="{'active': index === yIndex}" :key="index">
                {{n}}
              </li>
            </ul>
          </el-scrollbar>
        </transition>
      </div>
    </div>
    <span>年</span>
    <div ref="month">
      <div class="components-select">
        <input type="text" placeholder="请选择" v-model="monthContent.month" readonly>
        <button type="button" @click="num == 1 ?  num = -1 : num = 1">
          <i class="el-icon-arrow-down"></i>
        </button>
        <transition name="el-zoom-in-top">
          <el-scrollbar class="components-option" v-if="num == 1">
            <ul>
              <li v-for='(m,index) in monthContent.monthData' :data-value="m" @click="monthChange(index)" :class="{'active': index === mIndex}" :key="index">
                {{m}}
              </li>
            </ul>
          </el-scrollbar>
        </transition>
      </div>
    </div>
    <span>月</span>
    <div ref="day">
      <div class="components-select">
        <input type="text" placeholder="请选择" v-model="dayContent.day" readonly>
        <button type="button" @click="num == 2 ? num = -1 : num = 2">
          <i class="el-icon-arrow-down"></i>
        </button>
        <transition name="el-zoom-in-top">
          <el-scrollbar class="components-option" v-if="num == 2">
            <ul>
              <li v-for='(d,index) in dayContent.dayData' :data-value="d" @click="dayChange(index)" :class="{'active': index === dIndex}" :key="index">
                {{d}}
              </li>
            </ul>
          </el-scrollbar>
        </transition>
      </div>
    </div>
    <!--<select v-model='yearContent.year' @change='yearChange'>
      <option v-for='n in yearContent.yearData' :value='n'>{{n}}</option>
    </select>
    <span>年</span>
    <select v-model='monthContent.month' @change='monthChange'>
      <option v-for='m in monthContent.monthData' :value='m'>{{m}}</option>
    </select>
    <span>月</span>
    <select v-model='dayContent.day' @change='dayChange'>
      <option v-for='d in dayContent.dayData' :value='d'>{{d}}</option>
    </select>
    <span>日</span>-->
  </div>
</template>

<script>
/* eslint-disable */
  export default {
    props: ['nowdata','mindata','maxdata'],
    data: function () {
      return {
        yearContent: {
          year: '',
          yearData: [],
          min_year: '',
          max_year: ''
        },
        monthContent: {
          month: '01',
          monthData: [],
          min_month: '',
          max_month: ''
        },
        dayContent: {
          day: '01',
          dayData: [],
          max_day: ''
        },
        static: {
          isFirst: true,
          isSecond: true
        },
        yIndex: 0,
        mIndex: 0,
        dIndex: 0,
        num: -1
      }
    },
    created: function () {
      let vm = this;
      vm.yearContent.year = new Date().getFullYear();
      vm.yearContent.min_year = !!vm.mindata ? vm.sliceData(vm.mindata).year : 1970 ;
      vm.monthContent.min_month = !!vm.mindata ? vm.sliceData(vm.mindata).month : 1 ;

      vm.yearContent.max_year = !!vm.maxdata ? vm.sliceData(vm.maxdata).year : new Date().getFullYear() ;
      vm.monthContent.max_month = !!vm.maxdata ? vm.sliceData(vm.maxdata).month : 12 ;

      for (var i = vm.yearContent.max_year - vm.yearContent.min_year ; i >= 0 ; i--){
        vm.yearContent.yearData.push(Number(vm.yearContent.min_year) + i);
      }
      vm.yearChange();
      vm.monthChange();
//      console.log(vm.defaultSelection())
    },
    methods: {
      sliceData: function (data) {
        if (data && data.length == 6){
          var year = data.slice(0,4);
          var month = data.slice(4);
          return {year: year, month: month};
        }
      },
      yearChange: function (index=0) {
        let vm = this;
        vm.monthContent.monthData = [];
        let min = vm.yearContent.year == vm.yearContent.min_year ? vm.monthContent.min_month : 1;
        let max = vm.yearContent.year == vm.yearContent.max_year ? vm.monthContent.max_month : 12;
        for (let i = 0 ; i <= max - min ; i++){
          vm.monthContent.monthData.push(Number(min) + i < 10 ? '0' + (Number(min) + i) : Number(min) + i);
        }
        if(vm.yIndex !== index){
          vm.num = -1;
        }
        vm.yIndex = index;
        vm.yearContent.year = vm.yearContent.yearData[index];
        vm.$emit('timechange',vm.yearContent.year + '' + vm.monthContent.month + '' + vm.dayContent.day);
      },
      monthChange: function (index=0) {
        let vm = this;
        vm.dayContent.dayData = [];
        vm.max_day = (new Date(vm.yearContent.year?vm.yearContent.year:new Date().getFullYear(),vm.monthContent.monthData[index]?vm.monthContent.monthData[index]:1,0)).getDate();
        for (let i = 1 ; i <= vm.max_day ; i++ ) {
          vm.dayContent.dayData.push(i < 10 ? '0' + i : i)
        }
        if(vm.mIndex !== index){
          vm.num = -1;
        }
        vm.mIndex = index;
        vm.monthContent.month = vm.monthContent.monthData[index];
        vm.$emit('timechange',vm.yearContent.year + '' + vm.monthContent.month + '' + vm.dayContent.day);
      },
      dayChange: function (index=0) {
        let vm = this;
        if(vm.dIndex !== index){
          vm.num = -1;
        }
        vm.dIndex = index;
        vm.dayContent.day = vm.dayContent.dayData[index];
        vm.$emit('timechange',vm.yearContent.year + '' + vm.monthContent.month + '' + vm.dayContent.day);
      }
    }
  }
</script>

<style scoped>
  .components-date{
    display: flex;
  }
  .components-date span{
    font-size: 12px;
    line-height: 32px;
    width: 2em;
    text-align: center;
    color: #777;
  }
  .components-select{
    position: relative;
    padding-left: 8px;
    display: flex;
    border: 1px solid #999;
  }
  .components-select input{
    border: 0;
    width: 4em;
    padding: 0;
    line-height: 30px;
    color: #777;
  }
  .components-select button{
    background: #cccccc;
    border: 1px solid #999;
    height: 100%;
    line-height: 28px;
    padding: 0;
    font-size: 20px;
    color: #777;
    cursor: pointer;
  }
  .components-select button:focus{
    outline: none;
  }
  .components-select .components-option{
    position: absolute;
    left: -1px;
    top:100%;
    width: 100%;
    border:1px solid #ccc;
    background: #fff;
    z-index: 10;
    max-height: 300px;
    height: 300px;
  }
  .components-select .components-option ul{
    margin: 0;
    padding: 0;
  }
  .components-select .components-option li{
    padding: 5px;
    color: #555;
    cursor: pointer;
    user-select: none;
  }
  .components-select .components-option li.active{
    background: #ccc;
  }
</style>
