Ext.Loader.setConfig({
	enabled: true
});

Ext.create('Ext.app.Application', {

	name: 'PATCHPLAN',
	autoCreateViewport: true,
	controllers: ['PatchPlans'],
	launch: function(){}

});