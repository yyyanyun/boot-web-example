package com.qf.member.controller;

import com.github.pagehelper.PageInfo;
import com.qf.common.base.result.RespResult;
import com.qf.member.entity.BankCard;
import com.qf.member.entity.Member;
import com.qf.member.entity.RealName;
import com.qf.member.server.MemberService;
import com.qf.member.vo.MemberVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/member")
@Api("查询会员")
public class MemberController {
    @Resource
    private MemberService memberService;
    @GetMapping("/list")
    @ApiOperation("查询会员详情")
    @ApiImplicitParam(name = "memberId",value = "会员号")
public RespResult<Member> list(@RequestParam() int memberId){
    return RespResult.success(memberService.list(memberId));
}
    @GetMapping("/list01")
    @ApiOperation("查询会员的实名详情")
    @ApiImplicitParam(name = "memberId",value = "会员号")
    public RespResult<RealName> list01(@RequestParam("memberId") int memberId){
        return RespResult.success(memberService.list01(memberId));
    }
    @GetMapping("/list02")
    @ApiOperation("查询会员的账户详情")
    @ApiImplicitParam(name = "memberId",value = "会员号")
    public RespResult<BankCard> list02(@RequestParam("memberId") int memberId){
        return RespResult.success(memberService.list02(memberId));
    }
    @PutMapping("/Modification")
    @ApiOperation("修改会员状态")
    @ApiImplicitParams({@ApiImplicitParam( name = "memberId",value = "会员号"),@ApiImplicitParam( name = "memberStatus",value = "会员状态")})
    public RespResult Modification(@RequestParam("memberId")int MemberId,@RequestParam("memberStatus")int memberStatus) {
        return memberService.Modification(MemberId,memberStatus);
    }
    @PutMapping("/Modification01")
    @ApiOperation("修改账户状态")
    @ApiImplicitParams({@ApiImplicitParam( name = "memberId",value = "会员号"),@ApiImplicitParam( name = "accountStatus",value = "账户状态")})
    public RespResult Modification01(@RequestParam("memberId") int MemberId,@RequestParam("accountStatus") int accountStatus) {
        return memberService.Modification01(MemberId,accountStatus);
    }
    @GetMapping("/list03")
    @ApiOperation("分页条件查询会员")
    @ApiImplicitParams({@ApiImplicitParam( name = "page",value = "起始页面"),
            @ApiImplicitParam( name = "size",value = "页量"),
            @ApiImplicitParam( name = "memberId",value = "id"),
            @ApiImplicitParam( name = "phone",value = "电话"),
            @ApiImplicitParam( name = "memberName",value = "会员名"),
            @ApiImplicitParam( name = "registrationType",value = "注册类型"),
            @ApiImplicitParam( name = "memberStatus",value = "会员状态"),
            @ApiImplicitParam( name = "startTime",value = "开始时间"),
            @ApiImplicitParam( name = "endTime",value = "结束时间")})
    public RespResult<PageInfo<MemberVO>> list03(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size,  Integer memberId, String phone, String memberName, Integer registrationType, Integer memberStatus, Date startTime, Date endTime) {
        return RespResult.success(memberService.list03(page, size, memberId, phone, memberName, registrationType, memberStatus, startTime, endTime));
    }
}
