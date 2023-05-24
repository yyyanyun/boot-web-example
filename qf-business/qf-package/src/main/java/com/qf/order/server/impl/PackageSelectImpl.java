package com.qf.order.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.common.base.utils.CommonBeanUtils;
import com.qf.order.entity.Recipient;
import com.qf.order.mapper.PackageMapper;
import com.qf.order.server.PackageServer;
import com.qf.order.vo.RecipientVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PackageSelectImpl implements PackageServer {
    @Resource
    private PackageMapper packageMapper;
    @Override
    public PageInfo<RecipientVo> selectRecipient(String nuame, int page, int size, String phone, String orderid, String packageid, String ordertype) {
        PageInfo<Recipient> objectPageInfo = PageHelper.startPage(page, size).doSelectPageInfo(() ->packageMapper.selectPackage(nuame, phone, orderid, packageid, ordertype));
       return CommonBeanUtils.copyPageInfo(objectPageInfo,new PageInfo<>(),RecipientVo::new);
    }



}
