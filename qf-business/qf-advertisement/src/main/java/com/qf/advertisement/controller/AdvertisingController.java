package com.qf.advertisement.controller;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qf.advertisement.server.AdvertisingServer;
import com.qf.advertisement.qo.AdvertisingQo;
import com.qf.advertisement.vo.AdvertisingVo;
import com.qf.common.base.result.RespResult;
import com.qf.common.base.result.ResultCode;
import io.swagger.annotations.*;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Resource
@RestController
@Api("广告的操作")
public class AdvertisingController {

    @Resource
    AdvertisingServer  advertisingServer;


    /**
     * DateTimeFormat  和  JsonFormat  主键的 区别
     * 同： 都是 对 时间类型属性在不同场景下的 格式化 序列化 和 反序列化格式的注解
     * 异： DateTimeFormat 是 处理前端 请求 数据   如果 后端将前端的请求封装成一个对象 在对象类中的时间类型上加上 DateTimeFormat注解 并 声明要转换的格式
     *     JsonFormat  是 处理 后端返回的时间类数据
     *
     * @param page   页码
     * @param size   页量
     * @param advertisingQo  前端请求的对象
     * @return  返回响应集
     */
    @ApiOperation("查询智能柜分屏广告信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "当前页码",defaultValue = "1",dataType = "Integer"),
            @ApiImplicitParam(name = "size",value = "每一页页量",defaultValue = "10",dataType = "10")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功"),
            @ApiResponse(code = 400, message = "没有此方法"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("list")
    public RespResult<IPage<AdvertisingVo>>  list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, @ModelAttribute  AdvertisingQo advertisingQo){
        return  RespResult.success(advertisingServer.queryList(page,size,advertisingQo));
    }

    /**
     * 插入广告数据
     * @param advertisingQo
     * @return
     */
    @PostMapping("insert")
    public RespResult<Object>  insertAdvertising(@ModelAttribute  AdvertisingQo advertisingQo) {
         return advertisingServer.addAdvertising(advertisingQo)>0? RespResult.success("提交成功"): RespResult.error(ResultCode.SYS_ERROR);
    }

    /**
     *  根据 id 查询 出  详细  信息
     * @param advertisingId
     * @return
     */
    @GetMapping("query")
    public RespResult<Object>   query(@RequestParam("id")Long advertisingId){
        AdvertisingVo advertisingVo = advertisingServer.queryAdvertising(advertisingId);
        return !ObjectUtils.isEmpty(advertisingVo)? RespResult.success(advertisingVo):RespResult.error(ResultCode.SYS_ERROR);
    }


    /**
     *  修改 广告信息 比如  更改视频  (先查询,才能修改，所以传输的对象有ID, 和 修改的信息)
     * @param advertisingQo
     * @return
     */
    @PostMapping("/update")
   public RespResult<Object>  mod(@ModelAttribute AdvertisingQo advertisingQo){
        return advertisingServer.update(advertisingQo);
   }





}
