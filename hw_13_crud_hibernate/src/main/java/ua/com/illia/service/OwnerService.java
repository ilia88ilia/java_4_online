package ua.com.illia.service;

import ua.com.illia.persistence.entity.Owner;

import java.util.Collection;
import java.util.Optional;

public interface OwnerService {

    void create(Owner entity);

    void update(Owner owner);

    void delete(Long id);

    Optional<Owner> findById(Long id);

    Collection<Owner> findAll();

}