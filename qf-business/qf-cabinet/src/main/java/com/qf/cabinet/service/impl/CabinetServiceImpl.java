package com.qf.cabinet.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qf.cabinet.entity.Cabinet;
import com.qf.cabinet.mapper.CabinetMapper;
import com.qf.cabinet.qo.CabinetQo;
import com.qf.cabinet.service.CabinetService;
import com.qf.cabinet.vo.CabinetVo;
import com.qf.common.base.exception.ServiceException;
import com.qf.common.base.result.ResultCode;
import com.qf.common.db.utils.PageCommonUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class CabinetServiceImpl implements CabinetService {
    @Resource
    private CabinetMapper cabinetMapper;
    @Override
    public IPage<CabinetVo> listSimple(int page,int size, CabinetQo cabinetQo,String param) throws ServiceException {
        Cabinet cabinet = new Cabinet();
        BeanUtils.copyProperties(cabinetQo,cabinet);
        return PageCommonUtils.copyPage(cabinetMapper.selectBy(page, size,cabinet, param),new Page<>(),CabinetVo::new);
    }

    @Override
    public IPage<CabinetVo> list(int page, int size, CabinetQo cabinetQo) throws ServiceException {
        Cabinet cabinet = new Cabinet();
        BeanUtils.copyProperties(cabinetQo,cabinet);
        IPage<CabinetVo> cabinetVoIPage = PageCommonUtils.copyPage(cabinetMapper.selectBy(page, size, cabinet), new Page<>(), CabinetVo::new);
        if (ObjectUtils.isEmpty(cabinetVoIPage.getRecords())){
            throw new ServiceException(ResultCode.CABINET_NO_EXISTS);
        }
        return cabinetVoIPage;
    }
}
