package com.qf.order.mapper;

import com.qf.order.entity.Order;
import org.apache.ibatis.annotations.Param;

public interface UpdatePickupCodeMapper {
    Order queryOrder(@Param("orderid") Long orderid);
    Integer updatePickupCode(@Param("orderid") Long orderid,@Param("pickupCode")String pickupCode);
}
