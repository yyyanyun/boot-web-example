package com.qf.advertisement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.advertisement.entity.Video;

public interface VideoMapper extends BaseMapper<Video> {
    /**
     * delete by primary key
     * @param videoId primaryKey
     * @return deleteCount
     */



    int deleteByPrimaryKey(Long videoId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Video record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Video record);

    /**
     * select by primary key
     * @param videoId primary key
     * @return object by primary key
     */
    Video selectByPrimaryKey(Long videoId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Video record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Video record);
}