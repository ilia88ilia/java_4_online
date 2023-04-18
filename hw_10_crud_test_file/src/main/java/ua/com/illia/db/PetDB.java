package ua.com.illia.db;

import ua.com.illia.entity.Pet;

import java.util.List;

public class PetDB {
    private List<Pet> pets;

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
