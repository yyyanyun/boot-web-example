package com.qf.helpcenter.mapper;

import com.qf.helpcenter.entity.ProblemClassificationTable;
import com.qf.helpcenter.entity.SuggestedFeedback;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProblemClassificationTableMapper {
    List<ProblemClassificationTable> showClassification();
    List<ProblemClassificationTable> searchClassification(@Param("problemClassificationTable") ProblemClassificationTable problemClassificationTable);
    Integer addClassification(@Param("problemClassificationTable") ProblemClassificationTable problemClassificationTable);
    Integer pudateClassification(@Param("id")Integer id,@Param("type") Integer type);
    Integer selectClassification(@Param("id") Integer id);
}
