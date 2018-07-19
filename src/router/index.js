import Vue from 'vue'
import Router from 'vue-router'
import publish from '@/components/publish/publish'
import diary from '@/components/diary/diary'

Vue.use(Router)

const routes = [
  { path: '/publish', component: publish },
  { path: '/diary', component: diary },
  {
    path: '/my',
    component: resolve => require(['../views/my/my-layout.vue'], resolve),
    children: [
      {
        path: '/my/personal-data',
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

export default new Router({
  routes: routes
})
