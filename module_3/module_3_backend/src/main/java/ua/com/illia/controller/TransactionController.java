package ua.com.illia.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.illia.dto.TransactionCreatedDTO;
import ua.com.illia.dto.TransactionDetails;
import ua.com.illia.dto.TransactionShortInfo;
import ua.com.illia.facade.TransactionFacade;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionFacade transactionFacade;

    @PostMapping("/export")
    public ResponseEntity<Boolean> exportAll() {
        transactionFacade.exportAll();
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostMapping("/export/{id}")
    public ResponseEntity<Boolean> exportAll(@PathVariable Long id) {
        transactionFacade.exportByAccId(id);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostMapping
    public ResponseEntity<Boolean> create(@RequestBody TransactionCreatedDTO transactionDTO) {
        transactionFacade.create(transactionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDetails> findById(@PathVariable Long id) {
        return ResponseEntity.ok(transactionFacade.findById(id));
    }

    @GetMapping
    public ResponseEntity<Collection<TransactionShortInfo>> findAll() {
        return ResponseEntity.ok(transactionFacade.findAll());
    }
}
