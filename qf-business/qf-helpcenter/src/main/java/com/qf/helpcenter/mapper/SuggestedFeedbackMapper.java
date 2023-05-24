package com.qf.helpcenter.mapper;

import com.qf.helpcenter.entity.SuggestedFeedback;
import com.qf.helpcenter.qo.SuggestedFeedbackAddQo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SuggestedFeedbackMapper {
    List<SuggestedFeedback> showProblem();
    List<SuggestedFeedback> searchProblen(@Param("suggestedFeedback") SuggestedFeedback suggestedFeedback);

    Integer addProblem(@Param("suggestedFeedback") SuggestedFeedback suggestedFeedback);
    Integer updateProblem(@Param("type") Integer type,@Param("id")Integer id);

    Integer deleteProblem(@Param("id") Integer id);
}
