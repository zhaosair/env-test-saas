import React from 'react';
import ZEle from 'zero-element';
import config from './config/TrialAdd';

export default function TrialAdd(props) {
  return <ZEle namespace='product_trial_add' config={config} />;
}