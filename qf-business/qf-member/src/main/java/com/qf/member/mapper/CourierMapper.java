package com.qf.member.mapper;
import com.qf.member.entity.Courier;
import com.qf.member.entity.CourierCertification;
import com.qf.member.vo.CourierVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CourierMapper {
    int insertCourier(@Param("courier")Courier courier);
    int insertCourierCertification(@Param("courierCertification")CourierCertification courierCertification);
    List<CourierVo> selectAllCourier(@Param("courierVo") CourierVo courierVo, @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}