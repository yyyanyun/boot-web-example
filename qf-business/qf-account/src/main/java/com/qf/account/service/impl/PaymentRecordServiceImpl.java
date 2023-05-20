package com.qf.account.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.account.common.qo.PaymentRecordQO;
import com.qf.account.common.utils.PageInfoUtils;
import com.qf.account.common.vo.PaymentRecordVO;
import com.qf.account.entity.PaymentRecord;
import com.qf.account.mapper.PaymentRecordMapper;
import com.qf.account.service.PaymentRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentRecordServiceImpl implements PaymentRecordService {

    @Resource
    private PaymentRecordMapper paymentRecordMapper;

    @Override
    public PageInfo<PaymentRecordVO> selectList(Integer currentPageNo, Integer pageSize, PaymentRecordQO paymentRecordQO) {
        PaymentRecord paymentRecord = new PaymentRecord();

        BeanUtils.copyProperties(paymentRecordQO, paymentRecord);

        PageInfo<PaymentRecordVO> pageInfo = PageHelper.startPage(currentPageNo, pageSize).doSelectPageInfo(() -> paymentRecordMapper.selectByPhoneOrTradeNoOrOrderNo(paymentRecord));

        return PageInfoUtils.copyPage(pageInfo, new PageInfo<>(), PaymentRecordVO::new);
    }

    @Override
    public PageInfo<PaymentRecordVO> QueryList(Integer currentPageNo, Integer pageSize, PaymentRecordQO paymentRecordQO) {

        PaymentRecord paymentRecord = new PaymentRecord();
        BeanUtils.copyProperties(paymentRecordQO, paymentRecord);

        PageInfo<PaymentRecordVO> selectPageInfoList = PageHelper.startPage(currentPageNo, pageSize).doSelectPageInfo(() -> paymentRecordMapper.selectList(paymentRecord));

        return PageInfoUtils.copyPage(selectPageInfoList, new PageInfo<>(), PaymentRecordVO::new);
    }
}
