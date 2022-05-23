import React from 'react';
import ZEle from 'zero-element';
import config from './config';
import qs from 'qs';

export default function salesChancEdit({ location }) {
  const { id } = qs.parse(location.search.replace('?', ''));

  return <div>
    <ZEle
      namespace="contract"
      config={config}
      extraData={{
        id,
      }}
    />
  </div>
}