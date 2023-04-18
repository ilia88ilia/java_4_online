package ua.com.illia.service;

import ua.com.illia.entity.Owner;
import ua.com.illia.entity.Pet;

import java.io.FileNotFoundException;
import java.util.Collection;

public interface OwnerPetService {
    void createOwner(Owner owner) throws FileNotFoundException;

    void updateOwner(Owner owner);

    void deleteOwner(String ownerId);

    Owner findOwnerById(String id) throws FileNotFoundException;

    Collection<Owner> findAllOwners();

    void createPet(Pet pet);

    void updatePet(Pet pet);

    void deletePet(String petId);

    Pet findPetById(String id);

    Collection<Owner> findOwnerByPetId(String petId);

    Collection<Pet> findAllPets();

    void attachOwnerToPet(String ownerId, String petId);

    void deAttachOwnerFromPet(String ownerId, String petId);
}
