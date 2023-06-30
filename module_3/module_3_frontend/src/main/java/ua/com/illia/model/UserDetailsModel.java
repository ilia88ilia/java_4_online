package ua.com.illia.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class UserDetailsModel {
    private UserModel user;
    private Collection<AccountModel> accounts;
}
