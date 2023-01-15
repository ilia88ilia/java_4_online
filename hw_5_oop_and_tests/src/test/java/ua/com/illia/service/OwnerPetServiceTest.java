package ua.com.illia.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import ua.com.illia.entity.Owner;
import ua.com.illia.entity.Pet;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OwnerPetServiceTest {
    private static final OwnerPetService ownerPetService = new OwnerPetService();

    private static final int SIZE = 10;
    private static final String FIRST_NAME = "testFirstName";
    private static final String LAST_NAME = "testLastName";
    private static final String EMAIL = "test@test";
    private static final String PHONE = "1111111111";
    private static final String NAME = "testName";

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < SIZE; i++) {
            Owner owner = generateOwner(i);
            ownerPetService.createOwner(owner);
        }
    }

    @BeforeAll
    public static void setUpPet() {
        for (int i = 0; i < SIZE; i++) {
            Pet pet = generatePet(i);
            ownerPetService.createPet(pet);
        }
    }

    private static Owner generateOwner(int i) {
        Owner owner = new Owner();
        owner.setFirstName(FIRST_NAME + (char) i);
        owner.setLastName(LAST_NAME + (char) i);
        owner.setEmail(EMAIL + i);
        owner.setPhone(PHONE);
        return owner;
    }

    private static Pet generatePet(int i) {
        Pet pet = new Pet();
        pet.setName(NAME + (char) i);
        return pet;
    }

    @Test
    @Order(1)
    public void checkSizeOwners() {
        Assertions.assertEquals(ownerPetService.findAllOwners().size(), SIZE);
    }

    @Test
    @Order(2)
    public void checkSizePets() {
        Assertions.assertEquals(ownerPetService.findAllPets().size(), SIZE);
    }

    @Test
    @Order(3)
    public void createOwner() {
        Owner owner = generateOwner(SIZE + 1);
        ownerPetService.createOwner(owner);
        Assertions.assertEquals(ownerPetService.findAllOwners().size(), SIZE + 1);
    }

    @Test
    @Order(4)
    public void findOwnerById() {
        Owner owner = ownerPetService.findAllOwners().get(0);
        Assertions.assertEquals(ownerPetService.findOwnerById(owner.getId()), owner);
    }

    @Test
    @Order(5)
    public void deleteOwner() {
        Owner owner = ownerPetService.findAllOwners().get(0);
        ownerPetService.deleteOwner(owner.getId());
        Assertions.assertEquals(ownerPetService.findAllOwners().size(), SIZE);
    }

    @Test
    @Order(6)
    public void shouldBeCreateStudentWhenEmailIsDuplicate() {
        Owner owner = ownerPetService.findAllOwners().get(0);
        Owner newOwner = new Owner();
        newOwner.setEmail(owner.getEmail());
        ownerPetService.createOwner(newOwner);
        Assertions.assertEquals(ownerPetService.findAllOwners().size(), SIZE);
    }

    @Test
    @Order(7)
    public void createPet() {
        Pet pet = generatePet(SIZE + 1);
        ownerPetService.createPet(pet);
        Assertions.assertEquals(ownerPetService.findAllPets().size(), SIZE + 1);
    }

    @Test
    @Order(8)
    public void findPetById() {
        Pet pet = ownerPetService.findAllPets().get(0);
        Assertions.assertEquals(ownerPetService.findPetById(pet.getId()), pet);
    }

    @Test
    @Order(9)
    public void deletePet() {
        Pet pet = ownerPetService.findAllPets().get(0);
        ownerPetService.deletePet(pet.getId());
        Assertions.assertEquals(ownerPetService.findAllPets().size(), SIZE);
    }

    @Test
    @Order(10)
    public void attachOwnerToPet() {
        Pet pet = null;
        for (int i = 0; i < SIZE; i++) {
            Owner owner = ownerPetService.findAllOwners().get(i);
            pet = ownerPetService.findAllPets().get(0);
            ownerPetService.attachOwnerToPet(owner.getId(), pet.getId());
        }
        Assertions.assertEquals(ownerPetService.findOwnersByPet(pet.getId()).size(), SIZE);
    }

    @Test
    @Order(11)
    public void findOwnersByPet() {
        Pet pet = ownerPetService.findAllPets().get(0);
        Assertions.assertEquals(ownerPetService.findOwnersByPet(pet.getId()).size(), SIZE);
    }

    @Test
    @Order(12)
    public void deAttachOwnerFromPet() {
        Pet pet = null;
        for (int i = 0; i < SIZE; i++) {
            Owner owner = ownerPetService.findAllOwners().get(i);
            pet = ownerPetService.findAllPets().get(0);
            ownerPetService.deAttachOwnerFromPet(owner.getId(), pet.getId());
        }
        Assertions.assertEquals(ownerPetService.findOwnersByPet(pet.getId()).size(), 0);
    }
}
