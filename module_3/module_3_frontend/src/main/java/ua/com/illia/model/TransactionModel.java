package ua.com.illia.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionModel {
    private Long id;
    private Long sum;
    private String type;
    private String accName;
}
