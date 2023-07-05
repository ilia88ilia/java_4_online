package ua.com.illia.service;

import jakarta.persistence.EntityNotFoundException;
import ua.com.illia.dto.TransactionCreatedDTO;
import ua.com.illia.exception.IncorrectDataException;
import ua.com.illia.persistence.entity.Account;
import ua.com.illia.persistence.entity.User;
import ua.com.illia.persistence.repository.AccountRepository;
import ua.com.illia.persistence.repository.TransactionRepository;
import ua.com.illia.persistence.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.UUID;

@SpringBootTest
public class TransactionServiceTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionService transactionService;

    @Test
    @Transactional
    public void testCreateCorrectData() {
        Account sender = createAccount();
        Account receiver = createAccount();
        TransactionCreatedDTO transaction = new TransactionCreatedDTO();
        transaction.setReceiverAccId(receiver.getId());
        transaction.setSenderAccId(sender.getId());
        transaction.setSum(500L);
        transaction.setDescription("Test");
        int before = transactionRepository.findAll().size();
        transactionService.create(transaction);
        int after = transactionRepository.findAll().size();
        Assertions.assertEquals(before + 2, after);
    }

    @Test
    @Transactional
    public void testCreateIncorrectUserData() {
        TransactionCreatedDTO transaction = new TransactionCreatedDTO();
        transaction.setReceiverAccId(Long.MAX_VALUE);
        transaction.setSenderAccId(Long.MAX_VALUE);
        transaction.setSum(500L);
        transaction.setDescription("Test");
        int before = transactionRepository.findAll().size();
        Assertions.assertThrows(EntityNotFoundException.class, () -> transactionService.create(transaction));
        int after = transactionRepository.findAll().size();
        Assertions.assertEquals(before, after);
    }

    @Test
    @Transactional
    public void testCreateIncorrectDuplicatedUserData() {
        Account sender = createAccount();
        TransactionCreatedDTO transaction = new TransactionCreatedDTO();
        transaction.setReceiverAccId(sender.getId());
        transaction.setSenderAccId(sender.getId());
        transaction.setSum(500L);
        transaction.setDescription("Test");
        int before = transactionRepository.findAll().size();
        Assertions.assertThrows(IncorrectDataException.class, () -> transactionService.create(transaction));
        int after = transactionRepository.findAll().size();
        Assertions.assertEquals(before, after);
    }

    @Test
    @Transactional
    public void testCreateIncorrectData() {
        Account receiver = createAccount();
        Account sender = createAccount();
        TransactionCreatedDTO transaction = new TransactionCreatedDTO();
        transaction.setReceiverAccId(receiver.getId());
        transaction.setSenderAccId(sender.getId());
        transaction.setSum((long) -500); // Positive values only
        transaction.setDescription("Test");
        int before = transactionRepository.findAll().size();
        Assertions.assertThrows(IncorrectDataException.class, () -> transactionService.create(transaction));
        int after = transactionRepository.findAll().size();
        Assertions.assertEquals(before, after);
    }

    @Test
    @Transactional
    public void testCreateIncorrectLowMoneyData() {
        Account receiver = createAccount();
        Account sender = createAccount();
        TransactionCreatedDTO transaction = new TransactionCreatedDTO();
        transaction.setReceiverAccId(receiver.getId());
        transaction.setSenderAccId(sender.getId());
        transaction.setSum(Long.MAX_VALUE);
        transaction.setDescription("Test");
        int before = transactionRepository.findAll().size();
        Assertions.assertThrows(IncorrectDataException.class, () -> transactionService.create(transaction));
        int after = transactionRepository.findAll().size();
        Assertions.assertEquals(before, after);
    }

    @Test
    @Transactional
    public void testFindByAccountCorrectIdData() {
        Account receiver = createAccount();
        TransactionCreatedDTO transaction = new TransactionCreatedDTO();
        TransactionCreatedDTO transaction2 = new TransactionCreatedDTO();
        transaction.setReceiverAccId(receiver.getId());
        transaction.setSenderAccId(createAccount().getId());
        transaction.setSum(500L);
        transaction.setDescription("Test");
        transaction2.setReceiverAccId(receiver.getId());
        transaction2.setSenderAccId(createAccount().getId());
        transaction2.setSum(400L);
        transaction2.setDescription("Test 2");
        int rtb = transactionService.findAllByAccountId(receiver.getId()).size();
        int before = transactionRepository.findAll().size();
        transactionService.create(transaction);
        transactionService.create(transaction2);
        int rta = transactionService.findAllByAccountId(receiver.getId()).size();
        int after = transactionRepository.findAll().size();
        Assertions.assertEquals(rtb + 2, rta);
        Assertions.assertEquals(before + 4, after);
    }

    private Account createAccount() {
        Random random = new Random();
        Account account = new Account();
        account.setIban(UUID.randomUUID().toString().substring(0, 8));
        account.setBalance(random.nextLong(1_000, 10_000));
        account.setName(UUID.randomUUID().toString().substring(0, 8));
        account.setUser(createUser());
        accountRepository.save(account);
        return account;
    }

    private User createUser() {
        User user = new User();
        user.setFirstName(UUID.randomUUID().toString().substring(0, 8));
        user.setLastName(UUID.randomUUID().toString().substring(0, 8));
        userRepository.save(user);
        return user;
    }
}