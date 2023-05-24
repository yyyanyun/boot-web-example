package com.qf.member.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.member.entity.BankCard;
import com.qf.member.entity.Member;
import com.qf.member.entity.RealName;
import com.qf.member.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;


@Mapper
public interface MemberMapper extends BaseMapper<RealName> {
    /**
     * delete by primary key
     * @param memberId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer memberId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Member record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Member record);

    /**
     * select by primary key
     * @param memberId primary key
     * @return object by primary key
     */
    Member selectByPrimaryKey(Integer memberId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Member record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Member record);
    List<MemberVO> selectAll(@Param("memberId") Integer memberId, @Param("phone") String phone, @Param("memberName") String memberName, @Param("registrationType") Integer registrationType, @Param("memberStatus") Integer memberStatus, @Param("startTime")Date startTime, @Param("endTime")Date endTime);
    BankCard selectByMemberId(@Param("memberId") Integer memberId);
    RealName selectByMemberId01(@Param("memberId") Long memberId);
}