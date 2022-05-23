
const formFields = require('./formFields');

module.exports = {
  layout: 'BaseTitle',
  title: '新增合约',
  items: [
    {
      layout: 'Content',
      component: 'Form',
      config: {
        goBack: true,
        API: {
          // getAPI: '/api/application/powercontractapplication/<id>',
          // updateAPI: '/api/contract/contracts/<id>',
        },
        layout: 'Grid',
        layoutConfig: {
          value: [8, 8, 8],
        },
        fields: formFields,
      },
    },
  ],
};
