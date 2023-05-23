package com.qf.cabinet.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qf.cabinet.entity.ExpressBox;
import com.qf.cabinet.mapper.ExpressBoxMapper;
import com.qf.cabinet.qo.ExpressBoxQo;
import com.qf.cabinet.service.ExpressBoxService;
import com.qf.cabinet.vo.ExpressBoxVo;
import com.qf.common.base.exception.ServiceException;
import com.qf.common.base.result.RespResult;
import com.qf.common.base.result.ResultCode;
import com.qf.common.db.utils.PageCommonUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class ExpressBoxServiceImpl implements ExpressBoxService {
    @Resource
    private ExpressBoxMapper expressBoxMapper;
    @Override
    public RespResult<IPage<ExpressBoxVo>> listBy(int page, int size, ExpressBoxQo expressBoxQo) throws SecurityException {
        ExpressBox expressBox = new ExpressBox();
        BeanUtils.copyProperties(expressBoxQo,expressBox);
        IPage<ExpressBox> expressBoxIPage = expressBoxMapper.selectById(page, size,expressBox);
        if (!ObjectUtils.isEmpty(expressBoxIPage.getRecords())){
            return RespResult.success(PageCommonUtils.copyPage(expressBoxIPage,new Page<>(),ExpressBoxVo::new));
        }else {
            throw new ServiceException(ResultCode.SYS_ERROR);
        }
    }

}
