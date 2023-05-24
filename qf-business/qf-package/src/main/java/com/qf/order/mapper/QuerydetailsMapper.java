package com.qf.order.mapper;

import com.qf.order.entity.Recipient;
import org.apache.ibatis.annotations.Param;

public interface QuerydetailsMapper {
    Recipient selectOrder(@Param("orderid") long orderid);
}
