package ua.com.illia.service;

import ua.com.illia.persistence.entity.Pet;

import java.util.Collection;
import java.util.Optional;

public interface PetService {

    void create(Pet pet);

    void update(Pet pet);

    Optional<Pet> findById(Long id);

    Collection<Pet> findAll();
}
