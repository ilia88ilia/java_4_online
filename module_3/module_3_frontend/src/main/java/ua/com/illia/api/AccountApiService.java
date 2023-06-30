package ua.com.illia.api;

import ua.com.illia.model.AccountDetailsModel;
import ua.com.illia.model.AccountModel;

import java.util.Collection;
import java.util.Optional;

public interface AccountApiService {
    Optional<AccountDetailsModel> findById(Long id);
    Collection<AccountModel> findAll();
}
