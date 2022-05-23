import React from 'react';
import DetailsTemplate from '@/components/Details/DetailsTemplate';
import {TheConfig} from './index'

export default function DefaultView(){

    return <DetailsTemplate
    namespace={`${TheConfig.pageName.name||"default"}_view`}
    setting={TheConfig}
    config={TheConfig.viewConfig}
  />
}