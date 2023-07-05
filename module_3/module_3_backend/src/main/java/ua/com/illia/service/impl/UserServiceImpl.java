package ua.com.illia.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.illia.dto.UserCreatedDTO;
import ua.com.illia.exception.IncorrectDataException;
import ua.com.illia.persistence.entity.User;
import ua.com.illia.persistence.repository.UserRepository;
import ua.com.illia.service.AccountService;
import ua.com.illia.service.UserService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountService accountService;

    @Transactional
    @Override
    public void create(UserCreatedDTO entity) {
        User user = new User();
        user.setFirstName(entity.getFirstName());
        user.setLastName(entity.getLastName());
        validateUserEntity(user);
        userRepository.save(user);
    }

    @Transactional
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not Found"));
    }

    @Transactional
    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void update(User entity, Long id) {
        validateUserId(id);
        validateUserEntity(entity);
        entity.setId(id);
        userRepository.save(entity);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        validateUserId(id);
        accountService.findByUserId(id).forEach(e -> accountService.delete(e.getId()));
        userRepository.deleteById(id);
    }

    private void validateUserId(Long id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Not Found");
        }
    }

    private void validateUserEntity(User entity) {
        if (entity.getFirstName() == null || entity.getFirstName().equals("")) {
            throw new IncorrectDataException("Incorrect First Name");
        }
        if (entity.getLastName() == null || entity.getLastName().equals("")) {
            throw new IncorrectDataException("Incorrect Last Name");
        }
    }
}
