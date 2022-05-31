import React from 'react';
import ZEle from 'zero-element';
import config from './config/Evaluate';

export default function Evaluate() {
  return <ZEle namespace='product_evaluate' config={config} />;
}