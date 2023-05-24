package com.qf.order.server;

import com.qf.order.vo.RecipientVo;

public interface QuerydetailsServer {
    RecipientVo selectOrder(long orderid);
}
