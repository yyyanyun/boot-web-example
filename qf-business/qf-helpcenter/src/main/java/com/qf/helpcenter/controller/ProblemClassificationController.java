package com.qf.helpcenter.controller;

import com.github.pagehelper.PageInfo;
import com.qf.common.base.result.RespResult;
import com.qf.helpcenter.qo.ProblemClassificationTableAddQo;
import com.qf.helpcenter.qo.ProblemClassificationTableQo;
import com.qf.helpcenter.server.ProblemClassificationServer;
import com.qf.helpcenter.vo.ProblemClassificationTableVo;
import com.qf.helpcenter.vo.SuggestedFeedbackVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/queryclass")
@RestController
public class ProblemClassificationController {

    @Resource
    private ProblemClassificationServer problemClassificationServer;
    @ApiOperation("查看问题分类")
    @GetMapping("/listp")
    public RespResult<PageInfo<ProblemClassificationTableVo>> showProblem(@RequestParam(defaultValue = "1") Integer page , @RequestParam(defaultValue = "10")Integer size){
        return RespResult.success(problemClassificationServer.showClassification(page, size));
    }
    @ApiOperation("高级搜索")
    @PostMapping("/lists")
    public  RespResult<PageInfo<ProblemClassificationTableVo>>searchClassification(@RequestParam(defaultValue = "1") Integer page , @RequestParam(defaultValue = "10")Integer size,@RequestBody ProblemClassificationTableQo problemClassificationTableQo){
        return RespResult.success(problemClassificationServer.searchClassification(page, size, problemClassificationTableQo));
    }
    @ApiOperation("添加分类")
    @PostMapping("/add")
    public RespResult addClassification(ProblemClassificationTableAddQo problemClassificationTableAddQo){
        return problemClassificationServer.addClassification(problemClassificationTableAddQo);

    }
    @ApiOperation("更改状态")
    @PostMapping("/updateClassification")
    public  RespResult updateClassification(@RequestParam Integer id,@RequestParam Integer type){
        return problemClassificationServer.updateClassification(id, type);
    }
}
