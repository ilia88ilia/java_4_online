package ua.com.illia.dto;

import ua.com.illia.persistence.entity.User;

public record UserWithAccountNumberDTO(User user, int number) {
}
