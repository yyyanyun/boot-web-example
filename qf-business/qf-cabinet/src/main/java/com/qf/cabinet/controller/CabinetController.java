package com.qf.cabinet.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qf.cabinet.qo.CabinetQo;
import com.qf.cabinet.service.CabinetService;
import com.qf.cabinet.vo.CabinetVo;
import com.qf.common.base.exception.ControllerException;
import com.qf.common.base.result.RespResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.CancellationException;

@Api("快递柜机接口")
@RestController
@RequestMapping("/xmh/Cabinet")
public class CabinetController {
    @Resource
    private CabinetService cabinetService;

    /**
     * 简单查询
     *
     * @param page:当前页
     * @param size：页量
     * @param cabinetQo：请求参数对象
     * @param param：模糊匹配参数
     * @return ：IPage<CabinetVo>响应对象
     * @throws CancellationException： 控制层异常
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", paramType = "path", dataType = "java.lang.int"),
            @ApiImplicitParam(name = "size", value = "页量", paramType = "path",dataType = "java.lang.int"),
            @ApiImplicitParam(name = "cabinetQo", value = "简单请求参数对象", paramType = "query"),
            @ApiImplicitParam(name = "param", value = "详细地址/编码/型号/版本号/ID", paramType = "query"),
    })
    @ApiOperation(value = "listSimple", tags = "简单搜索")
    @PostMapping("/listSimple/{page}/{size}")
    public IPage<CabinetVo> listSimple(@PathVariable @RequestParam(defaultValue = "1") int page,
                                       @PathVariable @RequestParam(defaultValue = "5") int size,
                                       @RequestBody CabinetQo cabinetQo,
                                       String param) throws CancellationException {
        return cabinetService.listSimple(page, size, cabinetQo, param);
    }

    /**
     * 高级查询
     *
     * @param page:当前页
     * @param size：页量
     * @param cabinetsQo：请求参数对象
     * @return ：IPage<CabinetVo>响应对象
     * @throws CancellationException： 控制层异常
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", paramType = "path", dataType = "java.lang.int"),
            @ApiImplicitParam(name = "size", value = "页量", paramType = "path", dataType = "java.lang.int"),
    })
    @ApiOperation(value = "list", tags = "高级搜索")
    @PostMapping("/list/{page}/{size}")
    public IPage<CabinetVo> list(@PathVariable @RequestParam(defaultValue = "1") int page,
                                 @PathVariable @RequestParam(defaultValue = "5") int size,
                                 CabinetQo cabinetQo) throws CancellationException {
        System.out.println(page+size);
        return cabinetService.list(page, size, cabinetQo);
    }

    public RespResult<Integer> add(@RequestBody ) throws ControllerException {

return null;
    }


}
