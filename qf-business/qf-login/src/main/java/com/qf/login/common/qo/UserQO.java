package com.qf.login.common.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@ApiModel("修改密码请求参数")
@Validated
public class UserQO {

    @ApiModelProperty(value = "用户id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "真实姓名")
    private String reallyName;

    @ApiModelProperty(value = "旧密码")
    @NotBlank(message = "旧密码不能为空")
    private String Password;

    @ApiModelProperty(value = "新密码")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]+$\n", message = "密码格式不正确")
    private String newPassword;

    @ApiModelProperty(value = "确认新密码")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]+$\n", message = "密码格式不正确")
    private String confirmPassword;
}
