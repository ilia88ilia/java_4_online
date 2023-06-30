package ua.com.illia.dto;

import lombok.Getter;
import lombok.Setter;
import ua.com.illia.persistence.entity.Transaction;

@Getter
@Setter
public class TransactionShortInfo {
    private Long id;
    private Long sum;
    private String type;
    private String accName;

    public TransactionShortInfo(Transaction transaction) {
        this.id = transaction.getId();
        this.sum = transaction.getSum();
        this.type = transaction.getTransactionType().toString();
        this.accName = transaction.getAccount().getName();
    }
}
