package ua.com.illia.persistence.dao;

import ua.com.illia.persistence.entity.Owner;

import java.util.Collection;
import java.util.Optional;

public interface OwnerDao {

    void create(Owner entity);

    void update(Owner entity, Long id);

    void delete(Long id);

    Optional<Owner> findById(Long id);

    Collection<Owner> findAll();

    void addPetToOwner(Long petId, Long ownerId);

    Collection<Owner> findByPet(Long petId);

    void deleteOwnerFromPet(Long petId, Long ownerId);
}
