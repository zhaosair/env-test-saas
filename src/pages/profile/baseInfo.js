import React from 'react';
import useBreadcrumb from '@/framework/useBreadcrumb';
import ZEle from 'zero-element';
import { Avatar } from 'antd'
import { removeToken, getUserName, getExtra, getAvatar } from 'zero-element/lib/utils/request/token';
import { UserOutlined } from '@ant-design/icons';
import {config} from './config/baseinfo_config'
export default function () {
  useBreadcrumb([
    { title: '首页', path: '/' },
    { title: '用户管理'},
  ]);
  console.log(getAvatar())

  
  return <>
    <ZEle namespace='security_baseInfo' config={config} />
  </>
}