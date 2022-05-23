import React from 'react';
import DetailsTemplate from '@/components/Details/DetailsTemplate';
import setting from './config/fieldTemplate-setting.json';
import useBreadcrumb from "@/framework/useBreadcrumb"

export default () => {

    useBreadcrumb([
        { title: '首页', path: '/' },
        { title: '管理员选项',path:'/designpage/config'},
        { title: "字段模板管理",path:'/fieldTemplate'},
        { title: "字段模板详情"}
    ]);
  return <DetailsTemplate
    namespace="fieldTemplate_view"
    setting={setting}
    config={setting.viewConfig}
  />
}
    
