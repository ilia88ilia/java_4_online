package ua.com.illia.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserWithAccNumberModel {
    private UserModel user;
    private Integer number;
}
