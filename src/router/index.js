/* eslint-disable */
import Vue from 'vue'
import Router from 'vue-router'
import publish from '@/components/publish/publish'
import diary from '@/components/diary/diary'
import slogan from '@/components/slogan/slogan'
import forget from '@/components/slogan/forget.vue'
import register from '@/components/slogan/register.vue'
import login from '@/components/slogan/login.vue'
import community from '@/components/community/community.vue'
import index from '@/components/index/index.vue'
Vue.use(Router)

const routes = [
  {
    path: '/',
    component: resolve => require(['../views/layout.vue'], resolve ),
    children: [
      { path: '/index', component: index },
      { path: '/community', component: community },
      { path: '/publish', component: publish },
      { path: '/diary', component: diary },
      {
        path: '/my',
        component: resolve => require(['../views/my/my-layout.vue'], resolve),
        children: [
          {
            path: '/my',
            name: 'personal-data',
            component: resolve => require(['../views/my/personal-data.vue'], resolve)
          },
          {
            path: '/my/notify',
            name: 'notify',
            component: resolve => require(['../views/my/notify.vue'], resolve)
          },
          {
            path: '/my/collection',
            name: 'collection',
            component: resolve => require(['../views/my/collection.vue'], resolve)
          },
          {
            path: '/my/about-adopt',
            name: 'about-adopt',
            component: resolve => require(['../views/my/about-adopt.vue'], resolve)
          },
          {
            path: '/my/about-me-cat',
            name: 'about-me-cat',
            component: resolve => require(['../views/my/about-me-cat.vue'], resolve)
          }
        ]
      }
    ]
  },
  {
    path: '/slogan',
    name: 'slogan',
    component: slogan
  },
  {
    path: '/login',
    name: 'login',
    component: login
  },
  {
    path: '/register',
    name: 'register',
    component: register
  },
  {
    path: '/forget',
    name: 'forget',
    component: forget
  }
]

export default new Router({
  routes: routes
})
