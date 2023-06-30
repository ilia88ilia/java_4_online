package ua.com.illia.dto;

import ua.com.illia.persistence.entity.User;

import java.util.Collection;

public record UserDetails(User user, Collection<AccountShortInfo> accounts) {
}
