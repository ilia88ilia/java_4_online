package ua.com.illia.facade;

import ua.com.illia.persistence.entity.BaseEntity;

public interface MutableEntityFacade<ENTITY extends BaseEntity> {
    void update(ENTITY entity, long id);
    void delete(long id);
}
