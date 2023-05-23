package com.qf.cabinet.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.PageInfo;
import com.qf.cabinet.entity.Cabinet;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CabinetMapper extends BaseMapper<Cabinet> {
    /**
     * 查询柜机编号
     */
    Cabinet selectExists(@Param("cabinet") Cabinet cabinet);

    /**
     * 柜机箱格列表
     */
    Cabinet selectByCabinetId(@Param("cabinetId") int cabinetId);

    /**
     * 批量添加
     */
    Integer insertList(@Param("cabinetList") List<Cabinet> cabinetList);

    /**
     * 简单条件查询
     */
    PageInfo<Cabinet> selectBy(@Param("cabinet") Cabinet cabinet,@Param("param")  String param);

    /**
     * 高级条件查询
     */
    PageInfo<Cabinet> selectBys(@Param("cabinet") Cabinet cabinet);

    /**
     * 查看详情
     */
    Cabinet query(@Param("cabinetId") int cabinetId);

    /**
     * 去修改的界面信息
     */
    Cabinet selectGo(@Param("cabinetId")int cabinetId,@Param("boxId")int boxId);
}