package com.qf.order.server.impl;

import com.qf.common.base.exception.DaoException;
import com.qf.common.base.result.ResultCode;
import com.qf.order.entity.Recipient;
import com.qf.order.mapper.QuerydetailsMapper;
import com.qf.order.server.QuerydetailsServer;
import com.qf.order.vo.RecipientVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
@Service
public class QuerydetailsServerImpl implements QuerydetailsServer {
    @Autowired
    private QuerydetailsMapper querydetailsMapper;
        @Transactional
        @Override
        public RecipientVo selectOrder(long orderid) {
            Recipient recipient = querydetailsMapper.selectOrder(orderid);
            if (ObjectUtils.isEmpty(recipient)) {
                throw new DaoException(ResultCode.SYS_ERROR);
            }
            RecipientVo recipientVo=new RecipientVo();

            BeanUtils.copyProperties(recipient,recipientVo);

            return recipientVo;
        }



}
