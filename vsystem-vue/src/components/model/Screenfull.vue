 <template>
    <el-tooltip class="item" effect="dark" content="全屏" placement="bottom">
    <svg class="icon" aria-hidden="true" @click="toggleFull()">
      <use xlink:href="#icon-quanping" />
    </svg>
    </el-tooltip>
</template>

<script>
import screenfull from "screenfull";
export default {
  data() {
    return {
      isFullscreen: false
    };
  },
  methods: {
    toggleFull() {
      if (screenfull.enabled) {
        screenfull.toggle();
      } else {
        this.$message({
          message: "your browser can not work",
          type: "warning"
        });
        return false;
      }
    }
  }
};
</script>

 <style  scoped>
.icon {
  width: 2.5em;
  height: 2.5em;
  vertical-align: -0.9em;
  fill: currentColor;
  overflow: hidden;
}
</style>


