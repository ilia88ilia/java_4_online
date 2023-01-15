package ua.com.illia.dao;

import ua.com.illia.db.DbStorage;
import ua.com.illia.entity.Owner;
import ua.com.illia.entity.Pet;

import java.util.List;

public class OwnerPetDao {
    DbStorage dbStorage = DbStorage.getInstance();

    public void createOwner(Owner owner) {
        dbStorage.createOwner(owner);
    }

    public Owner findOwnerById(String id) {
        return dbStorage.findOwnerById(id);
    }

    public boolean existByEmail(String email) {
        return dbStorage.existByEmail(email);
    }

    public List<Owner> findAllOwners() {
        return dbStorage.findAllOwners();
    }

    public void deleteOwner(String id) {
        dbStorage.deleteOwner(id);
    }

    public void createPet(Pet pet) {
        dbStorage.createPet(pet);
    }

    public Pet findPetById(String id) {
        return dbStorage.findPetById(id);
    }

    public List<Pet> findAllPets() {
        return dbStorage.findAllPets();
    }

    public void deletePet(String id) {
        dbStorage.deletePet(id);
    }

    public void attachOwnerToPet(String ownerId, String petId) {
        dbStorage.attachOwnerToPet(ownerId, petId);
    }

    public List<Owner> findOwnersByPet(String id) {
        return dbStorage.findOwnersByPet(id);
    }

    public void deAttachOwnerFromPet(String ownerId, String petId) {
        dbStorage.deAttachOwnerFromPet(ownerId, petId);
    }


}