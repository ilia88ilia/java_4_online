package ua.com.illia.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionCreatedDTO {
    private String description;
    private Long sum;
    private Long senderAccId;
    private Long receiverAccId;
}
