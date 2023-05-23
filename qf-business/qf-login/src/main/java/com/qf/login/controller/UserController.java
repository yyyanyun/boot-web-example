package com.qf.login.controller;

import com.qf.common.base.result.RespResult;
import com.qf.login.common.qo.UserQO;
import com.qf.login.entity.User;
import com.qf.login.service.UserService;
import com.sun.corba.se.spi.orb.ParserImplBase;
import io.swagger.annotations.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@RestController
@RequestMapping("/user")
@Api(tags = "管理员登录接口Api")
@Validated
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("login")
    @ApiOperation("登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true),
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "登录成功"),
            @ApiResponse(code = 400, message = "用户不存在"),
            @ApiResponse(code = 401, message = "账号或者密码错误")
    })
    public RespResult<User> login(@RequestParam @NotBlank(message = "用户名不能为空") String username, @RequestParam @NotBlank(message = "密码不能为空") String password) {
        return RespResult.success(userService.selectById(username, password));
    }

    @PutMapping("/put")
    @ApiOperation("修改密码")
    @ApiImplicitParam(name = "userQO", value = "请求对象参数")
    @ApiResponses({
            @ApiResponse(code = 200, message = "修改成功"),
            @ApiResponse(code = 400, message = "修改失败")
    })
    public RespResult<Integer> update(@RequestBody @Valid UserQO userQO) {
        return RespResult.success(userService.update(userQO));
    }
}
