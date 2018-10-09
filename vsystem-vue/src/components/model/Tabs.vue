<template>
<el-container>
    <el-header>
      <el-tabs v-model="maintabs" type="card" closable @tab-remove="removeTab" @tab-click="tabclick">
        <el-tab-pane
          v-for="item in moretab"
          :key="item.name"
          :label="item.title"
          :name="item.name">
        </el-tab-pane>
      </el-tabs>
    </el-header>
    <el-main>
      <router-view />
    </el-main>
</el-container>
</template>

<script>
export default {
  data() {
    return {
      maintabs: "2",
      moretab: []
    };
  },
  mounted(){
    this.$router.push({ path: '/homepage' });
  },
  methods: {
    addTabs(item) {
      this.moretab.push({
        title: item.name,
        name: item.route
      }),
        this.$router.push({ path: item.route });
      this.maintabs = item.route;
    },
    removeTab(targetName) {
      let tabs = this.moretab;
      let activeName = this.maintabs;
      if (activeName === targetName) {
        tabs.forEach((tab, index) => {
          if (tab.name === targetName) {
            let nextTab = tabs[index + 1] || tabs[index - 1];
            if (nextTab) {
              activeName = nextTab.name;
            }
          }
        });
      }
      this.maintabs = activeName;
      this.moretab = tabs.filter(tab => tab.name !== targetName);
      if (this.moretab.length > 0) {
        this.$router.push({ path: this.moretab[this.moretab.length - 1].name });
      } else {
        this.$router.push({ path: "/homepage" });
      }
    },
    tabclick(tab) {
      this.$router.push({ path: tab.name });
    }
  }
};
</script>

<style scoped>
</style>
