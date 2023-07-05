package ua.com.illia.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountModel {
    private Long id;
    private String IBAN;
    private Integer transactionNumber;
    private String user;
    private Long userId;

}
