import React from 'react';
import ZEle from 'zero-element';
import config from './config/index';
import useBreadcrumb from '@/framework/useBreadcrumb';
export default function DynamicPage(){
    useBreadcrumb([
        { title: '首页', path: '/' },
        { title: '动态页面管理' },
    ]);
    return <ZEle namespace="dynamicPage" config={config} />;
}