<template>
    <el-container id="container-top">
      <el-aside width="170px">
        <v-menu />
      </el-aside>
       <el-container>
        <el-header>
          <v-navbar />
        </el-header>
         <el-main>
           <router-view />
         </el-main>
       </el-container>
    </el-container>
</template>

<script>
import menu from "./model/Menu.vue";
import navbar from "./model/Navbar.vue";
export default {
  components: {
    "v-menu": menu,
    "v-navbar":navbar
  },
  data() {
    return {
      petname: ""
    };
  },
};
</script>

<style>
.el-header {
  line-height: 48px;
  height: 48px !important;
  text-align: right;
  font-size: 14px;
  border-bottom: 0.2px solid #dbdbdb;
}
#container-top {
  margin-top: -8px;
  margin-left: -8px;
}
</style>



