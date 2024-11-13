import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import login from '@/views/login'
import comments from '@/views/comments'
import index from '@/views/index'
import console from '@/views/console';
import student from '@/views/student';
import user from '@/views/user';


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/login',
      name: 'login',
      component: login
    },
    {
      path: '/index',
      name: 'index',
      component: index,
      children:[
        {
          path: '/console',
          name: 'console',
          component: console
        },
        {
          path: '/student',
          name: 'student',
          component: student
        },
        {
          path: '/user',
          name: 'user',
          component: user
        },{
		  path: '/comments',
		  name: 'comments',
		  component: comments
		},
      ],
    },
		
    
  ]
})
