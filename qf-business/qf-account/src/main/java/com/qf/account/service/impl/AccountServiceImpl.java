package com.qf.account.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.account.common.qo.AccountQO;
import com.qf.account.common.vo.AccountVO;
import com.qf.account.common.utils.PageInfoUtils;
import com.qf.account.entity.Account;
import com.qf.account.mapper.AccountMapper;
import com.qf.account.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public PageInfo<AccountVO> pageInfo(Integer currentPageNO, Integer pageSize, Long id, String phone) {

        PageInfo<AccountVO> accountVOPageInfo = PageHelper.startPage(currentPageNO, pageSize).doSelectPageInfo(() -> accountMapper.selectByPhoneOrId(id, phone));
        return PageInfoUtils.copyPage(accountVOPageInfo, new PageInfo<>(), AccountVO::new);
    }

    @Override
    public PageInfo<AccountVO> pageInfoList(AccountQO accountQO, Integer currentPageNO, Integer pageSize) {

        Account account = new Account();
        BeanUtils.copyProperties(accountQO, account);

        PageInfo<AccountVO> accountVOPageInfo = PageHelper.startPage(currentPageNO, pageSize).doSelectPageInfo(() -> accountMapper.selectAdvancedSearch(account));
        return PageInfoUtils.copyPage(accountVOPageInfo, new PageInfo<>(), AccountVO::new);

    }
}
