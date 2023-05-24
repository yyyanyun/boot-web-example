package com.qf.order.mapper;

import com.qf.order.entity.Recipient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PackageMapper {
    List<Recipient>selectPackage( @Param("uname") String uname,@Param("phone") String phone,@Param("orderid") String orderid,@Param("packageid") String packageid,@Param("ordertype") String ordertype);

}
