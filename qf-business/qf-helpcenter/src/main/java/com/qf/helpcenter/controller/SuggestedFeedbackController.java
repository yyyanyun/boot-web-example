package com.qf.helpcenter.controller;
import com.github.pagehelper.PageInfo;
import com.qf.common.base.result.RespResult;
import com.qf.helpcenter.qo.SuggestedFeedbackAddQo;
import com.qf.helpcenter.qo.SuggestedFeedbackQo;
import com.qf.helpcenter.server.SuggestedFeedbackServer;
import com.qf.helpcenter.vo.SuggestedFeedbackVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
@RequestMapping("/query")
@RestController
public class SuggestedFeedbackController {
    @Resource
    private SuggestedFeedbackServer suggestedFeedbackServer;
    @ApiOperation("查询问题列表")
    @PostMapping ("/list")
    public RespResult<PageInfo<SuggestedFeedbackVo>> showProblem(@RequestParam(defaultValue = "1") Integer page , @RequestParam(defaultValue = "10")Integer size){
         return RespResult.success( suggestedFeedbackServer.showProblem(page, size));
    }
    @ApiOperation("模糊查询和高级搜索")
    @PostMapping ("/lists")
    public RespResult<PageInfo<SuggestedFeedbackVo>> searchProblen( SuggestedFeedbackQo suggestedFeedbackQo,@RequestParam(defaultValue = "1") Integer page , @RequestParam(defaultValue = "10")Integer size){
        return RespResult.success( suggestedFeedbackServer.searchProblen(page,size,suggestedFeedbackQo));
    }
    @ApiOperation("添加问题")
    @PostMapping ("/addproblem")
    public RespResult addProblen(SuggestedFeedbackAddQo suggestedFeedbackAddQo){
        return suggestedFeedbackServer.addProblem(suggestedFeedbackAddQo);
    }

    @ApiOperation("更改状态")
    @PostMapping ("/updateproblem")
    public RespResult updateProblen(@RequestParam Integer id,@RequestParam Integer type){
        return suggestedFeedbackServer.updateProblem(id,type);
    }


}
