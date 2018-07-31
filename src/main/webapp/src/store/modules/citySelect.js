export default {
  state: {
    cityArr: []
  },
  mutations: {
    changeCity (state, arr) { // 修改cityArr储存的数据为新选择的地址
      state.cityArr = arr
    }
  }
}
