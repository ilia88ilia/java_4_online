package ua.com.illia.facade.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.illia.dto.AccountShortInfo;
import ua.com.illia.dto.UserCreatedDTO;
import ua.com.illia.dto.UserDetails;
import ua.com.illia.dto.UserWithAccountNumberDTO;
import ua.com.illia.facade.UserFacade;
import ua.com.illia.persistence.entity.User;
import ua.com.illia.service.AccountService;
import ua.com.illia.service.TransactionService;
import ua.com.illia.service.UserService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;
    private final AccountService accountService;
    private final TransactionService transactionService;

    @Override
    public void create(UserCreatedDTO entity) {
        userService.create(entity);
    }

    @Override
    public UserDetails findById(long id) {
        return new UserDetails(
                userService.findById(id),
                accountService.findByUserId(id)
                        .stream()
                        .map(e -> new AccountShortInfo(e, transactionService.findAllByAccountId(e.getId()).size()))
                        .toList()
        );
    }

    @Override
    public void update(User entity, long id) {
        userService.update(entity, id);
    }

    @Override
    public void delete(long id) {
        userService.delete(id);
    }

    @Override
    public Collection<User> findAll() {
        return userService.findAll();
    }

    @Override
    public Collection<UserWithAccountNumberDTO> findAllUsersWithNumberOfAccount() {
        return userService.findAll()
                .stream()
                .map(e -> new UserWithAccountNumberDTO(e, accountService.findByUserId(e.getId()).size()))
                .toList();
    }
}
