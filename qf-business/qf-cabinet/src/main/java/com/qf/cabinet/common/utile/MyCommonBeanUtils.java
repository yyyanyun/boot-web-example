package com.qf.cabinet.common.utile;

import com.github.pagehelper.PageInfo;
import com.qf.common.base.utils.CommonBeanUtils;

import java.util.List;
import java.util.function.Supplier;

/**
 * 实现CoPy集合的工具类
 */
public class MyCommonBeanUtils extends CommonBeanUtils {
    public static <T, S> PageInfo<S> copyPageInfo(PageInfo<T> source, PageInfo<S> pageInfo, Supplier<S> targetBean) {
        //先将之转换
        copyProperties(source, pageInfo);//留下了查询结果的集合没有copy
        /*遍历集合里面的每一个javaBean对象 进行转换*/
        //1.得到集合
        List<T> list = source.getList();
        //2.调用转集合的方法
        List<S> s = copyList(list, targetBean);
        //3.集合复制成功后 将之赋值给目标集合
        pageInfo.setList(s);

        return pageInfo;
    }
}
