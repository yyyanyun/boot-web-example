package com.qf.member.server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qf.member.entity.Emp;

import java.util.List;

public interface EmpServer  {

    IPage<Emp> queryList(int page, int size);
}
