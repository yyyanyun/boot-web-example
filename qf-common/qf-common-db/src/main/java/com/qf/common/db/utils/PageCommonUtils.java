package com.qf.common.db.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qf.common.base.utils.CommonBeanUtils;

import java.util.List;
import java.util.function.Supplier;

public class PageCommonUtils extends CommonBeanUtils {

    public static <T, S> IPage<S> copyPage(IPage<T> sources, IPage<S> pageInfo, Supplier<S> target) {
        copyProperties(sources, pageInfo);
        List<S> list = CommonBeanUtils.copyList(sources.getRecords(), target);
        pageInfo.setRecords(list);
        return pageInfo;
    }
}
