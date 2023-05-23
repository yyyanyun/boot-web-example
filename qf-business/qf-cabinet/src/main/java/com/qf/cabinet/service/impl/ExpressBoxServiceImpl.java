package com.qf.cabinet.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.cabinet.common.utile.MyCommonBeanUtils;
import com.qf.cabinet.entity.ExpressBox;
import com.qf.cabinet.mapper.ExpressBoxMapper;
import com.qf.cabinet.qo.ExpressBoxQo;
import com.qf.cabinet.service.ExpressBoxService;
import com.qf.cabinet.vo.ExpressBoxVo;
import com.qf.common.base.exception.ServiceException;
import com.qf.common.base.result.RespResult;
import com.qf.common.base.result.ResultCode;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class ExpressBoxServiceImpl implements ExpressBoxService {
    @Resource
    private ExpressBoxMapper expressBoxMapper;

    /**
     * 箱格条件查询
     */
    @Override
    public RespResult<PageInfo<ExpressBoxVo>> listBy(int page, int size, ExpressBoxQo expressBoxQo) throws SecurityException {
        ExpressBox expressBox = new ExpressBox();
        BeanUtils.copyProperties(expressBoxQo, expressBox);
        PageInfo<ExpressBox> pageInfo = expressBoxMapper.selectById(expressBox);
        if (!ObjectUtils.isEmpty(pageInfo.getList())) {
            return RespResult.success(MyCommonBeanUtils.copyPageInfo(pageInfo, new PageInfo<>(), ExpressBoxVo::new));
        } else {
            throw new ServiceException(ResultCode.SYS_ERROR);
        }
    }

    @Override
    public RespResult<PageInfo<ExpressBoxVo>> listByLog(int page, int size, int boxId) {
        PageInfo<ExpressBox> pageInfo = PageHelper.startPage(page, size).doSelectPageInfo(() -> expressBoxMapper.selectByBoxId(boxId));
        return RespResult.success(MyCommonBeanUtils.copyPageInfo(pageInfo,new PageInfo<>(),ExpressBoxVo::new));
    }

    /**
     * 修改
     */
    @Override
    public RespResult<Integer> alter(ExpressBoxQo expressBoxQo) {
        ExpressBox expressBox = new ExpressBox();
        BeanUtils.copyProperties(expressBoxQo,expressBox);

        return null;
    }




}
