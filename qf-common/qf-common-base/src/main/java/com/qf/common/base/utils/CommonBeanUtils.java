package com.qf.common.base.utils;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CommonBeanUtils extends BeanUtils {
    /**
     * @param sources
     * @param target
     * @param <T>
     * @param <S>
     * @return
     */
    public static <T, S> List<S> copyList(List<T> sources, Supplier<S> target) {
        if (sources == null || target == null) {
            return null;
        }
        //  PO对象  Brand     VO  BrandVO
        return sources.stream().map(
                //Brand
                source -> {
                    S s = target.get();
                    copyProperties(source, s);
                    return s;
                }
        ).collect(Collectors.toList());
    }
    public static <T, S> PageInfo<S> copyPageInfo(PageInfo<T> sources, PageInfo<S> pageInfo, Supplier<S> target) {
        copyProperties(sources, pageInfo);
        List<S> list = copyList(sources.getList(), target);
        pageInfo.setList(list);
        return pageInfo;
    }
}
