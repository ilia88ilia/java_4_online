package ua.com.illia.dto;

import lombok.Getter;
import lombok.Setter;
import ua.com.illia.persistence.entity.Account;

@Getter
@Setter
public class AccountShortInfo {
    private Long id;
    private Long balance;
    private String name;
    private Integer transactionNumber;
    private String user;

    public AccountShortInfo(Account account, Integer number) {
        this.id = account.getId();
        this.balance = account.getBalance();
        this.name = account.getName();
        this.transactionNumber = number;
        this.user = account.getUser().getFirstName() + " " + account.getUser().getLastName();
    }
}
