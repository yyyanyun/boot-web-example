package com.qf.member.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qf.common.base.result.RespResult;
import com.qf.member.entity.Emp;
import com.qf.member.server.EmpServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/emp")
@Api("查询员工")
public class EmpController {

    @Resource
    EmpServer empServer;

    @GetMapping("list")
    @ApiOperation("查询所有员工")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "page",value = "页码",dataType = "int"),
                    @ApiImplicitParam(name = "size",value = "页量",dataType = "int")
            }
    )

    public RespResult<IPage<Emp>>  list(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10") int size){
        return RespResult.success(empServer.queryList(page,size));
    }
}
