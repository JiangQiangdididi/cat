<template>
  <div class="about-adopt">
    <ul class="custom-tabs-item" ref="tabsItem">
      <li @click="tabClick(index)" v-for="(item,index) in ['我的领养','领养我的']" :key="index" :class="[index==idx?'active': '']">
        {{item}}
      </li>
    </ul>
    <div class="custom-tabs-content">
      <ul class="custom-tabs" v-if="idx == 0">
        <li v-for="(list,index) in adoptList" :key="index">
          <div class="adopt-list-warp">
            <div class="portrait">
              <img :src="list.portrait" alt="">
            </div>
            <div class="adopt-list-info">
              <edit-input label="猫猫" :text="list.catName" @clickEvents="editCatInfo(1)"></edit-input>
              <edit-input label="主人" :text="list.master" @clickEvents="editCatInfo(2)"></edit-input>
              <edit-input label="领养日" :text="list.adoptTime" @clickEvents="editCatInfo(3)"></edit-input>
              <edit-input label="健康状况" :text="list.health" @clickEvents="editCatInfo(4)"></edit-input>
              <edit-input label="领养地址" :text="list.adoptPlace" @clickEvents="editCatInfo(5)"></edit-input>
            </div>
          </div>
        </li>
      </ul>
      <ul class="custom-tabs" v-if="idx == 1">
        <li v-for="(list,index) in adoptedList" :key="index">
          <div class="adopt-list-warp">
            <div class="portrait">
              <img :src="list.portrait" alt="">
            </div>
            <div class="adopt-list-info">
              <edit-input label="猫猫" :text="list.catName" @clickEvents="editCatInfo(1)"></edit-input>
              <edit-input label="主人" :text="list.master" @clickEvents="editCatInfo(2)"></edit-input>
              <edit-input label="领养日" :text="list.adoptTime" @clickEvents="editCatInfo(3)"></edit-input>
              <edit-input label="健康状况" :text="list.health" @clickEvents="editCatInfo(4)"></edit-input>
              <edit-input label="领养地址" :text="list.adoptPlace" @clickEvents="editCatInfo(5)"></edit-input>
            </div>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
/* eslint-disable */
import editInput from '../../components/my/edit-input.vue'
export default {
  name: 'about-adopt',
  data () {
    return {
      idx: 0,
      vlaue: 'asdasd',
      show: false,
      adoptList: [
        {
          portrait: require('../../assets/logo.png'),
          catName: 'xx',
          master: 'xx',
          adoptTime: '2018-05-05',
          health: '健康',
          adoptPlace: 'xxxxxxxxxxxx'
        },
        {
          portrait: require('../../assets/logo.png'),
          catName: 'xx',
          master: 'xx',
          adoptTime: '2018-05-05',
          health: '健康',
          adoptPlace: 'xxxxxxxxxxxx'
        }
      ],
      adoptedList: [
        {
          portrait: require('../../assets/logo.png'),
          catName: 'xx',
          master: 'xx',
          adoptTime: '2018-05-05',
          health: '健康',
          adoptPlace: 'xxxxxxxxxxxx'
        },
        {
          portrait: require('../../assets/logo.png'),
          catName: 'xx',
          master: 'xx',
          adoptTime: '2018-05-05',
          health: '健康',
          adoptPlace: 'xxxxxxxxxxxx'
        }
      ]
    }
  },
  methods: {
    tabClick (index) {
      this.idx = index
    },
    editCatInfo (text) {
      switch (text) {
        case 1:
          console.log('catName');
          break;
        case 2:
          console.log('master');
          break;
        case 3:
          console.log('adoptTime');
          break;
        case 4:
          console.log('health');
          break;
        case 5:
          console.log('adoptPlace');
          break;
      }
    }
  },
  components: {
    editInput
  }
}
</script>

<style>
@import "custom.css";
.about-adopt .custom-tabs{
  margin: 0;
  padding: 20px 40px;
}
.about-adopt .custom-tabs li{
  border-bottom: 1px solid #ccc;
  padding: 10px 5px;
}
.adopt-list-warp{
  display: flex;
  align-items: flex-start;
}
.adopt-list-warp .portrait{
  background: #ccc;
  margin-right: 2em;
  border-radius: 6px;
  overflow: hidden;
  flex: none;
  width: 180px;
}
.adopt-list-warp .portrait img{
  width: 100%;
}
.adopt-list-info{
  width: 100%;
}
</style>
