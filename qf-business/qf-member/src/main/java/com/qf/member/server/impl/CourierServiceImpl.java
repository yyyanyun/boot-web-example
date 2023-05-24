package com.qf.member.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.common.base.result.RespResult;
import com.qf.common.base.result.ResultCode;
import com.qf.member.entity.Courier;
import com.qf.member.entity.CourierCertification;
import com.qf.member.mapper.CourierCertificationMapper;
import com.qf.member.mapper.CourierMapper;
import com.qf.member.server.CourierService;
import com.qf.member.vo.CourierVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Date;

@Service
public class CourierServiceImpl implements CourierService {
    @Autowired
    private CourierMapper courierMapper;
@Autowired
private CourierCertificationMapper courierCertificationMapper;
    @Override
    public PageInfo<CourierVo> list01(Integer page, Integer size, CourierVo courierVo, Date startTime, Date endTime) {
        PageInfo<CourierVo> CourierVoPageInfo = PageHelper.startPage(page, size).doSelectPageInfo(() ->
                courierMapper.selectAllCourier(courierVo, startTime, endTime));
        return CourierVoPageInfo;
    }

    @Override
    public CourierCertification list02(Integer memberId) {

        return courierCertificationMapper.selectById(memberId);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RespResult save(Courier courier, CourierCertification courierCertification,String phoneType) {
        if(phoneType.equals(0)){
            courier.setPhone("+86"+courier.getPhone());
        }else {
            courier.setPhone("+63"+courier.getPhone());
        }
        int i = courierMapper.insertCourier(courier);

        if(i>0){
            courierCertification.setMemberId(Long.parseLong(courier.getMemberId()+""));
            int i1 = courierMapper.insertCourierCertification(courierCertification);
            if(i1>0){
                return RespResult.success("添加成功");
            }else {
                return RespResult.error(ResultCode.USER_NO_ADD);
            }
        }else {
           return RespResult.error(ResultCode.USER_NO_ADD);
        }

    }

    @Override
    public RespResult<String> Change(int memberId,int memberStatus) {
        Courier courier = courierMapper.selectById(memberId);
        System.out.println(courierMapper);
        if(!ObjectUtils.isEmpty(courier)){
            int i = courierMapper.updateState(memberId, memberStatus);
            if(i>0){
                return RespResult.success("修改成功");
            }else {
                return RespResult.error(ResultCode.USER_NO_UPDATE);
            }

        }
        return RespResult.error(ResultCode.USER_NO_EXIST);
    }
}
