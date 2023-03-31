package ua.com.illia.persistence.entity;

import jakarta.persistence.*;
import ua.com.illia.persistence.type.PetType;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pet")
public class Pet extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "pet_type")
    private PetType petType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "own_pet",
            joinColumns = @JoinColumn(name = "own_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id")
    )
    private Set<Owner> owners;

    public Pet() {
        super();
        owners = new HashSet<>();
    }


    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Set<Owner> getOwners() { return owners;  }


    @Override
    public boolean equals(Object o) {
       return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    public String toString() {
        return '\n' +
                ", id = '" + getId() + '\'' +
                ", pet Type = '" + petType + '\'' +
                " } ";
    }
}
