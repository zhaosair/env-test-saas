import React, { useState, useEffect } from 'react';
import ZEle from 'zero-element';
import { useDidMount, useWillUnmount, useForceUpdate } from 'zero-element/lib/utils/hooks/lifeCycle';
import { formatTableFields } from 'zero-element-antd/lib/container/List/utils/format';
import { getActionItem } from 'zero-element-antd/lib/utils/readConfig';
import { Table } from 'antd';
import { Render } from 'zero-element/lib/config/layout';

import useListHandle from 'zero-element-antd/lib/container/List/utils/useListHandle';
import Flex from '@/../zero-antd-dep/layout/Flex';

// import Tree from 'zero-element-antd/lib/components/Tree';
import Tree from '@/components/TList/Tree';

const { FlexItem } = Flex;

/**
 * 左边是一个树状选择，右边是 Table
 */
export default function DataReportTreeList(props) {
  const { namespace, config } = props;
  const {
    layout = 'Empty', layoutConfig = {},
    API = {},
    fields, operation, actions = [],
    props: propsCfg = {},
    actionLayout = 'Row',
    actionLayoutConfig = {},
    field = 'children',
    tree = {},
  } = config;

  const { API: treeAPI, searchField = 'search' } = tree;

  const [extraData, setExtraData] = useState({});

  const [
    tableProps, tableData, handle, actionsItems,
  ] = useListHandle({
    namespace,
    extraData,
    config,

    props,
  });

  const { onGetList, onClearList } = handle;

  useDidMount(_ => {
    if (API.listAPI) {
      if (API.listAPI.indexOf('<') === -1) {
        onGetList({});
      }
    }
  });
  useEffect(_ => {
    if (extraData.id) {
      onGetList({});
      onClearList(); //刷新组件
    }
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [extraData]);
  // useWillUnmount(onClearList);

  function handleSelect(data) {
    setExtraData(data);
  }

  return <Render n={layout} {...layoutConfig}>
    <Render n={actionLayout} {...actionLayoutConfig}>
      {actionsItems}
    </Render>
    <Flex align="flex-start">
      {treeAPI ? (<FlexItem>
        <br />
        <Tree
          API={treeAPI}
          searchField={searchField}
          namespace={namespace}
          onChange={handleSelect}
        />
      </FlexItem>) : null}
      <FlexItem flex={1}>
        {/* <Table
          rowKey="id"
          dataSource={props.data || tableData}
          childrenColumnName={field}
          {...tableProps}
          {...propsCfg}
        /> */}
        {props.data || tableData ? (
          <ZEle namespace={`datareport_${tableData.title}`} config={props.data || tableData} />
        ):<></>}
      </FlexItem>
    </Flex>
  </Render>
}