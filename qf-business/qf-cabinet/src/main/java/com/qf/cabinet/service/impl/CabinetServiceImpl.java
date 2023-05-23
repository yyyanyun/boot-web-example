package com.qf.cabinet.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qf.cabinet.entity.Cabinet;
import com.qf.cabinet.mapper.CabinetMapper;
import com.qf.cabinet.qo.CabinetEasyQo;
import com.qf.cabinet.qo.CabinetHighQo;
import com.qf.cabinet.qo.CabinetQo;
import com.qf.cabinet.service.CabinetService;
import com.qf.cabinet.vo.CabinetVo;
import com.qf.common.base.exception.ServiceException;
import com.qf.common.base.result.RespResult;
import com.qf.common.base.result.ResultCode;
import com.qf.common.base.utils.CommonBeanUtils;
import com.qf.common.db.utils.PageCommonUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.function.Supplier;

@Service
public class CabinetServiceImpl implements CabinetService {
    @Resource
    private CabinetMapper cabinetMapper;

    /**
     * 简单查询
     */
    @Override
    public IPage<CabinetVo> listSimple(int page, int size, CabinetEasyQo cabinetEasyQo, String param) throws ServiceException {
        Cabinet cabinet = new Cabinet();
        BeanUtils.copyProperties(cabinetEasyQo,cabinet);
        return PageCommonUtils.copyPage(cabinetMapper.selectBy(page, size,cabinet, param),new Page<>(),CabinetVo::new);
    }

    /**
     * 高级查询
     */
    @Override
    public IPage<CabinetVo> list(int page, int size, CabinetHighQo cabinetHighQo) throws ServiceException {
        Cabinet cabinet = new Cabinet();
        BeanUtils.copyProperties(cabinetHighQo,cabinet);
        IPage<CabinetVo> cabinetVoIPage = PageCommonUtils.copyPage(cabinetMapper.selectBy(page, size, cabinet), new Page<>(), CabinetVo::new);
        if (ObjectUtils.isEmpty(cabinetVoIPage.getRecords())){
            throw new ServiceException(ResultCode.CABINET_NO_EXISTS);
        }
        return cabinetVoIPage;
    }

    /**
     * 单个添加
     */
    @Override
    public RespResult<Integer> add(CabinetQo cabinetQo) throws ServiceException{
        Cabinet cabinet = new Cabinet();
        BeanUtils.copyProperties(cabinetQo,cabinet);
        int insert = cabinetMapper.insert(cabinet);
        if (insert>0){
            return RespResult.success(insert);
        }else {
            throw new ServiceException(ResultCode.SYS_ERROR);
        }
    }

    /**
     * 批量添加
     */
    @Override
    public RespResult<Integer> listAdd(List<CabinetQo> cabinetQoList) {
        Cabinet cabinet = new Cabinet();
        List<Cabinet> copyList = CommonBeanUtils.copyList(cabinetQoList, (Supplier<Cabinet>) cabinet);
        int count = cabinetMapper.insertList(copyList);
        if (count>0){
            return RespResult.success(count);
        }else {
            throw new ServiceException(ResultCode.SYS_ERROR);
        }
    }

    /**
     * 查询单个
     */
    @Override
    public RespResult<CabinetVo> listOne(int cabinetId) throws ServiceException {
        Cabinet cabinet = cabinetMapper.selectById(cabinetId);
        if (!ObjectUtils.isEmpty(cabinet)) {
            CabinetVo cabinetVo = new CabinetVo();
            BeanUtils.copyProperties(cabinet,cabinetVo);
            return RespResult.success(cabinetVo);
        } else {
            throw new ServiceException(ResultCode.SYS_ERROR);
        }
    }

    /**
     * 修改单个
     */
    @Override
    public RespResult<Integer> alter(int cabinetId, int type) throws ServiceException {
        Cabinet cabinet = new Cabinet();
        cabinet.setCabinetId(Integer.toUnsignedLong(cabinetId));
        cabinet.setCabinetStatus(type);
        return RespResult.success(cabinetMapper.updateById(cabinet));
    }
}
