package com.qf.account.controller;

import com.github.pagehelper.PageInfo;
import com.qf.account.common.qo.RechargeRecordQO;
import com.qf.account.common.vo.RechargeRecordVO;
import com.qf.account.mapper.RechargeRecordMapper;
import com.qf.account.service.RechargeRecordService;
import com.qf.common.base.result.RespResult;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/rechargeRecord")
@Api(tags = "充值信息管理Api接口")
public class RechargeRecordController {

    @Resource
    private RechargeRecordService rechargeRecordService;

    @PostMapping("/list")
    @ApiOperation("充值记录普通模糊分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPageNo", value = "当前页", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页量", defaultValue = "10"),
            @ApiImplicitParam(name = "rechargeRecordQO", value = "请求对象参数"),

    })

    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    public RespResult<PageInfo<RechargeRecordVO>> listRespResult(@RequestParam(defaultValue = "1") Integer currentPageNo, @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody RechargeRecordQO rechargeRecordQO) {

        return RespResult.success(rechargeRecordService.selectByIdOrPhone(currentPageNo, pageSize, rechargeRecordQO));

    }


    @PostMapping("/query/list")
    @ApiOperation("充值记录高级搜索模糊分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPageNo", value = "当前页", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页量", defaultValue = "10"),
            @ApiImplicitParam(name = "rechargeRecordQO", value = "请求对象参数"),

    })

    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    public RespResult<PageInfo<RechargeRecordVO>> queryList(@RequestParam(defaultValue = "1") Integer currentPageNo, @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody RechargeRecordQO rechargeRecordQO) {

        return RespResult.success(rechargeRecordService.queryList(currentPageNo, pageSize, rechargeRecordQO));

    }


    @GetMapping("/id")
    @ApiOperation("查询充值记录详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "充值记录交易号id", defaultValue = "1", required = true),
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    public RespResult<RechargeRecordVO> result(@RequestParam Long id) {
        return RespResult.success(rechargeRecordService.selectById(id));
    }


}
