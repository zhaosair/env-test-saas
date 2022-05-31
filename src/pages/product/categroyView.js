import React from 'react';
import ZEle from 'zero-element';
import config from './config/view/categroyView-config';
import useBreadcrumb from '@/framework/useBreadcrumb';

export default function categroyView(){
    useBreadcrumb([
        { title: '主页', path: '/' },
        { title: '类别详情' }
      ]);    
    return <ZEle namespace="product_categroy_view" config={config} />;
}