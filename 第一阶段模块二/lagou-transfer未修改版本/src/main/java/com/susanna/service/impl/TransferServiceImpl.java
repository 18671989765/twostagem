package com.susanna.service.impl;

import com.susanna.dao.AccountDao;
import com.susanna.dao.impl.JdbcAccountDaoImpl;
import com.susanna.pojo.Account;
import com.susanna.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("transferService")
public class TransferServiceImpl implements TransferService {


    @Autowired
    @Qualifier("accountDao")
    private AccountDao accountDao ;

    @Override
    public void transfer(String fromCardNo, String toCardNo, int money) throws Exception {
        Account from = accountDao.queryAccountByCardNo(fromCardNo);
        Account to = accountDao.queryAccountByCardNo(toCardNo);

        from.setMoney(from.getMoney()-money);
        to.setMoney(to.getMoney()+money);
        int i = 1/0;
        accountDao.updateAccountByCardNo(to);
        accountDao.updateAccountByCardNo(from);
    }
}
