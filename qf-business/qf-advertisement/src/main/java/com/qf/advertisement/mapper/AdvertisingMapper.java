package com.qf.advertisement.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.advertisement.entity.Advertising;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.util.ObjectUtils;

@Mapper
public interface AdvertisingMapper extends BaseMapper<Advertising> {

    default LambdaQueryWrapper<Advertising>     queryWrapper(Advertising advertising){

        //多条件查询判断
        LambdaQueryWrapper<Advertising> queryWrapper = new LambdaQueryWrapper<>();
        if (!ObjectUtils.isEmpty(advertising.getAdvertisingTitle())) {
            queryWrapper.like(Advertising::getAdvertisingTitle, advertising.getAdvertisingTitle());
        }

        if (!ObjectUtils.isEmpty(advertising.getCreateTime()) && !ObjectUtils.isEmpty(advertising.getExpiryTime())) {
            queryWrapper.between(Advertising::getCreateTime, advertising.getCreateTime(), advertising.getExpiryTime());
        }

        if (!ObjectUtils.isEmpty(advertising.getExpiryTime())) {
            queryWrapper.le(Advertising::getExpiryTime, advertising.getExpiryTime());
        }

        if (!ObjectUtils.isEmpty(advertising.getStatus())){
            queryWrapper.eq(Advertising::getStatus,advertising.getStatus());
        }

        return queryWrapper;
    }

    /**
     * delete by primary key
     * @param advertisingId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long advertisingId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Advertising record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Advertising record);

    /**
     * select by primary key
     * @param advertisingId primary key
     * @return object by primary key
     */
    Advertising selectByPrimaryKey(Long advertisingId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Advertising record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Advertising record);
}