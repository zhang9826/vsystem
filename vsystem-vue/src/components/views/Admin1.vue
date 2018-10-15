<<template>
  <div>


  </div>
</template>

<script>
export default {
    mounted(){

    },
    methods:{
        loadUser(){
            this.$axios.get("/loadUser").then(resp=>{

            })
        }
    }

}
</script>

<style>

</style>
