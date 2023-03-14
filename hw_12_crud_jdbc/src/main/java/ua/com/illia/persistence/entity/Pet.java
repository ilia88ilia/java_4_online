package ua.com.illia.persistence.entity;

import ua.com.illia.persistence.type.PetType;


public class Pet extends BaseEntity {
    private PetType petType;

    public Pet() {
        super();
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }


    @Override
    public String toString() {
        return '\n' +
                ", id = '" + getId() + '\'' +
                ", pet Type = '" + petType + '\'' +
                " } ";
    }
}
