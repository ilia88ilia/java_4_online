package ua.com.illia.service;

import ua.com.illia.dto.UserCreatedDTO;
import ua.com.illia.persistence.entity.User;

public interface UserService extends MutableEntityService<User> {
    void create(UserCreatedDTO entity);
}
