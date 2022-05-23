import React from 'react';
import ZEle from 'zero-element';
import config from './config/dataReport-add';

import useBreadcrumb from '@/framework/useBreadcrumb';
import { useWillUnmount } from 'zero-element/lib/utils/hooks/lifeCycle';
import switchEndpoint from '@/components/switchEndpoint';

export default () => {
    useBreadcrumb([
        { title: '首页', path: '/' },
        { title: '系统管理',path:'/sys'},
        { title: '报表管理',path:'/sys/dataReport'},
        { title: "新增统计报表"}
    ]);
    useWillUnmount(switchEndpoint)
    return <ZEle namespace="dataReport_add" config={config} />
}
