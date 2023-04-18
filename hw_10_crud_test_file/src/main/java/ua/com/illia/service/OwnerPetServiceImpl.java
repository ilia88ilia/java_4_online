package ua.com.illia.service;

import ua.com.illia.dao.OwnerPetDao;
import ua.com.illia.dao.OwnerPetDaoImpl;
import ua.com.illia.entity.Owner;
import ua.com.illia.entity.Pet;

import java.util.Collection;
import java.util.Optional;

public class OwnerPetServiceImpl implements OwnerPetService {
    private final OwnerPetDao ownerPetDao = new OwnerPetDaoImpl();

    @Override
    public void createOwner(Owner owner) {
        if (!existByEmail(owner.getEmail())) {
            ownerPetDao.createOwner(owner);
        }
    }

    @Override
    public void updateOwner(Owner owner) {
        ownerPetDao.updateOwner(owner);
    }

    @Override
    public void deleteOwner(String ownerId) {
        ownerPetDao.deleteOwner(ownerId);
    }

    @Override
    public Owner findOwnerById(String id) {
        Optional<Owner> findOwner = ownerPetDao.findOwnerById(id);
        if (findOwner.isPresent()) {
            return findOwner.get();
        } else {
            System.out.println("No such Owner");
            return null;
        }
    }

    @Override
    public Collection<Owner> findAllOwners() {
        return ownerPetDao.findAllOwners();
    }

    @Override
    public void createPet(Pet pet) {
        ownerPetDao.createPet(pet);
    }

    @Override
    public void updatePet(Pet pet) {
        ownerPetDao.updatePet(pet);
    }

    @Override
    public void deletePet(String petId) {
        ownerPetDao.deletePet(petId);
    }

    @Override
    public Pet findPetById(String id) {
        Optional<Pet> findPet = ownerPetDao.findPetById(id);
        if (findPet.isPresent()) {
            return findPet.get();
        } else {
            System.out.println("No such Pet");
            return null;
        }
    }

    @Override
    public Collection<Owner> findOwnerByPetId(String petId) {
        return ownerPetDao.findOwnerByPetId(petId);
    }

    @Override
    public Collection<Pet> findAllPets() {
        return ownerPetDao.findAllPets();
    }

    @Override
    public void attachOwnerToPet(String ownerId, String petId) {
        ownerPetDao.attachOwnerToPet(ownerId, petId);
    }

    @Override
    public void deAttachOwnerFromPet(String ownerId, String petId) {
        ownerPetDao.deAttachOwnerFromPet(ownerId, petId);
    }

    private boolean existByEmail(String email) {
        return ownerPetDao.existByEmail(email);
    }

}