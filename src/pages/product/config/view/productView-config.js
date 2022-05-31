const setting = require('./config/productView-setting.json');

module.exports = {
  layout: setting.layout.form,
  title: setting.pageName.view,
  items: [
    {
      component: 'Form',
      config: {
        API: {
            listAPI: setting.listAPI,
            getAPI: setting.getAPI
        },
        layout: 'Grid',
        layoutConfig: {
          value: Array(setting.columns).fill(~~(24 / setting.columns)),
        },
        fields: setting.createFields || setting.formFields,
        otherProps:{
          footerButton: false
        }
      },
    },
  ],
};
