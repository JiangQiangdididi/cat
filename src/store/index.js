import Vue from 'vue'
import Vuex from 'vuex'
import detailStore from './modules/detailStore'
import citySelect from './modules/citySelect'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    count: 0
  },
  mutations: {
    increment (state) {
      state.count++
    }
  },
  modules: {
    detailStore: detailStore,
    citySelect: citySelect
  }
})
