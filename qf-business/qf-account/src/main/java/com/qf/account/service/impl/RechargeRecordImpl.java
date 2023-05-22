package com.qf.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.account.common.qo.RechargeRecordQO;
import com.qf.account.common.utils.PageInfoUtils;
import com.qf.account.common.vo.RechargeRecordVO;
import com.qf.account.entity.RechargeRecord;
import com.qf.account.mapper.RechargeRecordMapper;
import com.qf.account.service.RechargeRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RechargeRecordImpl implements RechargeRecordService {

    @Resource
    private RechargeRecordMapper rechargeRecordMapper;


    @Override
    public PageInfo<RechargeRecordVO> selectByIdOrPhone(Integer currentPageNO, Integer pageSize, RechargeRecordQO rechargeRecordQO) {

        RechargeRecord rechargeRecord = new RechargeRecord();
        BeanUtils.copyProperties(rechargeRecordQO, rechargeRecord);

        PageInfo<RechargeRecord> pageInfo = PageHelper.startPage(currentPageNO, pageSize).doSelectPageInfo(() -> rechargeRecordMapper.selectByAccountIdORMobile(rechargeRecord));

        return PageInfoUtils.copyPage(pageInfo, new PageInfo<>(), RechargeRecordVO::new);
    }

    @Override
    public PageInfo<RechargeRecordVO> queryList(Integer currentPageNO, Integer pageSize, RechargeRecordQO rechargeRecordQO) {

        RechargeRecord rechargeRecord = new RechargeRecord();

        BeanUtils.copyProperties(rechargeRecordQO, rechargeRecord);


        PageInfo<RechargeRecordVO> pageInfo = PageHelper.startPage(currentPageNO, pageSize).doSelectPageInfo(() -> rechargeRecordMapper.selectList(rechargeRecord));

        return PageInfoUtils.copyPage(pageInfo,new PageInfo<>(),RechargeRecordVO::new);
    }
}
