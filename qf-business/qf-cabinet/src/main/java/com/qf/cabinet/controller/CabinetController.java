package com.qf.cabinet.controller;

import com.github.pagehelper.PageInfo;
import com.qf.cabinet.qo.CabinetEasyQo;
import com.qf.cabinet.qo.CabinetHighQo;
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
import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CancellationException;

@Api(value = "快递柜机接口")
@RestController
@RequestMapping("/xmh/cabinet")
public class CabinetController {
    @Resource
    private CabinetService cabinetService;

    /**
     * 简单查询
     *
     * @param page:当前页
     * @param size：页量
     * @param cabinetEasyQo：请求参数对象
     * @param param：模糊匹配参数
     * @return ：IPage<CabinetVo>响应对象
     * @throws CancellationException： 控制层异常
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", paramType = "path", dataType = "java.lang.int"),
            @ApiImplicitParam(name = "size", value = "页量", paramType = "path", dataType = "java.lang.int"),
            @ApiImplicitParam(name = "param", value = "详细地址/编码/型号/版本号/ID", paramType = "query"),
    })
    @ApiOperation(value = "list/simple", tags = "简单搜索")
    @PostMapping("/list/simple/{page}/{size}")
    public RespResult<PageInfo<CabinetVo>> listSimple(@PathVariable @RequestParam(defaultValue = "1") int page,
                                                      @PathVariable @RequestParam(defaultValue = "5") int size,
                                                      @RequestBody CabinetEasyQo cabinetEasyQo,
                                                      String param) throws CancellationException {
        return cabinetService.listSimple(page, size, cabinetEasyQo, param);
    }

    /**
     * 高级查询
     *
     * @param page:当前页
     * @param size：页量
     * @param cabinetHighQo：请求参数对象
     * @return ：IPage<CabinetVo>响应对象
     * @throws CancellationException： 控制层异常
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", paramType = "path", dataType = "java.lang.int"),
            @ApiImplicitParam(name = "size", value = "页量", paramType = "path", dataType = "java.lang.int"),
    })
    @ApiOperation(value = "list", tags = "高级搜索")
    @GetMapping("/list/{page}/{size}")
    public RespResult<PageInfo<CabinetVo>> list(@PathVariable @RequestParam(defaultValue = "1") int page,
                                 @PathVariable @RequestParam(defaultValue = "5") int size,
                                 CabinetHighQo cabinetHighQo) throws CancellationException {
        return cabinetService.list(page, size, cabinetHighQo);
    }

    @PostMapping("/add")
    @ApiOperation(value = "add", tags = "添加柜机")
    public RespResult<Integer> add(@RequestBody @Valid CabinetQo cabinetQo) throws ControllerException {
        return cabinetService.add(cabinetQo);
    }


    /**
     * 批量添加
     */
    @PostMapping("/list/add")
    @ApiOperation(value = "listAdd", tags = "批量添加柜机")
    public RespResult<Integer> listAdd(@RequestBody List<CabinetQo> cabinetQoList) throws CancellationException {
        return cabinetService.listAdd(cabinetQoList);
    }

    /**
     * 根据柜机ID查询 柜机详情
     */
    @GetMapping("/list/one")
    @ApiOperation(value = "listOne", tags = "柜机操作弹窗")
    @ApiImplicitParam(name = "cabinetId", value = "柜机ID", required = true)
    public RespResult<CabinetVo> listOne(@RequestParam Integer cabinetId) throws ControllerException {
        return cabinetService.listOne(cabinetId);
    }

    /**
     * 修改柜机状态
     */
    @PutMapping("/alter")
    @ApiOperation(value = "alter", tags = "修改柜机状态")
    @ApiImplicitParams({@ApiImplicitParam(name = "cabinetId", value = "柜机ID", dataType = "java.lang.Integer", required = true),
            @ApiImplicitParam(name = "type", value = "柜机状态", dataType = "java.lang.Integer", required = true)})
    public RespResult<Integer> alter(@RequestParam Integer cabinetId, @RequestParam Integer type) throws ControllerException {
        return cabinetService.alter(cabinetId, type);
    }

    @GetMapping("/show/box")
    @ApiOperation(value = "showBox",tags = "箱格列表")
    @ApiImplicitParam(name = "cabinetId",value = "柜机ID",required = true)
    public RespResult<CabinetVo> showBox(@RequestParam int cabinetId) throws ControllerException {
        return cabinetService.showBox(cabinetId);
    }

    /**
     * 修改箱格界面的信息
     */
    @GetMapping("/alter/go")
    @ApiOperation(nickname = "goAlter",value = "修改箱格界面的信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "cabinetId",value = "修改箱格接口"),
            @ApiImplicitParam(name = "boxId",value = "箱格ID")})
    public RespResult<CabinetVo> goAlter(@RequestParam int cabinetId, @RequestParam int boxId) throws ControllerException{
        return null;
    }


}
