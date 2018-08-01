<template>
  <div class="cat-story-detail"></div>
</template>

<script>
import { mapState } from 'vuex'
export default {
  computed: {
    ...mapState({
      item (state) {
        return state.detailStore.itemDetail
      }
    })
  }
}
</script>

<style scoped>

</style>
