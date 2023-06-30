package ua.com.illia.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TransactionDetailsModel extends TransactionModel {
    private Date created;
    private String description;
    private Long accId;
    private Long userId;
    private String userName;
}
