package com.qf.helpcenter.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.common.base.exception.DaoException;
import com.qf.common.base.result.RespResult;
import com.qf.common.base.result.ResultCode;
import com.qf.common.base.utils.CommonBeanUtils;
import com.qf.helpcenter.entity.SuggestedFeedback;
import com.qf.helpcenter.mapper.SuggestedFeedbackMapper;
import com.qf.helpcenter.qo.SuggestedFeedbackAddQo;
import com.qf.helpcenter.qo.SuggestedFeedbackQo;
import com.qf.helpcenter.server.SuggestedFeedbackServer;
import com.qf.helpcenter.vo.SuggestedFeedbackVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class SuggestedFeedbackServerImpl implements SuggestedFeedbackServer {
    @Resource
    private SuggestedFeedbackMapper suggestedFeedbackMapper;
    @Override
    public PageInfo<SuggestedFeedbackVo> showProblem(Integer page, Integer size) {
        PageInfo<SuggestedFeedbackVo> objectPageInfo = PageHelper.startPage(page, size).doSelectPageInfo(() ->suggestedFeedbackMapper.showProblem());
        return CommonBeanUtils.copyPageInfo(objectPageInfo,new PageInfo<>(),SuggestedFeedbackVo::new);
    }

    @Override
    public PageInfo<SuggestedFeedbackVo> searchProblen(Integer page, Integer size, SuggestedFeedbackQo suggestedFeedbackQo) {
        SuggestedFeedback suggestedFeedback=new SuggestedFeedback();
        BeanUtils.copyProperties(suggestedFeedbackQo,suggestedFeedback);
        PageInfo<SuggestedFeedbackVo> objectPageInfo = PageHelper.startPage(page, size).doSelectPageInfo(() ->suggestedFeedbackMapper.searchProblen(suggestedFeedback));
        return CommonBeanUtils.copyPageInfo(objectPageInfo,new PageInfo<>(),SuggestedFeedbackVo::new);

    }

    @Override
    public RespResult addProblem(SuggestedFeedbackAddQo suggestedFeedbackAddQo) {
        SuggestedFeedback suggestedFeedback=new SuggestedFeedback();
        BeanUtils.copyProperties(suggestedFeedbackAddQo,suggestedFeedback);
        if (ObjectUtils.isEmpty(suggestedFeedback)){
            throw new DaoException(ResultCode.SYS_ERROR);
        }else{
            Integer integer = suggestedFeedbackMapper.addProblem(suggestedFeedback);
            if (integer>0){
                return RespResult.success("成功");
            }else {
                throw new DaoException(ResultCode.USER_EXIST);
            }
        }
    }

    @Override
    public RespResult updateProblem(Integer id, Integer tpye) {
        if (tpye == 3) {
            Integer integer = suggestedFeedbackMapper.deleteProblem(id);
            if (integer>0) {
                return RespResult.success("成功");
            }else {
               throw  new DaoException(ResultCode.SYS_ERROR);
            }
        }

        Integer integer = suggestedFeedbackMapper.updateProblem(tpye, id);
        if (integer>0){
            return RespResult.success("成功");
        }else {
            throw new DaoException(ResultCode.SYS_ERROR);
        }
    }


}
