package com.qf.account.controller;

import com.github.pagehelper.PageInfo;
import com.qf.account.common.qo.AccountQO;
import com.qf.account.common.vo.AccountVO;
import com.qf.account.service.AccountService;
import com.qf.common.base.result.RespResult;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/account")
@Api(tags = "财务管理Api接口")
public class AccountController {

    @Resource
    private AccountService accountService;

    @ApiOperation("查询所有账户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPageNo", value = "当前页", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页量", defaultValue = "10"),
            @ApiImplicitParam(name = "id", value = "账户id"),
            @ApiImplicitParam(name = "phone", value = "电话")

    })

    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    @GetMapping("/list")
    public RespResult<PageInfo<AccountVO>> list(@RequestParam(defaultValue = "1") Integer currentPageNo, @RequestParam(defaultValue = "10") Integer pageSize, Long id, String phone) {

        return RespResult.success(accountService.pageInfo(currentPageNo, pageSize, id, phone));

    }


    @PostMapping("/query/list")
    @ApiOperation("查询所有账户信息高级搜索")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPageNo", value = "当前页", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页量", defaultValue = "10"),
            @ApiImplicitParam(name = "accountQO", value = "高级搜索参数"),

    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    public RespResult<PageInfo<AccountVO>> queryList(@RequestParam(defaultValue = "1") Integer currentPageNo, @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody AccountQO accountQO, int paymentStatus) {
        return RespResult.success(accountService.pageInfoList(accountQO, currentPageNo, pageSize, paymentStatus));
    }


    @PutMapping("/update/unlock")
    @ApiOperation("修改状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "账户id", required = true),
            @ApiImplicitParam(name = "status", value = "状态", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "修改成功"),
            @ApiResponse(code = 400, message = "修改失败")
    })
    public RespResult<Integer> updateUnlock(@RequestParam Long id, @RequestParam int status) {
        return RespResult.success(accountService.updateUnlock(id, status));
    }
}
