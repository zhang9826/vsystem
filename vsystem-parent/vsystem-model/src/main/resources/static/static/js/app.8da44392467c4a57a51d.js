webpackJsonp([6],{"1PzO":function(e,t){},"4fXw":function(e,t){},DgvH:function(e,t){},NHnr:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=n("7+uW"),o={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{attrs:{id:"app"}},[t("router-view")],1)},staticRenderFns:[]},a=n("VU/8")({name:"App"},o,!1,null,null,null).exports,i=n("/ocq"),s={data:function(){return{loginForm:{username:"",password:""},rules:{username:[{validator:function(e,t,n){""===t?n(new Error("用户名不能为空")):n()},trigger:"blur"}],password:[{validator:function(e,t,n){""===t?n(new Error("密码不能为空")):n()},trigger:"blur"}]}}},methods:{submitForm:function(e){var t=this,n=this;this.$refs[e].validate(function(r){if(!r)return!1;var o=new FormData;o.append("username",t.loginForm.username),o.append("password",t.loginForm.password),t.$axios.post("/login",o).then(function(t){"error"!=t.data.status?n.$router.replace("/home"):(n.$message.error(t.data.msg),n.$refs[e].resetFields())})})},resetForm:function(e){this.$refs[e].resetFields()}}},u={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"login"}},[n("el-form",{ref:"loginForm",staticClass:"login-form",attrs:{model:e.loginForm,"status-icon":"",rules:e.rules,"label-width":"100px"}},[n("el-form-item",{attrs:{label:"请输入用户名:",prop:"username"}},[n("el-input",{attrs:{type:"text",autocomplete:"off"},model:{value:e.loginForm.username,callback:function(t){e.$set(e.loginForm,"username",t)},expression:"loginForm.username"}})],1),e._v(" "),n("el-form-item",{attrs:{label:"请输入密码:",prop:"password"}},[n("el-input",{attrs:{type:"password",autocomplete:"off"},model:{value:e.loginForm.password,callback:function(t){e.$set(e.loginForm,"password",t)},expression:"loginForm.password"}})],1),e._v(" "),n("el-form-item",[n("el-button",{attrs:{type:"primary"},on:{click:function(t){e.submitForm("loginForm")}}},[e._v("登录")]),e._v(" "),n("el-button",{on:{click:function(t){e.resetForm("loginForm")}}},[e._v("重置")])],1)],1)],1)},staticRenderFns:[]};var l=n("VU/8")(s,u,!1,function(e){n("1PzO")},"data-v-1865525c",null).exports,c={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-menu",{attrs:{"background-color":"#505050","text-color":"#fff","active-text-color":"#ffd04b"}},e._l(e.menus,function(t,r){return n("el-submenu",{key:r,attrs:{index:e.$index+""}},[n("template",{slot:"title"},[n("i",{class:t.icon}),e._v(" "),n("span",[e._v(e._s(t.name))])]),e._v(" "),e._l(t.childrenMenus,function(t){return n("el-menu-item",{key:t,attrs:{index:t.route},on:{click:function(n){e.clickitem(t)}}},[e._v("\n        "+e._s(t.name)+"\n      ")])})],2)}))},staticRenderFns:[]};var m={components:{"v-menu":n("VU/8")({data:function(){return{menus:[]}},mounted:function(){this.loadMenu(),this.$router.push({path:"/homepage"})},methods:{loadMenu:function(){var e=this;this.$axios.post("/loadMenu").then(function(t){var n=[],r=t.data,o=[];if(t.data.indexOf("<!DOCTYPE html><html><head><meta charset=utf-8>")){for(var a=0;a<r.length;a++)null==r[a].parentId&&n.push(r[a]);for(var i=function(e){r.forEach(function(t){n[e].mId==t.parentId&&o.push(t)}),n[e].childrenMenus=o,o=[]},s=0;s<n.length;s++)i(s)}else e.$router.push({path:"/"});e.menus=n})},clickitem:function(e){this.$router.push({path:e.route})}}},c,!1,function(e){n("4fXw")},"data-v-778a93a1",null).exports},data:function(){return{petname:""}},methods:{loadPetname:function(){var e=this;this.$axios.post("/loadPetname").then(function(t){t.data.indexOf("<!DOCTYPE html><html><head><meta charset=utf-8>")?e.petname=t.data:e.$router.push({path:"/"})})}},mounted:function(){this.loadPetname()}},p={render:function(){var e=this.$createElement,t=this._self._c||e;return t("el-container",{attrs:{id:"container-top"}},[t("el-aside",{attrs:{width:"170px"}},[t("v-menu")],1),this._v(" "),t("el-container",[t("el-header",[t("span",[this._v(this._s(this.petname))])]),this._v(" "),t("el-main",[t("router-view")],1)],1)],1)},staticRenderFns:[]};var d=n("VU/8")(m,p,!1,function(e){n("DgvH")},null,null).exports;r.default.use(i.a);var f=new i.a({routes:[{path:"/",name:"Login",component:l,hidden:!0},{path:"/home",name:"主页",component:d,children:[{path:"/user1",name:"user1",component:function(e){return n.e(2).then(function(){var t=[n("RBiv")];e.apply(null,t)}.bind(this)).catch(n.oe)}},{path:"/user2",name:"user2",component:function(e){return n.e(3).then(function(){var t=[n("FJSr")];e.apply(null,t)}.bind(this)).catch(n.oe)}},{path:"/admin1",name:"admin1",component:function(e){return n.e(1).then(function(){var t=[n("4/S0")];e.apply(null,t)}.bind(this)).catch(n.oe)}},{path:"/admin2",name:"admin2",component:function(e){return n.e(4).then(function(){var t=[n("6xwZ")];e.apply(null,t)}.bind(this)).catch(n.oe)}},{path:"/homepage",name:"homepage",component:function(e){return n.e(0).then(function(){var t=[n("FeYb")];e.apply(null,t)}.bind(this)).catch(n.oe)}}],hidden:!0,meta:{requireAuth:!0}}]}),h=n("mtWM"),v=n.n(h),g=n("zL8q"),_=n.n(g);n("tvR6");r.default.use(_.a,{size:"small",zIndex:3e3}),r.default.prototype.$axios=v.a,r.default.config.productionTip=!1,new r.default({el:"#app",router:f,components:{App:a},template:"<App/>"})},tvR6:function(e,t){}},["NHnr"]);
//# sourceMappingURL=app.8da44392467c4a57a51d.js.map