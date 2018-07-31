<template>
  <div class="publish">
    <cat-tab></cat-tab>
    <keep-alive>
      <component v-bind:is="currentTab"></component>
    </keep-alive>
  </div>
</template>

<script>
import catStory from './catStory/catStory'
import findMaster from './findMaster/findMaster'
import catTab from '../common/catTab/catTab'
import { mapState } from 'vuex'
export default {
  data () {
    return {}
  },
  computed: {
    ...mapState({
      currentTab (state) {
        return state.publishTab.currentTab
      }
    })
  },
  components: {
    'find-master': findMaster,
    'cat-story': catStory,
    'cat-tab': catTab
  },
  created () {

  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">
  body
    background #f6f6f6
</style>
