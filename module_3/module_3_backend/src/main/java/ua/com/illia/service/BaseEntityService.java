package ua.com.illia.service;

import ua.com.illia.persistence.entity.BaseEntity;

import java.util.Collection;

public interface BaseEntityService<ENTITY extends BaseEntity> {
    ENTITY findById(Long id);
    Collection<ENTITY> findAll();
}
