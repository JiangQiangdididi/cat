<template>
  <div class="publish">
    <cat-tab :link-name="linkName"></cat-tab>
    <router-view></router-view>
  </div>
</template>

<script>
import catTab from '../common/catTab/catTab'
import { mapState } from 'vuex'
export default {
  data () {
    return {
      linkName: 'publish'
    }
  },
  computed: {
    ...mapState({
      currentTab (state) {
        return state.publishTab.currentTab
      }
    })
  },
  components: {
    'cat-tab': catTab
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">
  body
    background #f6f6f6
</style>
