import React, { useState, useRef } from 'react';
import ZEle from 'zero-element';
import config from './config';
import qs from 'qs';
import { post, query } from 'zero-element-antd/lib/utils/request';
import { history } from 'umi';
import { useWillMount } from 'zero-element/lib/utils/hooks/lifeCycle';
import { Spin } from 'antd';
import { setPageData, useModel } from 'zero-element/lib/Model';

export default function salesChancEdit({ location }) {
  const { id } = qs.parse(location.search.replace('?', ''));
  const [formData, setFormData] = useState({});
  const formDataRef = useRef({});
  const model = useModel('contract');

  useWillMount(_ => {
    query(`/api/application/powercontractapplication/${id}`)
      .then(data => {
        const rst = {
          ...data,
        }
        const cycleUnitMap = {
          month: '月',
          week: '周',
        };

        formDataRef.current = {
          powerContractApplicationModel: data,
        };

        rst.cycleUnitText = cycleUnitMap[data.cycleUnit];
        setPageData('contract', 'formData', rst);
        model.save('formData', rst);
        setFormData(rst);
      })
  });

  function handleSubmit(data) {
    const {
      accountID, alignmentDate, contractStartDate,
      startReading,
      // powerContractApplicationID,
    } = data;
    post('/api/contract/contracts', {
      accountID,
      alignmentDate,
      contractStartDate,
      startReading,
      powerContractApplicationID: id,
      powerContractApplicationModel: formDataRef.current.powerContractApplicationModel,
    })
      .then(_ => {
        history.goBack();
      })
  }

  return <div>
    {formData.id ? (
      <ZEle
        keepData
        namespace="contract"
        config={config}
        // extraData={formData}
        onSubmit={handleSubmit}
      />
    ) : <Spin />}
  </div>
}