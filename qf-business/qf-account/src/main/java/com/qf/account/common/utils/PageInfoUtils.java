package com.qf.account.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.qf.common.base.utils.CommonBeanUtils;

import java.util.List;
import java.util.function.Supplier;

public class PageInfoUtils extends CommonBeanUtils {


    public static <T, S> PageInfo<S> copyPage(PageInfo<T> sources, PageInfo<S> pageInfo, Supplier<S> target) {
        copyProperties(sources, pageInfo);
        List<S> list = CommonBeanUtils.copyList(sources.getList(), target);
        pageInfo.setList(list);
        return pageInfo;
    }

}
