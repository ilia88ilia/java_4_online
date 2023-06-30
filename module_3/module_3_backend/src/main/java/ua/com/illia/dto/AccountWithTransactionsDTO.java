package ua.com.illia.dto;

import lombok.Getter;
import lombok.Setter;
import ua.com.illia.persistence.entity.Account;

import java.util.Collection;
import java.util.Date;

@Getter
@Setter
public class AccountWithTransactionsDTO {
    private Long accId;
    private Date accCreated;
    private Long balance;
    private String name;
    private Long userId;
    private Collection<TransactionShortInfo> transactions;

    public AccountWithTransactionsDTO(Account account, Collection<TransactionShortInfo> transactions) {
        this.accId = account.getId();
        this.accCreated = account.getCreated();
        this.balance = account.getBalance();
        this.name = account.getName();
        this.userId = account.getUser().getId();
        this.transactions = transactions;
    }
}
