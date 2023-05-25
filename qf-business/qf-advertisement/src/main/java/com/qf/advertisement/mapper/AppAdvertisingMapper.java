package com.qf.advertisement.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.advertisement.entity.AppAdvertising;
import org.springframework.util.ObjectUtils;

public interface AppAdvertisingMapper extends BaseMapper<AppAdvertising> {

    default LambdaQueryWrapper<AppAdvertising> QueryWrapper(AppAdvertising appAdvertising){
        LambdaQueryWrapper<AppAdvertising> queryWrapper = new LambdaQueryWrapper<>();

        // ID
        if (!ObjectUtils.isEmpty(appAdvertising.getAppId())){
            queryWrapper.eq(AppAdvertising::getAppId,appAdvertising.getAppId());
        }

        // 时间
        if (!ObjectUtils.isEmpty(appAdvertising.getExpireDate())&&!ObjectUtils.isEmpty(appAdvertising.getPushTime())){
            queryWrapper.gt(AppAdvertising::getCreateTime,appAdvertising.getCreateTime());

            queryWrapper.le(AppAdvertising::getExpireDate,appAdvertising.getExpireDate());
        }
        return queryWrapper;

    }
    /**
     * delete by primary key
     *
     * @param appId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer appId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(AppAdvertising record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(AppAdvertising record);

    /**
     * select by primary key
     *
     * @param appId primary key
     * @return object by primary key
     */
    AppAdvertising selectByPrimaryKey(Integer appId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(AppAdvertising record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(AppAdvertising record);
}