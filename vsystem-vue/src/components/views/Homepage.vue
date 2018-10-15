<template>
  <div>
    <h1>{{$t('message.hello')}}</h1>
    <el-button type="primary" @click="open">{{$t('btn.text')}}</el-button>
  </div>
  
</template>

<script>
export default {
  data() {
    return {
      value1: '',
      value: ''
    }
  },
}
</script>

<style scoped>
</style>


