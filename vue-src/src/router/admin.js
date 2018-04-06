import information from '@/components/admin/information/information'
import editInformation from '@/components/admin/information/editInformation'

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
	}
]