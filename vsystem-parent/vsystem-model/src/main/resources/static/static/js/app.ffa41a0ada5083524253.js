webpackJsonp([6],{"1PzO":function(t,e){},"8k38":function(t,e){},NHnr:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=n("7+uW"),r={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{attrs:{id:"app"}},[e("router-view")],1)},staticRenderFns:[]},o=n("VU/8")({name:"App"},r,!1,null,null,null).exports,i=n("/ocq"),s={data:function(){return{loginForm:{username:"",password:""},rules:{username:[{validator:function(t,e,n){""===e?n(new Error("用户名不能为空")):n()},trigger:"blur"}],password:[{validator:function(t,e,n){""===e?n(new Error("密码不能为空")):n()},trigger:"blur"}]}}},methods:{submitForm:function(t){var e=this,n=this;this.$refs[t].validate(function(a){if(!a)return!1;var r=new FormData;r.append("username",e.loginForm.username),r.append("password",e.loginForm.password),e.$axios.post("/login",r).then(function(e){"error"!=e.data.status?n.$router.replace("/home"):(n.$message.error(e.data.msg),n.$refs[t].resetFields())})})},resetForm:function(t){this.$refs[t].resetFields()}}},u={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"login"}},[n("el-form",{ref:"loginForm",staticClass:"login-form",attrs:{model:t.loginForm,"status-icon":"",rules:t.rules,"label-width":"100px"}},[n("el-form-item",{attrs:{label:"请输入用户名:",prop:"username"}},[n("el-input",{attrs:{type:"text",autocomplete:"off"},model:{value:t.loginForm.username,callback:function(e){t.$set(t.loginForm,"username",e)},expression:"loginForm.username"}})],1),t._v(" "),n("el-form-item",{attrs:{label:"请输入密码:",prop:"password"}},[n("el-input",{attrs:{type:"password",autocomplete:"off"},model:{value:t.loginForm.password,callback:function(e){t.$set(t.loginForm,"password",e)},expression:"loginForm.password"}})],1),t._v(" "),n("el-form-item",[n("el-button",{attrs:{type:"primary"},on:{click:function(e){t.submitForm("loginForm")}}},[t._v("登录")]),t._v(" "),n("el-button",{on:{click:function(e){t.resetForm("loginForm")}}},[t._v("重置")])],1)],1)],1)},staticRenderFns:[]};var l=n("VU/8")(s,u,!1,function(t){n("1PzO")},"data-v-1865525c",null).exports,c={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("el-menu",{attrs:{"background-color":"#505050","text-color":"#fff","active-text-color":"#ffd04b"}},t._l(t.menus,function(e,a){return n("el-submenu",{key:a,attrs:{index:t.$index+""}},[n("template",{slot:"title"},[n("i",{class:e.icon}),t._v(" "),n("span",[t._v(t._s(e.name))])]),t._v(" "),t._l(e.childrenMenus,function(e){return n("el-menu-item",{key:e,attrs:{index:e.route},on:{click:function(n){t.clickitem(e)}}},[t._v("\n        "+t._s(e.name)+"\n      ")])})],2)}))},staticRenderFns:[]};var m={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("el-container",[n("el-header",[n("el-tabs",{attrs:{type:"card",closable:""},on:{"tab-remove":t.removeTab,"tab-click":t.tabclick},model:{value:t.maintabs,callback:function(e){t.maintabs=e},expression:"maintabs"}},t._l(t.moretab,function(t){return n("el-tab-pane",{key:t.name,attrs:{label:t.title,name:t.name}})}))],1),t._v(" "),n("el-main",[n("router-view")],1)],1)},staticRenderFns:[]};var d={components:{"v-menu":n("VU/8")({data:function(){return{menus:[]}},mounted:function(){this.loadMenu()},methods:{loadMenu:function(){var t=this;this.$axios.post("/loadMenu").then(function(e){var n=[],a=e.data,r=[];if(e.data.indexOf("<!DOCTYPE html><html><head><meta charset=utf-8>")){for(var o=0;o<a.length;o++)null==a[o].parentId&&n.push(a[o]);for(var i=function(t){a.forEach(function(e){n[t].mId==e.parentId&&r.push(e)}),n[t].childrenMenus=r,r=[]},s=0;s<n.length;s++)i(s)}t.menus=n})},clickitem:function(t){this.$emit("addTabs",t)}}},c,!1,function(t){n("k9Gs")},"data-v-315d2cd5",null).exports,"v-tabs":n("VU/8")({data:function(){return{maintabs:"2",moretab:[]}},mounted:function(){this.$router.push({path:"/homepage"})},methods:{addTabs:function(t){this.moretab.push({title:t.name,name:t.route}),this.$router.push({path:t.route}),this.maintabs=t.route},removeTab:function(t){var e=this.moretab,n=this.maintabs;n===t&&e.forEach(function(a,r){if(a.name===t){var o=e[r+1]||e[r-1];o&&(n=o.name)}}),this.maintabs=n,this.moretab=e.filter(function(e){return e.name!==t}),this.moretab.length>0?this.$router.push({path:this.moretab[this.moretab.length-1].name}):this.$router.push({path:"/homepage"})},tabclick:function(t){this.$router.push({path:t.name})}}},m,!1,function(t){n("8k38")},"data-v-3d45958d",null).exports},data:function(){return{petname:""}},methods:{loadPetname:function(){var t=this;this.$axios.post("/loadPetname").then(function(e){e.data.indexOf("<!DOCTYPE html><html><head><meta charset=utf-8>")&&(t.petname=e.data)})},addTabs:function(t){this.$refs.tabs.addTabs(t)}},mounted:function(){this.loadPetname()}},h={render:function(){var t=this.$createElement,e=this._self._c||t;return e("el-container",{attrs:{id:"container-top"}},[e("el-aside",{attrs:{width:"170px"}},[e("v-menu",{on:{addTabs:this.addTabs}})],1),this._v(" "),e("el-container",[e("el-header",[e("span",[this._v(this._s(this.petname))])]),this._v(" "),e("el-main",[e("v-tabs",{ref:"tabs"})],1)],1)],1)},staticRenderFns:[]};var p=n("VU/8")(d,h,!1,function(t){n("nJRQ")},null,null).exports;a.default.use(i.a);var f=new i.a({routes:[{path:"/",name:"Login",component:l,hidden:!0},{path:"/home",name:"主页",component:p,children:[{path:"/user1",name:"user1",component:function(t){return n.e(2).then(function(){var e=[n("RBiv")];t.apply(null,e)}.bind(this)).catch(n.oe)}},{path:"/user2",name:"user2",component:function(t){return n.e(3).then(function(){var e=[n("FJSr")];t.apply(null,e)}.bind(this)).catch(n.oe)}},{path:"/admin1",name:"admin1",component:function(t){return n.e(1).then(function(){var e=[n("4/S0")];t.apply(null,e)}.bind(this)).catch(n.oe)}},{path:"/admin2",name:"admin2",component:function(t){return n.e(4).then(function(){var e=[n("6xwZ")];t.apply(null,e)}.bind(this)).catch(n.oe)}},{path:"/homepage",name:"homepage",component:function(t){return n.e(0).then(function(){var e=[n("FeYb")];t.apply(null,e)}.bind(this)).catch(n.oe)}}],hidden:!0,meta:{requireAuth:!0}}]}),v=n("mtWM"),b=n.n(v),g=n("zL8q"),_=n.n(g);n("tvR6");a.default.use(_.a,{size:"small",zIndex:3e3}),a.default.prototype.$axios=b.a,a.default.config.productionTip=!1,new a.default({el:"#app",router:f,components:{App:o},template:"<App/>"})},k9Gs:function(t,e){},nJRQ:function(t,e){},tvR6:function(t,e){}},["NHnr"]);
//# sourceMappingURL=app.ffa41a0ada5083524253.js.map