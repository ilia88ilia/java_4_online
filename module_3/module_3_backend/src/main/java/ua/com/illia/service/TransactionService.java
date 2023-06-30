package ua.com.illia.service;

import ua.com.illia.dto.TransactionCreatedDTO;
import ua.com.illia.persistence.entity.Transaction;

import java.util.Collection;

public interface TransactionService extends BaseEntityService<Transaction> {
    void create(TransactionCreatedDTO transactionDTO);
    Collection<Transaction> findAllByAccountId(long id);
    void exportByAccId(long id);
    void exportAll();
}