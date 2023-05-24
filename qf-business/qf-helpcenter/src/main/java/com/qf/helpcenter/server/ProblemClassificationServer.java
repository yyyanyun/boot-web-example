package com.qf.helpcenter.server;

import com.github.pagehelper.PageInfo;
import com.qf.common.base.result.RespResult;
import com.qf.helpcenter.qo.ProblemClassificationTableAddQo;
import com.qf.helpcenter.qo.ProblemClassificationTableQo;
import com.qf.helpcenter.qo.SuggestedFeedbackAddQo;
import com.qf.helpcenter.qo.SuggestedFeedbackQo;
import com.qf.helpcenter.vo.ProblemClassificationTableVo;
import com.qf.helpcenter.vo.SuggestedFeedbackVo;

public interface ProblemClassificationServer {
    PageInfo<ProblemClassificationTableVo> showClassification(Integer page, Integer size);
    PageInfo<ProblemClassificationTableVo> searchClassification(Integer page, Integer size , ProblemClassificationTableQo problemClassificationTableQo);
    RespResult addClassification(ProblemClassificationTableAddQo problemClassificationTableAddQo);

    RespResult updateClassification(Integer id,Integer type);
}
