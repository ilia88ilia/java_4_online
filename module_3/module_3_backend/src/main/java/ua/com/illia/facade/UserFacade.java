package ua.com.illia.facade;

import ua.com.illia.dto.UserCreatedDTO;
import ua.com.illia.dto.UserDetails;
import ua.com.illia.dto.UserWithAccountNumberDTO;
import ua.com.illia.persistence.entity.User;

import java.util.Collection;

public interface UserFacade extends MutableEntityFacade<User> {
    void create(UserCreatedDTO entity);
    UserDetails findById(long id);
    Collection<User> findAll();
    Collection<UserWithAccountNumberDTO> findAllUsersWithNumberOfAccount();
}
