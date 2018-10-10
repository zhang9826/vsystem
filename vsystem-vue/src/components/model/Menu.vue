<template>
   <el-menu
    background-color="#505050"
    text-color="#fff"
    active-text-color="#ffd04b">
    <el-submenu v-for="(item,index) in menus" :key="index" :index="index+''">
      <template slot="title">
        <i :class="item.icon"/>
        <span>{{item.name}}</span>
      </template>
        <el-menu-item v-for="child in  item.childrenMenus" :key="child" @click="clickitem(child)" :index="child.route">
          {{child.name}}
        </el-menu-item>
    </el-submenu>
  </el-menu>
</template>
<script>
export default {
  data() {
    return {
      menus: []
    };
  },
  mounted() {
    this.loadMenu();
    this.$router.push({ path: "/homepage" });
  },
  methods: {
    loadMenu() {
      var _this = this;
      _this.$axios.post("/loadMenu").then(resp => {
        var tempMenus = [];
        var respMenus = resp.data;
        var temp = [];
        if (
          resp.data.indexOf("<!DOCTYPE html><html><head><meta charset=utf-8>")
        ) {
          for (let index = 0; index < respMenus.length; index++) {
            if (respMenus[index].parentId == null) {
              tempMenus.push(respMenus[index]);
            }
          }
          for (let index = 0; index < tempMenus.length; index++) {
            respMenus.forEach(element => {
              if (tempMenus[index].mId == element.parentId) {
                temp.push(element);
              }
            });
            tempMenus[index].childrenMenus = temp;
            temp = [];
          }
        }else{
           this.$router.push({ path: "/" })
        }
        this.menus = tempMenus;
      });
    },
    clickitem(item) {
      this.$router.push({ path: item.route });
    }
  }
};
</script>

<style scoped>
.el-menu-item {
  min-width: 150px !important;
}
</style>
