package ua.com.illia.service;

import ua.com.illia.persistence.entity.Owner;

import java.util.Collection;

public interface OwnerService {

    void create(Owner entity);

    void update(Owner entity, Long id);

    void delete(Long id);

    Owner findById(Long id);

    Collection<Owner> findAll();

    void addPetToOwner(Long petId, Long ownerId);

    Collection<Owner> findByPet(Long petId);

    void deleteOwnerFromPet(Long petId, Long ownerId);
}