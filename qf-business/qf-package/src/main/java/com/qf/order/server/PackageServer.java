package com.qf.order.server;

import com.github.pagehelper.PageInfo;
import com.qf.order.vo.RecipientVo;

public interface PackageServer {
    PageInfo<RecipientVo> selectRecipient(String nuame, int page, int size, String phone, String orderid, String packageid, String ordertype);

}
