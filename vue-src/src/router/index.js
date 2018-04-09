import Vue from 'vue'
import Router from 'vue-router'
import base from '@/components/admin/base'
import login from '@/components/admin/login'
import admin from './admin'

Vue.use(Router);

export default new Router({
	routes: [
		{
			path: '/admin',
			component: base,
			children: admin     // 代表下级路由
		},
		{
			path: '/login',
			name: 'login',
			component: login,
			meta: {requireAuth: false}
		},
		{
			path: '/',
			meta: {requireAuth: true}
		}
	]
})
