package com.qf.cabinet.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.cabinet.entity.ExpressBox;
import com.qf.cabinet.qo.ExpressBoxQo;
import com.qf.common.base.result.RespResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ExpressBoxMapper extends BaseMapper<ExpressBox> {

    /**
     * 统计使用中的个数
     */
    default Long count(int cabinetId,int status){
        LambdaQueryWrapper<ExpressBox> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ExpressBox::getCabinetId,cabinetId).eq(ExpressBox::getUsageStatus,status);
        return this.selectCount(queryWrapper);
    }

    /**
     * 每个柜机的箱格数
     */
    default Long countByCid(int cabinetId){
        LambdaQueryWrapper<ExpressBox> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ExpressBox::getCabinetId,cabinetId);
        return this.selectCount(queryWrapper);
    }
    /**
     * 根据柜机ID查询
     */
    List<ExpressBox> selectById(@Param("expressBox") ExpressBox expressBox);

    /**
     * 查看箱格记录
     */
    ExpressBox selectByBoxId(@Param("boxId") int boxId);

    /**
     * 根据柜机ID查询箱格
     */
    List<ExpressBox> selectByCabinetId(int cabinetId);

    /**
     *  根据柜机ID、箱格序号修改
     */
    Integer update(@Param("expressBox") ExpressBox expressBox);


}