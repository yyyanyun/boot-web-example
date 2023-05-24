package com.qf.helpcenter.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.common.base.exception.DaoException;
import com.qf.common.base.result.RespResult;
import com.qf.common.base.result.ResultCode;
import com.qf.common.base.utils.CommonBeanUtils;
import com.qf.helpcenter.entity.ProblemClassificationTable;
import com.qf.helpcenter.mapper.ProblemClassificationTableMapper;
import com.qf.helpcenter.qo.ProblemClassificationTableAddQo;
import com.qf.helpcenter.qo.ProblemClassificationTableQo;
import com.qf.helpcenter.server.ProblemClassificationServer;
import com.qf.helpcenter.vo.ProblemClassificationTableVo;
import com.qf.helpcenter.vo.SuggestedFeedbackVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class ProblemClassificationServerImpl implements ProblemClassificationServer {

    @Resource
    private ProblemClassificationTableMapper problemClassificationTableMapper;
    @Override
    public PageInfo<ProblemClassificationTableVo> showClassification(Integer page, Integer size) {
        PageInfo<SuggestedFeedbackVo> objectPageInfo = PageHelper.startPage(page, size).doSelectPageInfo(() ->problemClassificationTableMapper.showClassification());
        return CommonBeanUtils.copyPageInfo(objectPageInfo,new PageInfo<>(),ProblemClassificationTableVo::new);

    }

    @Override
    public PageInfo<ProblemClassificationTableVo> searchClassification(Integer page, Integer size,  ProblemClassificationTableQo problemClassificationTableQo) {
            ProblemClassificationTable problemClassificationTable=new ProblemClassificationTable();
            BeanUtils.copyProperties(problemClassificationTableQo,problemClassificationTable);
            PageInfo<SuggestedFeedbackVo> objectPageInfo = PageHelper.startPage(page, size).doSelectPageInfo(() ->problemClassificationTableMapper.searchClassification(problemClassificationTable));
            return CommonBeanUtils.copyPageInfo(objectPageInfo,new PageInfo<>(),ProblemClassificationTableVo::new);

    }
    @Transactional
    @Override
    public RespResult addClassification(ProblemClassificationTableAddQo problemClassificationTableAddQo) {
        ProblemClassificationTable problemClassificationTable=new ProblemClassificationTable();
        BeanUtils.copyProperties(problemClassificationTableAddQo,problemClassificationTable);
        if (ObjectUtils.isEmpty(problemClassificationTable)){
            throw new DaoException(ResultCode.SYS_ERROR);
        }else{
            Integer integer = problemClassificationTableMapper.addClassification(problemClassificationTable);
            if (integer>0){
                return RespResult.success("成功");
            }else {
                throw new DaoException(ResultCode.USER_EXIST);
            }
        }
    }
    @Transactional
    @Override
    public RespResult updateClassification(Integer id, Integer type) {
        if (type == 3) {
            Integer integer = problemClassificationTableMapper.selectClassification(id);
            if (integer >0) {
                return RespResult.success("成功");
            }else {
                throw new DaoException(ResultCode.SYS_ERROR);
            }
        }else {
            Integer integer = problemClassificationTableMapper.pudateClassification(id, type);
            if (integer >0) {
                return RespResult.success("成功");
            }else {
                throw new DaoException(ResultCode.SYS_ERROR);
            }

        }
    }
}
