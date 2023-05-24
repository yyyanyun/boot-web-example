package com.qf.helpcenter.server;

import com.github.pagehelper.PageInfo;
import com.qf.common.base.result.RespResult;
import com.qf.helpcenter.entity.SuggestedFeedback;
import com.qf.helpcenter.qo.SuggestedFeedbackAddQo;
import com.qf.helpcenter.qo.SuggestedFeedbackQo;
import com.qf.helpcenter.vo.SuggestedFeedbackVo;

public interface SuggestedFeedbackServer {
    PageInfo<SuggestedFeedbackVo> showProblem(Integer page,Integer size);

    PageInfo<SuggestedFeedbackVo> searchProblen(Integer page, Integer size , SuggestedFeedbackQo suggestedFeedbackQo);

    RespResult addProblem(SuggestedFeedbackAddQo suggestedFeedbackAddQo);
    RespResult updateProblem(Integer id, Integer tpye);


}
