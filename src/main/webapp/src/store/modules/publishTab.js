export default {
  state: {
    currentTab: 'find-master'
  },
  mutations: {
    changeItem (state, val) {
      state.currentTab = val
    }
  }
}
