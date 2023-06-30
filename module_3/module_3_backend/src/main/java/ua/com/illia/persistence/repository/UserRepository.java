package ua.com.illia.persistence.repository;

import org.springframework.stereotype.Repository;
import ua.com.illia.persistence.entity.User;

@Repository
public interface UserRepository extends BaseEntityRepository<User> {
}
