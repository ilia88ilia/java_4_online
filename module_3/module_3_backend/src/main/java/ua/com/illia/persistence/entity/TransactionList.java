package ua.com.illia.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "transactions_list")
public class TransactionList extends BaseEntity {

    @ManyToOne
    private Transaction transaction;

    @ManyToOne
    private TransactionCategory transactionCategory;

    @ManyToOne
    private User user;

    public TransactionList() {
        super();
    }
}
