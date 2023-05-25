package com.qf.member.server;
import com.github.pagehelper.PageInfo;
import com.qf.common.base.result.RespResult;
import com.qf.member.entity.Courier;
import com.qf.member.entity.CourierCertification;
import com.qf.member.vo.CourierVo;
import java.util.Date;
public interface CourierService {
    PageInfo<CourierVo> list01(Integer page, Integer size, CourierVo courierVo, Date startTime, Date endTime);
    CourierCertification list02(Integer MemberId);
    RespResult save(Courier courier, CourierCertification courierCertification,String phoneType);
    RespResult  Change(int memberId,int memberStatus);
}
