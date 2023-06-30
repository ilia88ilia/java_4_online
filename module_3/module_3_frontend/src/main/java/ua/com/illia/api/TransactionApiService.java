package ua.com.illia.api;

import ua.com.illia.model.TransactionDetailsModel;
import ua.com.illia.model.TransactionModel;
import ua.com.illia.model.TransactionPostModel;

import java.util.Collection;
import java.util.Optional;

public interface TransactionApiService {
    Boolean create(TransactionPostModel transactionPostModel);
    Optional<TransactionDetailsModel> findById(Long id);
    Collection<TransactionModel> findAll();
    void exportByAccId(long id);
    void exportAll();
}
