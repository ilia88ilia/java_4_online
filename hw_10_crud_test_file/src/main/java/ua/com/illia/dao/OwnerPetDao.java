package ua.com.illia.dao;

import ua.com.illia.entity.Owner;
import ua.com.illia.entity.Pet;

import java.util.Collection;
import java.util.Optional;

public interface OwnerPetDao {
    void createOwner(Owner owner);

    void updateOwner(Owner owner);

    void deleteOwner(String ownerId);

    Optional<Owner> findOwnerById(String id);

    Collection<Owner> findAllOwners();

    void createPet(Pet pet);

    void updatePet(Pet pet);

    void deletePet(String petId);

    Optional<Pet> findPetById(String id);

    Collection<Pet> findAllPets();

    Collection<Owner> findOwnerByPetId(String petId);

    void attachOwnerToPet(String ownerId, String petId);

    void deAttachOwnerFromPet(String ownerId, String petId);

    boolean existByEmail(String email);

}
