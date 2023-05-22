package com.qf.account.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.qf.account.common.qo.RechargeRecordQO;
import com.qf.account.common.vo.RechargeRecordVO;

public interface RechargeRecordService {


    //普通分页
    PageInfo<RechargeRecordVO> selectByIdOrPhone(Integer currentPageNO, Integer pageSize, RechargeRecordQO rechargeRecordQO);

    //高级搜索分页

    PageInfo<RechargeRecordVO> queryList(Integer currentPageNO, Integer pageSize, RechargeRecordQO rechargeRecordQO);

    //查询充值详情
    RechargeRecordVO selectById(Long id);
}
