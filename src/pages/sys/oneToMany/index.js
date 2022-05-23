import React from 'react';
import ZEle from 'zero-element';
import config from './config';

export default function () {

  return <div>
    <ZEle
      namespace="contract"
      config={config}
    />
  </div>
}