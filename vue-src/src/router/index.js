import Vue from 'vue'
import Router from 'vue-router'
import information from '@/components/information/information'
import editInformation from '@/components/information/editInformation'

Vue.use(Router);

export default new Router({
	routes: [
		{
			path: '/',
			name: 'information',
			component: information
		},
		{
			path: '/editInformation',
			name: 'editInformation',
			component: editInformation
		}
	]
})
