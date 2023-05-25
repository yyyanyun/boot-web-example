package com.qf.cabinet.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.cabinet.common.utile.MyCommonBeanUtils;
import com.qf.cabinet.entity.Cabinet;
import com.qf.cabinet.mapper.CabinetMapper;
import com.qf.cabinet.mapper.ExpressBoxMapper;
import com.qf.cabinet.qo.CabinetEasyQo;
import com.qf.cabinet.qo.CabinetHighQo;
import com.qf.cabinet.qo.CabinetQo;
import com.qf.cabinet.service.CabinetService;
import com.qf.cabinet.vo.CabinetVo;
import com.qf.common.base.exception.ServiceException;
import com.qf.common.base.result.ResultCode;
import com.qf.common.base.utils.CommonBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CabinetServiceImpl implements CabinetService {
    @Resource
    private CabinetMapper cabinetMapper;
    @Resource
    private ExpressBoxMapper expressBoxMapper;


    /**
     * 箱格使用统计
     */
    public void countBox(PageInfo<Cabinet> pageInfo){
        pageInfo.getList().forEach(box->{
            Long count = expressBoxMapper.count(box.getCabinetId());
            Long aLong = expressBoxMapper.countByCid(box.getCabinetId());
            box.setBox(count+"/"+aLong);
        });
    }

    /**
     * 简单查询
     */
    public PageInfo<CabinetVo> listSimple(int page, int size, CabinetEasyQo cabinetEasyQo, String param) throws ServiceException{
        Cabinet cabinet = new Cabinet();
        BeanUtils.copyProperties(cabinetEasyQo,cabinet);
        PageInfo<Cabinet> pageInfo = PageHelper.startPage(page, size).doSelectPageInfo(() ->cabinetMapper.selectBy(cabinet, param));
        if (!ObjectUtils.isEmpty(pageInfo.getList())){
            countBox(pageInfo);
            return MyCommonBeanUtils.copyPageInfo(pageInfo,new PageInfo<>(),CabinetVo::new);
        }else {
            throw new ServiceException(ResultCode.SYS_ERROR);
        }
    }

    /**
     * 高级查询
     */
    @Override
    public PageInfo<CabinetVo> list(int page, int size, CabinetHighQo cabinetHighQo) throws ServiceException {
        Cabinet cabinet = new Cabinet();
        BeanUtils.copyProperties(cabinetHighQo,cabinet);
        PageInfo<Cabinet> pageInfo = PageHelper.startPage(page, size).doSelectPageInfo(() -> cabinetMapper.selectBys(cabinet));
        if (!ObjectUtils.isEmpty(pageInfo.getList())){
            countBox(pageInfo);
            return MyCommonBeanUtils.copyPageInfo(pageInfo,new PageInfo<>(),CabinetVo::new);
        }else {
            throw new ServiceException(ResultCode.SYS_ERROR);
        }
    }

    /**
     * 单个添加
     */
    @Override
    public Integer add(CabinetQo cabinetQo) throws ServiceException{
        Cabinet cabinet = new Cabinet();
        BeanUtils.copyProperties(cabinetQo,cabinet);
        if (ObjectUtils.isEmpty(cabinetMapper.selectExists(cabinet))){
            int insert = cabinetMapper.insert(cabinet);
            if (insert>0){
                return insert;
            }else {
                throw new ServiceException(ResultCode.SYS_ERROR);
            }
        }else {
            throw new ServiceException(ResultCode.USER_EXIST);
        }

    }

    /**
     * 批量添加
     */
    @Override
    public Integer listAdd(List<CabinetQo> cabinetQoList) throws ServiceException {
        List<Cabinet> copyList = CommonBeanUtils.copyList(cabinetQoList,Cabinet::new);
        copyList.forEach(iter->{
            if (!ObjectUtils.isEmpty(cabinetMapper.selectExists(iter))){
                throw new ServiceException(ResultCode.USER_EXIST);
            }
        });
        Integer count = cabinetMapper.insertList(copyList);
        if (count>0){
            return count;
        }else {
            throw new ServiceException(ResultCode.SYS_ERROR);
        }
    }

    /**
     * 查询柜机详情
     */
    @Override
    public CabinetVo listOne(int cabinetId) throws ServiceException {
        Cabinet cabinet = cabinetMapper.query(cabinetId);
        if (!ObjectUtils.isEmpty(cabinet)) {
            CabinetVo cabinetVo = new CabinetVo();
            BeanUtils.copyProperties(cabinet,cabinetVo);
            return cabinetVo;
        } else {
            throw new ServiceException(ResultCode.SYS_ERROR);
        }
    }

    /**
     * 修改单个
     */
    @Override
    public Integer alter(int cabinetId, int type) throws ServiceException {
        Cabinet cabinet = new Cabinet();
        cabinet.setCabinetId(Integer.toUnsignedLong(cabinetId));
        cabinet.setCabinetStatus(type);
        return cabinetMapper.updateById(cabinet);
    }

    /**
     * 箱格列表
     */
    @Override
    public CabinetVo showBox(int cabinetId) throws ServiceException{
        Cabinet cabinet = cabinetMapper.selectByCabinetId(cabinetId);
        if (!ObjectUtils.isEmpty(cabinet)){
            CabinetVo cabinetVo = new CabinetVo();
            BeanUtils.copyProperties(cabinet,cabinetVo);
            return cabinetVo;
        }else {
            throw new ServiceException(ResultCode.SYS_ERROR);
        }

    }

    @Override
    public CabinetVo goAlter(int cabinetId, int boxId) throws ServiceException {
        Cabinet cabinet = cabinetMapper.selectGo(cabinetId, boxId);
        if (!ObjectUtils.isEmpty(cabinet)){
            CabinetVo cabinetVo = new CabinetVo();
            BeanUtils.copyProperties(cabinet,cabinetVo);
            return cabinetVo;
        }else {
            throw new ServiceException(ResultCode.SYS_ERROR);
        }

    }

}
