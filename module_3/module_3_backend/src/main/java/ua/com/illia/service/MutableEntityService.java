package ua.com.illia.service;

import ua.com.illia.persistence.entity.BaseEntity;

public interface MutableEntityService<ENTITY extends BaseEntity> extends BaseEntityService<ENTITY> {
    void update(ENTITY entity, Long id);
    void delete(Long id);
}
