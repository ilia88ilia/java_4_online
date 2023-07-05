package ua.com.illia.facade.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.illia.dto.AccountShortInfo;
import ua.com.illia.dto.AccountTransactionsDTO;
import ua.com.illia.dto.TransactionShortInfo;
import ua.com.illia.facade.AccountFacade;
import ua.com.illia.persistence.entity.Account;
import ua.com.illia.service.AccountService;
import ua.com.illia.service.TransactionService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class AccountFacadeImpl implements AccountFacade {

    private final AccountService accountService;
    private final TransactionService transactionService;

    @Override
    public Collection<AccountShortInfo> findAll() {
        return accountService.findAll()
                .stream()
                .map(e -> new AccountShortInfo(e, transactionService.findAllByAccountId(e.getId()).size()))
                .toList();
    }

    @Override
    public void create(Account entity, Long userId) {
        accountService.create(entity, userId);
    }

    @Override
    public AccountTransactionsDTO findById(long id) {
        return new AccountTransactionsDTO(
                accountService.findById(id),
                transactionService.findAllByAccountId(id)
                        .stream()
                        .map(TransactionShortInfo::new)
                        .toList()
        );
    }

    @Override
    public void update(Account entity, long id) {
        accountService.update(entity, id);
    }

    @Override
    public void delete(long id) {
        accountService.delete(id);
    }
}
