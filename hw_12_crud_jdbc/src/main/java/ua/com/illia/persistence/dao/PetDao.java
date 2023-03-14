package ua.com.illia.persistence.dao;

import ua.com.illia.persistence.entity.Pet;

import java.util.Collection;
import java.util.Optional;

public interface PetDao {

    void create();

    Optional<Pet> findById(Long id);

    Collection<Pet> findAll();

    Collection<Pet> findByOwner(Long ownerId);
}
