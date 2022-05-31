const setting = require('./config/freightView-setting.json');

module.exports = {
  layout: setting.layout.form,
  title: setting.pageName.view,
  items: [
    {
      component: 'Form',
      config: {
        API: {
            getAPI: setting.getAPI
        },
        layout: 'Grid',
        layoutConfig: {
          value: Array(setting.columns).fill(~~(24 / setting.columns)),
        },
        fields: setting.fields,
        otherProps:{
          footerButton: false
        }
      },
    },
  ],
};
