package com.qf.member.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.member.entity.Courier;
import com.qf.member.entity.CourierCertification;
import com.qf.member.vo.CourierVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;
@Mapper
public interface CourierMapper extends BaseMapper<Courier> {
    int insertCourier(@Param("courier")Courier courier);
    int updateState(@Param("memberId") int memberId,@Param("memberStatus") int memberStatus);
    int insertCourierCertification(@Param("courierCertification")CourierCertification courierCertification);
    List<CourierVo> selectAllCourier(@Param("courierVo") CourierVo courierVo, @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}