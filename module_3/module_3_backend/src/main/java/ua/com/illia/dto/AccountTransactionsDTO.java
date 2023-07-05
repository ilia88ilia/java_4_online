package ua.com.illia.dto;

import lombok.Getter;
import lombok.Setter;
import ua.com.illia.persistence.entity.Account;

import java.util.Collection;
import java.util.Date;

@Getter
@Setter
public class AccountTransactionsDTO {
    private Long accId;
    private Date accCreated;
    private String iban;
    private Long balance;
    private String name;
    private Long userId;
    private Collection<TransactionShortInfo> transactions;

    public AccountTransactionsDTO(Account account, Collection<TransactionShortInfo> transactions) {
        this.accId = account.getId();
        this.accCreated = account.getCreated();
        this.iban = account.getIban();
        this.balance = account.getBalance();
        this.name = account.getName();
        this.userId = account.getUser().getId();
        this.transactions = transactions;
    }
}
