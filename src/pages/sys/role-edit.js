import React from 'react';
import ZEle from 'zero-element';
import useBreadcrumb from '@/framework/useBreadcrumb';
import config from './config/Role/edit-form.config';

export default function RoleAdd(props) {

  useBreadcrumb(props, [
    { title: '首页', path: '/' },
    { title: '系统管理' },
    { title: '角色', path: '/sys/role' },
    { title: '编辑角色' },
  ]);

  return <ZEle namespace='role' config={config} />;
}