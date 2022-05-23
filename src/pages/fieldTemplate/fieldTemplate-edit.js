import React from 'react';
import ZEle from 'zero-element';
import config from './config/fieldTemplate-edit';

import useBreadcrumb from "@/framework/useBreadcrumb"


export default () => {
    useBreadcrumb([
        { title: '首页', path: '/' },
        { title: '管理员选项',path:'/designpage/config'},
        { title: "字段模板更改"}
    ]);
    return <ZEle namespace="fieldTemplate_edit" config={config} />
}
