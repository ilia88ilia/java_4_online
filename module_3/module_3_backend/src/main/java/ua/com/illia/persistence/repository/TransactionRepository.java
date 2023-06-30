package ua.com.illia.persistence.repository;

import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.illia.persistence.entity.Transaction;

import java.util.Collection;

@Repository
public interface TransactionRepository extends BaseEntityRepository<Transaction> {
    @Query("from Transaction where account.id=:id")
    Collection<Transaction> findAllByAccountId(@PathParam("id") long id);
}
