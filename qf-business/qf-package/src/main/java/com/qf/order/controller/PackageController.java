package com.qf.order.controller;
import com.github.pagehelper.PageInfo;
import com.qf.common.base.result.RespResult;
import com.qf.order.server.PackageServer;
import com.qf.order.vo.RecipientVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@Api("包裹订单首页接口")
@RequestMapping("/user")

public class PackageController {
    @Autowired
    private PackageServer packageSelect;
    @ApiOperation("根据收货人信息或者包裹信息进行筛选查询")

    @GetMapping("/list")
    public RespResult<PageInfo<RecipientVo>> list(String uname, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size, String phone, String orderid, String packageid, String ordertype) {
//        List<Recipient> list = packageSelect.selectRecipient(uname,page,size);
//        return list;
        return RespResult.success(packageSelect.selectRecipient(uname, page, size, phone, orderid, packageid, ordertype));

    }
}
