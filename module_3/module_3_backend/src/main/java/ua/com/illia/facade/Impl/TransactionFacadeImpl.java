package ua.com.illia.facade.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.illia.dto.TransactionCreatedDTO;
import ua.com.illia.dto.TransactionDetails;
import ua.com.illia.dto.TransactionShortInfo;
import ua.com.illia.facade.TransactionFacade;
import ua.com.illia.service.TransactionService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class TransactionFacadeImpl implements TransactionFacade {

    private final TransactionService transactionService;

    @Override
    public void create(TransactionCreatedDTO transactionDTO) {
        transactionService.create(transactionDTO);
    }

    @Override
    public TransactionDetails findById(long id) {
        return new TransactionDetails(transactionService.findById(id));
    }

    @Override
    public void exportByAccId(long id) {
        transactionService.exportByAccId(id);
    }

    @Override
    public void exportAll() {
        transactionService.exportAll();
    }

    @Override
    public Collection<TransactionShortInfo> findAll() {
        return transactionService.findAll()
                .stream()
                .map(TransactionShortInfo::new)
                .toList();
    }
}
