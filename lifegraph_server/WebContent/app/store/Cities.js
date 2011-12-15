Ext.define('PATCHPLAN.store.Cities', {
	
	extend: 'Ext.data.Store',
	model: 'PATCHPLAN.model.City',
	autoLoad: true,
	
	proxy: {
		type: 'ajax',
		api: {
			read: '/WebViz/city/view.action',
		    update: ''
		},
		reader: {
			type: 'json',
			root: 'cities',
			successProperty: 'success'
		}
	}
});