import React from 'react';

import ZEle from 'zero-element';
import { useModel, removeModel } from 'zero-element/lib/Model';
import config from './config';
import { history } from 'umi';
import { post } from 'zero-element-antd/lib/utils/request';
import { useWillUnmount } from 'zero-element/lib/utils/hooks/lifeCycle';

export default function () {
  const { namespace } = history.location.query;
  const model = useModel('contract');

  useWillUnmount(_ => {
    removeModel(namespace);
  })

  function handleSubmit(data, goBack) {
    post('/api/account/accounts', data)
      .then(data => {
        const { id, accountNumber } = data;

        model.save('formData', {
          ...model.formData,
          accountID: id,
          accountNumber,
        });
        goBack({ code: 200 });
      })
  }
  return <ZEle
    namespace={namespace}
    config={config}
    onSubmit={handleSubmit}
  />
}
// export default function () {
//   function handleOnSubmitAfter(data) {
//     const model = getModel('contract');
//     const { formData } = model.getState();
//     model.setState('formData', {
//       ...formData,
//       accountID: data.id,
//       accountNumber: data.accountNumber,
//     });
//   }
//   return <AccountAdd
//     namespace="contract_account"
//     onSubmitAfter={handleOnSubmitAfter}
//   />
// }