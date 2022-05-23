import React from 'react';
import { PageHeader } from 'antd';
import BodyPage from './config/testField-editField';

import useBreadcrumb from '@/framework/useBreadcrumb';
import { useWillUnmount } from 'zero-element/lib/utils/hooks/lifeCycle';
import switchEndpoint from '@/components/switchEndpoint';

export default function workFlowListStep() {
    useBreadcrumb([
        { title: '首页', path: '/' },
        { title: '系统管理', path: '/sys' },
        { title: '自定义字段', path: '/sys/fieldCustom' },
        { title: '编辑字段' },
    ]);
    useWillUnmount(switchEndpoint)

    return <PageHeader
        title="编辑字段"
        ghost={false}
        onBack={() => window.history.back()}
    >
        <BodyPage/>
    </PageHeader>
};
