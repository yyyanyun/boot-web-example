package com.qf.member.server.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qf.common.db.utils.PageCommonUtils;
import com.qf.member.entity.Emp;
import com.qf.member.mapper.EmpMapper;
import com.qf.member.server.EmpServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
