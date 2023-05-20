package com.qf.mapper.server.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qf.common.db.utils.PageCommonUtils;
import com.qf.mapper.entity.Emp;
import com.qf.mapper.mapper.EmpMapper;
import com.qf.mapper.server.EmpServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class  EmpServerImpl implements EmpServer {

    @Resource
    EmpMapper empMapper;

    @Override
    public IPage<Emp> queryList(int page, int size) {
        Page<Emp> empPage = empMapper.selectPage(new Page<>(page, size), null);
        return  PageCommonUtils.copyPage(empPage, new Page<>(), Emp::new);
    }
}
