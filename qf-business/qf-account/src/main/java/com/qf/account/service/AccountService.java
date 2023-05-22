package com.qf.account.service;

import com.github.pagehelper.PageInfo;
import com.qf.account.common.qo.AccountQO;
import com.qf.account.common.vo.AccountVO;

public interface AccountService {

    //分页
    PageInfo<AccountVO> pageInfo(Integer currentPageNO, Integer pageSize, Long id, String phone);

    //高级搜索
    PageInfo<AccountVO> pageInfoList(AccountQO accountQO, Integer currentPageNO, Integer pageSize,int paymentStatus);



    int updateUnlock(Long id, int status);
}
