<template>
    <el-container id="container-top">
      <el-aside width="170px">
        <v-menu @addTabs="addTabs" />
      </el-aside>
       <el-container>
        <el-header>
           <span>{{petname}}</span>
        </el-header>
         <el-main>
           <v-tabs ref="tabs" />
         </el-main>
       </el-container>
    </el-container>
</template>

<script>
import menu from "./model/Menu.vue";
import tabs from './model/Tabs.vue'
export default {
  components: {
    "v-menu": menu,
    "v-tabs": tabs
  },
  data() {
    return {
      petname: ""
    };
  },
  methods: {
    loadPetname() {
      this.$axios.post("/loadPetname").then(resp => {
        if (
          resp.data.indexOf("<!DOCTYPE html><html><head><meta charset=utf-8>")
        ) {
          this.petname=resp.data
        }
      });
    },
    addTabs(item){
      this.$refs.tabs.addTabs(item)
    }
  },
  mounted() {
    this.loadPetname();
  }
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



