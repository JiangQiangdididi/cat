<template>
  <div class="edit-input">
    <label>{{label}}</label>
    <p v-if="!edit">{{inputText}}</p>
    <input type="text" v-model="inputText" v-if="edit" @keyup.enter="clickEvents">
    <button type="button" @click="clickEvents">{{!edit?'修改':'完成'}}</button>
  </div>
</template>

<script>
/* eslint-disable */
  export default {
    data(){
      return{
        edit: false,
        inputText: this.text
      }
    },
    props:['label','text'],
    methods:{
      clickEvents(){
        this.$emit('clickEvents');
        this.edit = !this.edit;
      }
    }
  }
</script>

<style scoped>
  .edit-input{
    display: flex;
    align-items: center;
    line-height: 35px;
  }
  .edit-input label{
    width: 5em;
    flex: none;
    font-weight: 800;
    color: #333;
    font-size: 14px;
  }
  .edit-input p{
    margin: 0;
    width: 100%;
    font-size: 14px;
    color: #777;
  }
  .edit-input input{
    width: 100%;
    line-height: 33px;
    border:1px solid #ccc;
    border-radius: 6px;
    padding: 0 5px;
    color: #777;
  }
  .edit-input button{
    flex: none;
    background: none;
    border: 0;
    cursor: pointer;
    line-height: 33px;
    width: 100px;
    text-align: left;
    color: #777;
  }
</style>
