package ua.com.illia.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionPostModel {
    private String description;
    private Long sum;
    private Long senderAccId;
    private Long receiverAccId;
}
