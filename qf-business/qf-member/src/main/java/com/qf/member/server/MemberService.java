package com.qf.member.server;

import com.github.pagehelper.PageInfo;
import com.qf.common.base.result.RespResult;
import com.qf.member.entity.BankCard;
import com.qf.member.entity.Member;
import com.qf.member.entity.RealName;
import com.qf.member.vo.MemberVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface MemberService {
    Member list(int memberId);
    RealName list01(int MemberId);
    BankCard list02(int MemberId);
    RespResult Modification(int MemberId,int memberStatus);
    RespResult Modification01(int MemberId,int accountStatus);
    PageInfo<MemberVO> list03(Integer page, Integer size, Integer memberId, String phone, String memberName, Integer registrationType, Integer memberStatus, Date startTime, Date endTime);

}
