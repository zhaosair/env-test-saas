import React, { useState } from 'react';
import Details from '@/components/Details';
import { useWillMount } from 'zero-element/lib/utils/hooks/lifeCycle';
import { query } from 'zero-element-antd/lib/utils/request';
import { withRouter } from 'dva/router';
import qs from 'qs';
import { regionMap } from './config/setting';

// 电话地址邮箱 信息
const paeInfo = [
  { group: '电话', },
  {
    field: 'phones', columns: [
      {
        label: '是否为主要联系电话', field: 'isPrimary',
        valueType: 'tag',
        options: {
          map: {
            0: '否',
            1: '是',
          },
          color: {
            0: '#9E9E9E',
            1: '#135200',
          }
        }
      },
      { label: '联系电话', field: 'phone' },
      { label: '电话类型', field: 'phoneType' },
    ]
  },
  { group: '地址', },
  {
    field: 'addresses', columns: [
      {
        label: '是否为主要联系地址', field: 'isPrimary',
        valueType: 'tag',
        options: {
          map: {
            0: '否',
            1: '是',
          },
          color: {
            0: '#9E9E9E',
            1: '#135200',
          }
        }
      },
      { label: '地址', field: 'address' },
      { label: '地址类型', field: 'addressType' },
    ]
  },
  { group: '邮箱', },
  {
    field: 'emails', columns: [
      {
        label: '是否为主要电子邮箱', field: 'isPrimary',
        valueType: 'tag',
        options: {
          map: {
            0: '否',
            1: '是',
          },
          color: {
            0: '#9E9E9E',
            1: '#135200',
          }
        }
      },
      { label: '电子邮箱', field: 'email' },
      { label: '邮箱类型', field: 'emailType' },
    ]
  },
];
export default withRouter(
  function ContractApplicationView(props) {
    const { location } = props;
    const [data, setData] = useState({});
    const [loading, setLoading] = useState(false);

    useWillMount(_ => {
      const { id } = qs.parse(location.search.replace('?', ''));
      const api = `/api/contract/contracts/${id}`;

      setLoading(true);
      query(api)
        .then(d => {
          setData(d);
        })
        .finally(_ => setLoading(false));
    });
    const { account = {}, preferedLangs = [], otherLanguage } = data;

    return <div>
      <div style={{ background: '#fff', padding: 16 }}>
        <Details
          loading={loading}
          col={3}
          goBack
          data={data}
          fields={[
            { divider: true },

            { group: '基本信息', },
            { label: '称呼', value: account.firstName },
            { label: '电子邮件', value: account.registeredEmail },
            { label: '联系地址', field: 'address' },
            { label: '个人/机构', value: organizationMap[account.isOrganization] },
            { label: '微信', value: account.wechat },
            { label: '登录用户名', value: account.accountName },

            { group: '关键信息', },
            { label: '注册手机', value: account.registeredMobile },
            { label: '证件类别', value: account.IDType },
            { label: '证件号', value: account.IDNumber },
            { label: '姓名', value: account.firstName },
            { label: '名称', value: account.lastName },
            { label: '出生日期', value: account.dob },

            { group: 'ICP 信息', },
            { label: 'ICP No.', field: 'icp' },
            { label: 'Unit', field: 'unit' },
            { label: 'Property Name', field: 'propertyName' },
            { label: 'Number', field: 'number' },
            { label: 'Street', field: 'street' },
            { label: 'Suburb', field: 'suburb' },
            { label: 'Town', field: 'town' },
            {
              label: 'Region', field: 'region',
              map: regionMap,
            },
            { label: 'Post Code', field: 'postcode' },

            { group: '合约基本信息', },
            { label: '套餐名称', field: 'powerContractPlanName' },
            { label: '/KWh', field: 'pricePerKWH' },
            { label: '/Day', field: 'priceperDay' },
            { label: 'PPD', value: <span>{data.ppd || 0} %</span> },
            { label: '合约期', field: 'contractMonth' },
            { label: '押金', field: 'deposit' },
            { label: 'WelcomeCredit', field: 'welcomeCredit' },
            {
              label: '必须自动扣费', field: 'isDirectDebit',
              map: {
                null: '否',
                0: '否',
                1: '是',
              }
            },
            {
              label: '自动续约', field: 'isAutoRenew',
              map: {
                0: '否',
                1: '是',
              }
            },
            // { label: '合约预期生效日期', field: 'proposedDate' },
            { label: '合约预期生效日期', field: 'contractStartDate' },
            { label: '计费周期', value: `${data.billingPeriod} ${data.billingPeriodUnit}` },
            { label: '套餐信息', field: 'packageInfo' },
            {
              label: '断电限制', field: 'disconnectionRestriction', map: {
                0: '否',
                1: '是',
              }
            },
            { label: '医疗限制', field: 'medicalRestrictionType' },
            { label: '客户反馈', field: 'feedback', alone: true },

          ]}
        />
      </div>
    </div>
  }
)

const organizationMap = {
  0: '个人',
  1: '机构',
}