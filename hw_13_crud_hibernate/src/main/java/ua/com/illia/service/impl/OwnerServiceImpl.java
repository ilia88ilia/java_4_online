package ua.com.illia.service.impl;

import ua.com.illia.persistence.dao.OwnerDao;
import ua.com.illia.persistence.dao.PetDao;
import ua.com.illia.persistence.dao.impl.OwnerDaoImpl;
import ua.com.illia.persistence.dao.impl.PetDaoImpl;
import ua.com.illia.persistence.entity.Owner;
import ua.com.illia.persistence.entity.Pet;
import ua.com.illia.service.OwnerService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


public class OwnerServiceImpl implements OwnerService {

    private static final OwnerDao ownerDao = new OwnerDaoImpl();

    private static final PetDao petDao = new PetDaoImpl();

    @Override
    public void create(Owner entity) {
        ownerDao.create(entity);
    }

    @Override
    public void update(Owner owner) {
        ownerDao.update(owner);
    }

    @Override
    public void delete(Long id) {
        try {
            Optional<Owner> owner = ownerDao.findById(id);
            Set<Pet> pets = owner.get().getPets();
            for (Pet p : pets) {
                Set<Owner> owners = p.getOwners();
                owners.remove(owner.get());
                petDao.update(p);
            }
            owner.get().setPets(new HashSet<>());
            ownerDao.update(owner.get());
            ownerDao.delete(owner.get());

        } catch (Exception e) {
            System.out.println("No Such Owners");
        }
    }

    @Override
    public Optional<Owner> findById(Long id) {
        return Optional.of(ownerDao.findById(id).get());
    }

    @Override
    public Collection<Owner> findAll() {
        return ownerDao.findAll();
    }
}

