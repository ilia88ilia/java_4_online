package ua.com.illia.service.impl;

import ua.com.illia.annotations.BeanClass;
import ua.com.illia.annotations.InjectBean;
import ua.com.illia.persistence.dao.OwnerDao;
import ua.com.illia.persistence.entity.Owner;
import ua.com.illia.service.OwnerService;

import java.util.Collection;
import java.util.Optional;

@BeanClass
public class OwnerServiceImpl implements OwnerService {
    @InjectBean
    private OwnerDao ownerDao;

    @Override
    public void create(Owner entity) {
        ownerDao.create(entity);
    }

    @Override
    public void update(Owner entity, Long id) {
        Optional<Owner> optionalOwner = ownerDao.findById(id);
        if (optionalOwner.isPresent()) {
            entity.setId(id);
            ownerDao.update(entity, id);
        }
    }

    @Override
    public void delete(Long id) { ownerDao.delete(id); }

    @Override
    public Owner findById(Long id) {
        return ownerDao.findById(id).get();
    }

    @Override
    public Collection<Owner> findAll() {
        return ownerDao.findAll();
    }

    @Override
    public void addPetToOwner(Long petId, Long ownerId) {
        ownerDao.addPetToOwner(petId, ownerId);
    }

    @Override
    public Collection<Owner> findByPet(Long petId) {
        return ownerDao.findByPet(petId);
    }

    @Override
    public void deleteOwnerFromPet(Long petId, Long ownerId) { ownerDao.deleteOwnerFromPet(petId, ownerId); }
}

