<template>
<div class="login">
  <el-form :model="loginForm" status-icon :rules="rules" ref="loginForm"  label-width="100px" class="login-form">
  <el-form-item label="请输入用户名:" prop="username">
    <el-input type="text" v-model="loginForm.username" autocomplete="off"  />
  </el-form-item>
  <el-form-item label="请输入密码:" prop="password" >
    <el-input type="password" v-model="loginForm.password" autocomplete="off"  />
  </el-form-item>
  <el-form-item  class="form-item">
    <el-button type="primary" @click="submitForm('loginForm')" >登录</el-button>
    <el-button @click="resetForm('loginForm')" >重置</el-button>
  </el-form-item>
</el-form>
</div>
</template>

<script>
export default {
  data() {
    var validateUsername = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("用户名不能为空"));
      } else {
        callback();
      }
    };
    var validatePassword = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("密码不能为空"));
      } else {
        callback();
      }
    };
    return {
      loginForm: {
        username: "",
        password: "",
      },
      rules: {
        username: [{ validator: validateUsername, trigger: "blur" }],
        password: [{ validator: validatePassword, trigger: "blur" }],
      }
    };
  },
  methods: {
     submitForm(formName) {
       var _this = this;
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var formdata = new FormData();
            formdata.append("username",this.loginForm.username);
            formdata.append("password",this.loginForm.password);
            this.$axios.post("/login",formdata).then(resp=>{
              if(resp.data.status=="success"){
               _this.$router.replace({ path: "/home" })
              }else{
               _this.$message.error(resp.data.msg);
               _this.$refs[formName].resetFields();
              }
            })
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
  }
};
</script>
<style scoped>
  .login-form {
    background-clip: padding-box;
    margin: 290px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
  }
  .login{
    width: 100%;
    height: 100%;
    display: inline-table;
    background-image: url("http://pic1.win4000.com/wallpaper/2018-10-10/5bbd6379b2b20.jpg")
  }
  /* .form-item{
    opacity:1 !important
  } */
  .el-button{
     opacity:0.5
  }
</style>


