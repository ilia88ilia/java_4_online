package ua.com.illia.facade;

import ua.com.illia.dto.TransactionCreatedDTO;
import ua.com.illia.dto.TransactionDetails;
import ua.com.illia.dto.TransactionShortInfo;

import java.util.Collection;

public interface TransactionFacade {
    void create(TransactionCreatedDTO transactionDTO);
    Collection<TransactionShortInfo> findAll();
    TransactionDetails findById(long id);
    void exportByAccId(long id);
    void exportAll();
}
