import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Home from '@/components/Home'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login,
      hidden: true
    }, {
      path: '/home',
      name: 'home',
      component: Home,
      children:[
          {
            path:'/user1',
            name:'user1',
            component:resolve=>require(['@/components/views/User1.vue'],resolve)
          },
          {
            path:'/user2',
            name:'user2',
            component:resolve=>require(['@/components/views/User2.vue'],resolve)
          },
          {
            path:'/admin1',
            name:'admin1',
            component:resolve=>require(['@/components/views/Admin1.vue'],resolve)
          },
          {
            path:'/admin2',
            name:'admin2',
            component:resolve=>require(['@/components/views/Admin2.vue'],resolve)
          },
          {
            path:'/homepage',
            name:'homepage',
            component:resolve=>require(['@/components/views/Homepage.vue'],resolve)
          }
      ],
      hidden: true,
      meta: {
        requireAuth: true
      }
    }
  ]
})
