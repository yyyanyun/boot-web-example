package com.qf.cabinet.mapper;

import com.qf.cabinet.entity.LogBox;
import com.qf.common.base.exception.DaoException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogBoxMapper {
    List<LogBox> selectByBoxId(@Param("boxId") int boxId) throws DaoException;
}
