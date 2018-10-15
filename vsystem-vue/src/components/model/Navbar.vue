<template>
    <div class="navbar">
        <div class="right-menu">
        <screenfull class="screenfull" />
        <div class="lang">
          <el-dropdown>
           <svg class="icon" aria-hidden="true">
                <use xlink:href="#icon-language"></use>
           </svg>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item @click.native="toggleLang('zh')" :disabled="$i18n.locale == 'zh'">中文</el-dropdown-item>
              <el-dropdown-item @click.native="toggleLang('en')" :disabled="$i18n.locale == 'en'">English</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
        <el-dropdown trigger="click">
            <span class="el-dropdown-link">
                {{petname}}
            </span>
        <el-dropdown-menu slot="dropdown">
            <el-dropdown-item><span @click="logout">退出</span></el-dropdown-item>
        </el-dropdown-menu>
        </el-dropdown>
        </div>
    </div>
</template>

<script>
import screenfull from "@/components/model/Screenfull";
import iconfont from "@/../static/icon/iconfont";
export default {
  components: {
    screenfull
  },
  data() {
    return {
      petname: ""
    };
  },
  mounted() {
    this.loadPetname();
  },
  methods: {
    loadPetname() {
      this.$axios.get("/loadPetname").then(resp => {
        if (
          resp.data.indexOf("<!DOCTYPE html><html><head><meta charset=utf-8>")
        ) {
          this.petname = resp.data;
        } else {
          this.$router.push({ path: "/" });
        }
      });
    },
    logout() {
      this.$axios.post("/logout").then(resp => {
        this.$router.push({ path: "/" });
      });
    },
    toggleLang(lang) {
      if (lang == "zh") {
        localStorage.setItem("locale", "zh");
        this.$i18n.locale = localStorage.getItem("locale");
        this.$message({
          message: "切换为中文！",
          type: "success"
        });
      } else if (lang == "en") {
        localStorage.setItem("locale", "en");
        this.$i18n.locale = localStorage.getItem("locale");
        this.$message({
          message: "Switch to English!",
          type: "success"
        });
      }
    }
  }
};
</script>

<style scoped>
.screenfull,
.lang {
  display: inline-block;
  height: 22px;
  line-height: 22px;
  margin: 0 8px;
  cursor: pointer;
  vertical-align: -0.15em;
}
.icon {
  width: 2em;
  height: 2em;
  vertical-align: -0.5em;
  fill: currentColor;
  overflow: hidden;
}
</style>
