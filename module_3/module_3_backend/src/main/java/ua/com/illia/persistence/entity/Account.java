package ua.com.illia.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account extends BaseEntity {

    @Column(nullable = false)
    private String iban;

    @Column(nullable = false)
    private Long balance;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private User user;

    public Account() {
        super();
    }
}
