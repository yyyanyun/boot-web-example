package com.qf.account.service;

import com.github.pagehelper.PageInfo;
import com.qf.account.common.qo.PaymentRecordQO;
import com.qf.account.common.vo.PaymentRecordVO;

public interface PaymentRecordService {

    //分页模糊查询
    PageInfo<PaymentRecordVO> selectList(Integer currentPageNo, Integer pageSize, PaymentRecordQO paymentRecordQO);


    //分页模糊高级搜索
    PageInfo<PaymentRecordVO> QueryList(Integer currentPageNo, Integer pageSize, PaymentRecordQO paymentRecordQO);
}
