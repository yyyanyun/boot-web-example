package com.qf.advertisement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.advertisement.entity.Advertising;

public interface AdvertisingMapper extends BaseMapper<Advertising> {
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