import information from '@/components/admin/information/information'
import editInformation from '@/components/admin/information/editInformation'
import people from '@/components/admin/people/people'
import editPeople from '@/components/admin/people/editPeople'

export default [
	{
		path: "editInformation",
		name: 'editInformation',
		component: editInformation,
		meta: {requireAuth: true}
	},
	{
		path: "/",
		name: 'information',
		component: information,
		meta: {requireAuth: true}
	},
	
	{
		path: 'people',
		name: 'people',
		component: people,
		meta: {requireAuth: true}
	},
	{
		path: 'editPeople',
		name: 'editPeople',
		component: editPeople,
		meta: {requireAuth: true}
	}
]