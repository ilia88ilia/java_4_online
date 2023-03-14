package ua.com.illia.service;

import ua.com.illia.persistence.entity.Pet;

import java.util.Collection;

public interface PetService {
    void create();

    Pet findById(Long id);

    Collection<Pet> findAll();

    Collection<Pet> findByOwner(Long ownerId);
}
