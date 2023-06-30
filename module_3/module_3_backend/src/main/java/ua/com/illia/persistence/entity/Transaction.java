package ua.com.illia.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ua.com.illia.persistence.types.TransactionType;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction extends BaseEntity {
    @Column
    private String description;

    @Column(nullable = false)
    private Long sum;

    @Column(name = "transaction_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @ManyToOne
    private Account account;
    public Transaction() {
        super();
    }
}
