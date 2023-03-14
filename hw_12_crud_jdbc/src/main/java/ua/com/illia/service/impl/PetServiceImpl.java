package ua.com.illia.service.impl;

import ua.com.illia.annotations.BeanClass;
import ua.com.illia.annotations.InjectBean;
import ua.com.illia.persistence.dao.PetDao;
import ua.com.illia.persistence.entity.Pet;
import ua.com.illia.service.PetService;

import java.util.Collection;

@BeanClass
public class PetServiceImpl implements PetService {

    @InjectBean
    private PetDao petDao;

    @Override
    public void create() {
        petDao.create();
    }

    @Override
    public Pet findById(Long id) {
        return petDao.findById(id).get();
    }

    @Override
    public Collection<Pet> findAll() {
        return petDao.findAll();
    }

    @Override
    public Collection<Pet> findByOwner(Long ownerId) { return petDao.findByOwner(ownerId); }
}
