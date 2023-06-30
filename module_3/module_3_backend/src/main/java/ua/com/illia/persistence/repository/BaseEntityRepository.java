package ua.com.illia.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ua.com.illia.persistence.entity.BaseEntity;

@NoRepositoryBean
public interface BaseEntityRepository<ENTITY extends BaseEntity> extends JpaRepository<ENTITY, Long> {
}
