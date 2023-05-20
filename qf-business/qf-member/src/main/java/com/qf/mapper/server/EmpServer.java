package com.qf.mapper.server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qf.mapper.entity.Emp;

public interface EmpServer  {

    IPage<Emp> queryList(int page, int size);
}
