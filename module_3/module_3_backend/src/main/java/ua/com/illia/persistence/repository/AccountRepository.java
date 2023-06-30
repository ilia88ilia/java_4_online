package ua.com.illia.persistence.repository;

import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.illia.persistence.entity.Account;

import java.util.Collection;

@Repository
public interface AccountRepository extends BaseEntityRepository<Account> {
    @Query("from Account where user.id=:id")
    Collection<Account> findAllByUserId(@PathParam("id") long id);
}
