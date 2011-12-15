Ext.define('PATCHPLAN.view.Viewport', {
    extend: 'Ext.container.Viewport',


    initComponent: function() {
        var me = this;
        
        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'toolbar',
                    items: [
                        {
                            xtype: 'button',
                            text: 'Plan'
                        },
                        {
                            xtype: 'tbseparator'
                        },
                        {
                            xtype: 'button',
                            text: 'Template'
                        },
                        {
                            xtype: 'tbspacer',
                            height: 13,
                            width: 665
                        },
                        {
                            xtype: 'tbseparator',
                            width: 15
                        },
                        {
                            xtype: 'button',
                            text: 'Logout'
                        }
                    ]
                },
                {
                    xtype: 'container',
                    items: [
                        {
                            xtype: 'toolbar',
                            items: [
                                {
                                    xtype: 'buttongroup',
                                    title: 'Datacenter',
                                    columns: 2,
                                    layout: {
                                        columns: 2,
                                        type: 'table'
                                    },
                                    items: [
                                        {
                                            xtype: 'button',
                                            text: 'Active'
                                        },
                                        {
                                            xtype: 'button',
                                            text: 'DR'
                                        }
                                    ]
                                },
                                {
                                    xtype: 'buttongroup',
                                    width: 759,
                                    title: 'Interfaces',
                                    columns: 2,
                                    layout: {
                                        columns: 2,
                                        type: 'table'
                                    },
                                    items: [
                                        {
                                            xtype: 'button',
                                            text: 'APP - OPS'
                                        },
                                        {
                                            xtype: 'button',
                                            text: 'APP - IB'
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    xtype: 'citylist'
                }
            ]
        });

        me.callParent(arguments);
    }
});