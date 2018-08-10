export default {
  state: {
    currentTab: 'findMaster'
  },
  mutations: {
    changeItem (state, val) {
      state.currentTab = val
    }
  }
}
