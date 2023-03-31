package ua.com.illia.service.impl;

import ua.com.illia.persistence.dao.PetDao;
import ua.com.illia.persistence.dao.impl.PetDaoImpl;
import ua.com.illia.persistence.entity.Pet;
import ua.com.illia.service.PetService;

import java.util.Collection;
import java.util.Optional;


public class PetServiceImpl implements PetService {

    private static final PetDao petDao = new PetDaoImpl();

    @Override
    public void create(Pet pet) {
        petDao.create(pet);
    }

    @Override
    public void update(Pet pet) {
        petDao.update(pet);
    }

    @Override
    public Optional<Pet> findById(Long id) {
        return Optional.of(petDao.findById(id).get());
    }

    @Override
    public Collection<Pet> findAll() {
        return petDao.findAll();
    }
}
