import React from 'react';
import DetailsTemplate from '@/components/Details/DetailsTemplate';
import setting from './config/tenantManage-setting';
    
export default () => {

  return <DetailsTemplate
    namespace="tenantManage_view"
    setting={setting}
    config={setting.viewConfig}
  />
}
    
