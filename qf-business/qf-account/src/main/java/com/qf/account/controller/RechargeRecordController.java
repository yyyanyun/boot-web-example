package com.qf.account.controller;

import com.github.pagehelper.PageInfo;
import com.qf.account.common.qo.RechargeRecordQO;
import com.qf.account.common.vo.RechargeRecordVO;
import com.qf.account.mapper.RechargeRecordMapper;
import com.qf.account.service.RechargeRecordService;
import com.qf.common.base.result.RespResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/RechargeRecord")
@Api(tags = "充值信息管理Api接口")
public class RechargeRecordController {

    @Resource
    private RechargeRecordService rechargeRecordService;

    @PostMapping("/list")
    @ApiOperation("普通模糊分页查询")
    public RespResult<PageInfo<RechargeRecordVO>> listRespResult(@RequestParam(defaultValue = "1") Integer currentPageNo, @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody RechargeRecordQO rechargeRecordQO) {

        return RespResult.success(rechargeRecordService.selectByIdOrPhone(currentPageNo, pageSize, rechargeRecordQO));

    }


    @PostMapping("/query/list")
    @ApiOperation("高级搜索模糊分页查询")
    public RespResult<PageInfo<RechargeRecordVO>> queryList(@RequestParam(defaultValue = "1") Integer currentPageNo, @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody RechargeRecordQO rechargeRecordQO) {

        return RespResult.success(rechargeRecordService.queryList(currentPageNo, pageSize, rechargeRecordQO));

    }
}
