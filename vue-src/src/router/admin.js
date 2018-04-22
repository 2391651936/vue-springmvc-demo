import information from '@/components/admin/information/information'
import editInformation from '@/components/admin/information/editInformation'
import people from '@/components/admin/people/people'
import editPeople from '@/components/admin/people/editPeople'
import equipmentType from '@/components/admin/equipmentType/equipmentType'
import editEquipmentType from '@/components/admin/equipmentType/editEquipmentType'

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
	},

	{
		path: 'equipmentType',
		name: 'equipmentType',
		component: equipmentType,
		meta: {requireAuth: true}
	},
	{
		path: 'editEquipmentType',
		name: 'editEquipmentType',
		component: editEquipmentType,
		meta: {requireAuth: true}
	},
]