package ua.com.illia.facade;

import ua.com.illia.dto.AccountShortInfo;
import ua.com.illia.dto.AccountTransactionsDTO;
import ua.com.illia.persistence.entity.Account;

import java.util.Collection;

public interface AccountFacade extends MutableEntityFacade<Account> {
    void create(Account entity, Long userId);
    AccountTransactionsDTO findById(long id);
    Collection<AccountShortInfo> findAll();
}
