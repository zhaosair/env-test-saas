import React from 'react';
import ZEle from 'zero-element';
import config from './config/subTableModel-edit';

import useBreadcrumb from "@/framework/useBreadcrumb"


export default () => {
    useBreadcrumb([
        { title: '首页', path: '/' },
        { title: '管理员选项',path:'/designpage/config'},
        { title: "子表模板管理",path:'/adminOptions/subTableModel'},
        { title: "子表模板更改"}
    ]);
    return <ZEle namespace="subTableModel_edit" config={config} />
}
