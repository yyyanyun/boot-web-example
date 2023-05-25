package com.qf.common.base.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArgsErrorVO {
    private String fieldName;
    private String errorMsg;
}
