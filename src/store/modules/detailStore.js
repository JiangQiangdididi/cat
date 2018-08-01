export default {
  state: {
    itemDetail: {},
    isCommentShow: true
  },
  mutations: {
    changeItem (state, obj) { // 存储单个详细页的详情数据
      state.itemDetail = obj
    },
    changeCommentState (state) {
      state.isCommentShow = !state.isCommentShow
    }
  }
}
