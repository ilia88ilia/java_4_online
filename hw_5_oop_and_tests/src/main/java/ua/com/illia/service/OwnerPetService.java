package ua.com.illia.service;

import ua.com.illia.dao.OwnerPetDao;
import ua.com.illia.entity.Owner;
import ua.com.illia.entity.Pet;

import java.util.List;

public class OwnerPetService {
    private OwnerPetDao ownerPetDao = new OwnerPetDao();

    public void createOwner(Owner owner) {
        if (!existByEmail(owner.getEmail())) {
            ownerPetDao.createOwner(owner);
        }
    }

    public Owner findOwnerById(String id) {
        return ownerPetDao.findOwnerById(id);
    }

    public List<Owner> findAllOwners() {
        return ownerPetDao.findAllOwners();
    }

    public void deleteOwner(String id) {
        ownerPetDao.deleteOwner(id);
    }

    public boolean existByEmail(String email) {
        return ownerPetDao.existByEmail(email);
    }

    public void createPet(Pet pet) {
        ownerPetDao.createPet(pet);
    }

    public Pet findPetById(String id) {
        return ownerPetDao.findPetById(id);
    }

    public List<Pet> findAllPets() {
        return ownerPetDao.findAllPets();
    }

    public void deletePet(String id) {
        ownerPetDao.deletePet(id);
    }

    public void attachOwnerToPet(String ownerId, String petId) {
        ownerPetDao.attachOwnerToPet(ownerId, petId);
    }

    public List<Owner> findOwnersByPet(String id) {
        return ownerPetDao.findOwnersByPet(id);
    }

    public void deAttachOwnerFromPet(String ownerId, String petId) {
        ownerPetDao.deAttachOwnerFromPet(ownerId, petId);
    }

}