package ua.com.illia.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.illia.exception.IncorrectDataException;
import ua.com.illia.persistence.entity.Account;
import ua.com.illia.persistence.repository.AccountRepository;
import ua.com.illia.persistence.repository.TransactionRepository;
import ua.com.illia.persistence.repository.UserRepository;
import ua.com.illia.service.AccountService;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    @Override
    @Transactional
    public Collection<Account> findByUserId(long id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Not Found");
        }
        Collection<Account> accounts = accountRepository.findAllByUserId(id);
        return Objects.requireNonNullElse(accounts, Collections.emptyList());
    }

    @Override
    @Transactional
    public void create(Account entity, Long userId) {
        checkAccountData(entity);
        if (userRepository.findById(userId).isEmpty()) {
            throw new EntityNotFoundException("User not Found");
        } else {
            entity.setUser(userRepository.findById(userId).get());
            accountRepository.save(entity);
        }
    }

    @Override
    @Transactional
    public Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not Found"));
    }

    @Transactional
    @Override
    public Collection<Account> findAll() {
        return accountRepository.findAll();
    }

    @Transactional
    @Override
    public void update(Account entity, Long id) {
        checkAccountData(entity);
        if (accountRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Not Found");
        } else {
            entity.setId(id);
            entity.setUser(accountRepository.findById(id).get().getUser());
            accountRepository.save(entity);
        }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        if (accountRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Not Found");
        } else {
            transactionRepository.findAllByAccountId(id).forEach(e -> transactionRepository.deleteById(e.getId()));
            accountRepository.deleteById(id);
        }
    }

    private void checkAccountData(Account entity) {
        if (entity.getBalance() == null || entity.getBalance() < 0) {
            throw new IncorrectDataException("Incorrect Balance");
        }
        if (entity.getName() == null || entity.getName().equals("")) {
            throw new IncorrectDataException("Incorrect Data");
        }
    }
}
