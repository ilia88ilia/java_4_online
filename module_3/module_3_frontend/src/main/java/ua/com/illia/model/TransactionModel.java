package ua.com.illia.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TransactionModel {
    private Long id;
    private Long sum;
    private String type;
    private String accName;
    private Date created;
}
