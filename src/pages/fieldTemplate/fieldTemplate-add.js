import React from 'react';
import ZEle from 'zero-element';
import config from './config/fieldTemplate-add.js';

import useBreadcrumb from "@/framework/useBreadcrumb"


export default () => {
    useBreadcrumb([
        { title: '首页', path: '/' },
        { title: '管理员选项',path:'/designpage/config'},
        { title: "字段模板添加"}
    ]);
    return <ZEle namespace="fieldTemplate_add" config={config} />
}
