package com.qf.order.server.impl;

import com.qf.common.base.exception.DaoException;
import com.qf.common.base.result.RespResult;
import com.qf.common.base.result.ResultCode;
import com.qf.order.entity.Order;
import com.qf.order.mapper.UpdatePickupCodeMapper;
import com.qf.order.server.UpdatePickupCodeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Random;

@Service
public class UpdatePickupCodeServerImpl implements UpdatePickupCodeServer {
    @Resource
    private UpdatePickupCodeMapper updatePickupCodeMapper;
    @Transactional
    @Override
    public RespResult updatePickupCode(Long orderid) {
        Order order = updatePickupCodeMapper.queryOrder(orderid);
        if (ObjectUtils.isEmpty(order)){
            throw new DaoException(ResultCode.USER_EXIST);
        }
        if (order.getOrdertype()==0||order.getOrdertype()==1){
        Random random = new Random();
        int code = random.nextInt(9000) + 1000;
        Integer integer = updatePickupCodeMapper.updatePickupCode(orderid, code + "");

            if (integer>0) {
                return RespResult.success("成功");

            }else {
                return RespResult.error(ResultCode.USER_EXIST);
            }

        }else {
            return RespResult.error(ResultCode.USER_EXIST);
        }
    }

}
