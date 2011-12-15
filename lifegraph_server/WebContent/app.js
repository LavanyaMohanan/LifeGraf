Ext.Loader.setConfig({
	enabled: true
});

Ext.create('Ext.app.Application', {

	name: 'PATCHPLAN',
	autoCreateViewport: false,
	controllers: ['PatchPlans'],
	launch: function(){}

});