package ua.com.illia.dto;

import lombok.Getter;
import lombok.Setter;
import ua.com.illia.persistence.entity.Transaction;

import java.util.Date;

@Getter
@Setter
public class TransactionDetails extends TransactionShortInfo {
    private Date created;
    private String description;
    private Long accId;
    private Long userId;
    private String userName;

    public TransactionDetails(Transaction transaction) {
        super(transaction);
        this.created = transaction.getCreated();
        this.description = transaction.getDescription();
        this.accId = transaction.getAccount().getId();
        this.userId = transaction.getAccount().getUser().getId();
        this.userName = transaction.getAccount().getUser().getFirstName()
                + " " + transaction.getAccount().getUser().getLastName();
    }
}
