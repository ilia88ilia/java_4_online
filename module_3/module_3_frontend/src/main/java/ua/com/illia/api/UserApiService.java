package ua.com.illia.api;

import ua.com.illia.model.AccountPostModel;
import ua.com.illia.model.UserDetailsModel;
import ua.com.illia.model.UserModel;
import ua.com.illia.model.UserAccountModel;

import java.util.Collection;
import java.util.Optional;

public interface UserApiService {
    Boolean createAccount(AccountPostModel account, Long id);
    Boolean create(UserModel user);
    Optional<UserDetailsModel> findById(Long id);
    Collection<UserAccountModel> findAll();
}
