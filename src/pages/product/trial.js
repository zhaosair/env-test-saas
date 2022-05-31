import React from 'react';
import ZEle from 'zero-element';
import config from './config/Trial';

export default function Trial(props) {
  return <ZEle namespace='product_trial' config={config} />;
}