package com.qf.order.server;

import com.qf.common.base.result.RespResult;

public interface UpdatePickupCodeServer {
    RespResult updatePickupCode(Long orderid);
}
