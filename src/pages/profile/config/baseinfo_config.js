export const config = {
    layout: 'Content',
    // title: '个人信息',
    items: [
      {
        layout: 'Empty',
        component: 'Form',
        config: {
          goBack: false,
          API: {
            getAPI: '/api/adm/users/userInfo',
            updateAPI: '/api/adm/users/self',
          },
          layout: 'Grid',
          layoutConfig: {
            value: [24, 12],
          },
          fields: [
            {
              field: 'avatar', type: 'avatars',
              options: {
                API: '/api/fs/uploadfile',
                type: 'text',
                max: 1,
              },
              span: 24,
            },
            { field: 'account', label: '账号', type: 'plain'},

            { field: 'name', label: '昵称', type: 'input',span:24 },
            {
              field: 'sex', label: '性别', type: 'radio',
              options: [
                { label: '男', value: 0 },
                { label: '女', value: 1 },
              ],
              span: 24  
            },
            { field: 'birthday', label: '生日', type: 'date' },
            
            { field: 'email', label: '邮箱', type: 'input', span: 24 },
          ]
        }
      },
    ]
  };