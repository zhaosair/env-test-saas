module.exports = {
  layout: 'Content',
  title: '报表管理',
  items: [
    // {
    //   component: 'Search',
    //   config: {
    //     fields: [
    //       {
    //         field: 'name', label: '表单名称', type: 'input',
    //         props: {
    //           placeholder: '请输入',
    //         }
    //       }
    //     ],
    //   },
    // },
    {
      component: 'data_report_tree_list',
      config: {
        API: {
          listAPI: '/api/adm/stat/meta/jsonsetting/<id>',
          deleteAPI: '/api/adm/stat/meta/jsonsetting/(id)'
        },
        tree: {
          API: {
            initAPI: '/api/adm/stat/meta/list',
            appendAPI: undefined,
          }
        },
        actions: [
          {
            "title": "新增",
            "type": "path",
            "options": {
              style: "primary",
              "path": "/sys/dataReport/dataReport-add"
            }
          },
        ],
        fields: [
          { field: 'name', label: '表单名称' },
          { field: 'note', label: '备注' },
        ],
        operation: [
          {
            title: '设计', type: 'path',
            options:{
              outside: true,
              path: "/workFlowManageFR/activitiesFR/activitiesFR-design"
            }
          },
          {
            title: '打印配置', 
            type: 'path',
            options:{
              outside: true,
              path:"activitiesFR/activitiesFR-activityFields"
            },
            expect: {
              field: "hasDocument",
              value: true
            }
          },
          {
            title: '编辑', type: 'path',
            options:{
              outside: true,
              path: "/workFlowManageFR/activitiesFR/activitiesFR-edit"
            }
          },
          {
            title: '删除', type: 'delete'
          }
        ]
      },
    },
  ],
};
