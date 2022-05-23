import React from 'react';
import useBreadcrumb from '@/framework/useBreadcrumb';
import ZEle from 'zero-element';

const config = {
  layout: 'Content',
  title: '实名认证',
  items: [
    {
      component: 'Form',
      config: {
        goBack: false,
        API: {
          getAPI: '/api/crud/cinema/user/userCenter/advInfo',
          updateAPI: '/api/crud/advertiser/advertisers/self',
        },
        layout: 'Grid',
        layoutConfig: {
          value: [24],
        },
        fields: [
          {
            field: 'companyName', label: '企业名称', type: 'text-area',
            props: {
              autoSize: {
                minRows: 1,
              }
            },
            rules: ['required']
          },
          {
            field: 'pcd', label: '所在地区', type: 'pcd',
            // rules: ['required']
          },
          {
            field: 'industry', label: '所在行业', type: 'pcd',
            options: {
              API: '/api/crud/industry/query',
              map: [
                { type: 'X', value: 'xIndustry' },
                { type: 'L', value: 'lIndustry' },
                { type: 'M', value: 'mIndustry' },
              ],
            },
            // rules: ['required']
          },
          // { field: '_group1', type: 'group', value: '上传身份证' },
          // {
          //   field: 'ID', type: 'upload-image-card', span: 8,
          //   options: {
          //     title: '上传身份照正面',
          //     width: 200,
          //     height: 120,
          //     tips: '支持上传JPG、JPEG、PNG格式图片, 大小不能超过5MB',
          //   }
          // },
          // {
          //   field: 'ID', type: 'upload-image-card', span: 8,
          //   options: {
          //     title: '上传身份照背面',
          //     width: 200,
          //     height: 120,
          //     tips: '支持上传JPG、JPEG、PNG格式图片, 大小不能超过5MB',
          //   }
          // },
          { field: '_group2', type: 'group', value: '上传营业执照', span: 24 },
          {
            field: 'businessLicenseProve', type: 'upload-image-card',
            options: {
              width: 200,
              height: 120,
              tips: '支持上传JPG、JPEG、PNG格式图片, 大小不能超过5MB',
            }
          },
          // { field: '_group3', type: 'group', value: '上传行业资质证明' },
          // {
          //   field: 'ID', type: 'upload-image-card',
          //   options: {
          //     width: 200,
          //     height: 120,
          //     tips: '支持上传JPG、JPEG、PNG格式图片, 大小不能超过5MB',
          //   }
          // },
          {
            field: 'read', type: 'agree-agreement',
            rules: [{
              type: 'required',
              message: '需要您阅读并同意'
            }]
          },
        ]
      }
    }
  ]
};

export default function () {
  useBreadcrumb([
    { title: '首页', path: '/' },
    { title: '实名认证' },
  ]);

  return <ZEle namespace='security_auth' config={config} />

}