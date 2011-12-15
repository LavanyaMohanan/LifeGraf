Ext.define('PATCHPLAN.view.Grid' , {

	extend: 'Ext.grid.Panel',	
	alias : 'widget.citylist',
	title : 'All Cities',
	store: 'Cities',	

	columns: [{
		header: 'Name',
		dataIndex: 'name',
		flex: 1
	},{
		header: 'Counntry',
		dataIndex: 'countryId',
		flex: 1
	}]
});