package com.qf.member.server.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.common.base.result.RespResult;
import com.qf.common.base.result.ResultCode;
import com.qf.member.entity.BankCard;
import com.qf.member.entity.Member;
import com.qf.member.entity.RealName;
import com.qf.member.mapper.MemberBankMapper;
import com.qf.member.mapper.MemberMapper;
import com.qf.member.server.MemberService;
import com.qf.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import java.util.Date;


@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private MemberBankMapper memberBankMapper;
    @Override
    public Member list(int memberId) {
        return memberMapper.selectByPrimaryKey(memberId);
    }

    @Override
    public RealName list01(int MemberId) {
        return memberMapper.selectById(MemberId);
    }

    @Override
    public BankCard list02(int MemberId) {
        return memberBankMapper.selectById(MemberId);
    }

    @Override
    public RespResult Modification(int MemberId,int memberStatus) {
        Member member = memberMapper.selectByPrimaryKey(MemberId);
        if(!ObjectUtils.isEmpty(member)) {
            member.setMemberStatus(memberStatus);
            return RespResult.success(memberMapper.updateByPrimaryKey(member));
        }
       return RespResult.error(ResultCode.USER_NO_EXIST);
    }

    @Override
    public RespResult Modification01(int MemberId, int accountStatus) {
        BankCard bankCard = memberBankMapper.selectById(MemberId);
        if(!ObjectUtils.isEmpty(bankCard)) {
            bankCard.setAccountStatus(accountStatus);
            return RespResult.success(memberBankMapper.updateById(bankCard));
        }
        return RespResult.error(ResultCode.USER_NO_EXIST);
    }

    @Override
    public PageInfo<MemberVO> list03(Integer page, Integer size,Integer memberId, String phone, String memberName, Integer registrationType, Integer memberStatus, Date startTime, Date endTime) {
        PageInfo<MemberVO> PageInfo = PageHelper.startPage(page, size).doSelectPageInfo(() ->
                memberMapper.selectAll(memberId, phone, memberName, registrationType, memberStatus, startTime, endTime)
        );

      return PageInfo;
    }
}
