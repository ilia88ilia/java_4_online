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
    private static final OwnerPetServiceImpl ownerPetService = new OwnerPetServiceImpl();

    private static final int SIZE = 10;
    private static final String FIRST_NAME = "testFirstName";
    private static final String LAST_NAME = "testLastName";
    private static final String EMAIL = "testEmail@test";
    private static final String PHONE = "1111111111";
    private static final String PET_NAME = "testPetName";

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
        pet.setName(PET_NAME + (char) i);
        return pet;
    }

    @Test
    @Order(1)
    public void checkSizeOwners() {
        Assertions.assertEquals(ownerPetService.findAllOwners().size(), SIZE);
    }


    @Test
    @Order(2)
    public void createOwner() {
        Owner owner = generateOwner(SIZE + 1);
        ownerPetService.createOwner(owner);
        Assertions.assertEquals(ownerPetService.findAllOwners().size(), SIZE + 1);
    }

    @Test
    @Order(3)
    public void updateOwner() {
        Owner current = ownerPetService.findAllOwners().stream().toList().get(0);
        current.setPhone("0983524325");
        ownerPetService.updateOwner(current);
        Assertions.assertNotEquals(ownerPetService.findAllOwners().stream().toList().get(0).getPhone(), PHONE);
    }

    @Test
    @Order(4)
    public void findOwnerById() {
        Owner owner = ownerPetService.findAllOwners().stream().toList().get(0);
        Assertions.assertEquals(ownerPetService.findOwnerById(owner.getId()).getId(), owner.getId());
    }

    @Test
    @Order(5)
    public void deleteOwner() {
        Owner owner = ownerPetService.findAllOwners().stream().toList().get(0);
        ownerPetService.deleteOwner(owner.getId());
        Assertions.assertEquals(ownerPetService.findAllOwners().size(), SIZE);
    }

    @Test
    @Order(6)
    public void shouldBeCreateOwnerWhenEmailIsDuplicate() {
        Owner owner = ownerPetService.findAllOwners().stream().toList().get(0);
        Owner newOwner = new Owner();
        newOwner.setEmail(owner.getEmail());
        ownerPetService.createOwner(newOwner);
        Assertions.assertEquals(ownerPetService.findAllOwners().size(), SIZE);
    }

    @Test
    @Order(7)
    public void checkSizePet() {
        Assertions.assertEquals(ownerPetService.findAllPets().size(), SIZE);
    }

    @Test
    @Order(8)
    public void createPet() {
        Pet pet = generatePet(SIZE + 1);
        ownerPetService.createPet(pet);
        Assertions.assertEquals(ownerPetService.findAllPets().size(), SIZE + 1);
    }

    @Test
    @Order(9)
    public void updatePet() {
        Pet pet = ownerPetService.findAllPets().stream().toList().get(0);
        pet.setName("Cat");
        ownerPetService.updatePet(pet);
        Assertions.assertNotEquals(ownerPetService.findAllPets().stream().toList().get(0).getName(), PET_NAME);
    }

    @Test
    @Order(10)
    public void findPetById() {
        Pet pet = ownerPetService.findAllPets().stream().toList().get(0);
        Assertions.assertEquals(ownerPetService.findPetById(pet.getId()).getId(), pet.getId());
    }

    @Test
    @Order(11)
    public void deletePet() {
        Pet pet = ownerPetService.findAllPets().stream().toList().get(0);
        ownerPetService.deletePet(pet.getId());
        Assertions.assertEquals(ownerPetService.findAllPets().size(), SIZE);
    }

    @Test
    @Order(12)
    public void attachOwnerToPet() {
        Pet currentPet = null;
        for (int i = 0; i < SIZE; i++) {
            Owner atttachOwner = ownerPetService.findAllOwners().stream().toList().get(i);
            currentPet = ownerPetService.findAllPets().stream().toList().get(0);
            ownerPetService.attachOwnerToPet(atttachOwner.getId(), currentPet.getId());
        }
        Assertions.assertEquals(ownerPetService.findOwnerByPetId(currentPet.getId()).size(), SIZE);
    }

    @Test
    @Order(13)
    public void findOwnerByPetId() {
        Pet currentPet = ownerPetService.findAllPets().stream().toList().get(0);
        Assertions.assertEquals(ownerPetService.findOwnerByPetId(currentPet.getId()).size(), SIZE);
    }

    @Test
    @Order(14)
    public void deAttachOwnerFromPet() {
        Pet currentPet = null;
        for (int i = 0; i < SIZE; i++) {
            Owner deleteOwner = ownerPetService.findAllOwners().stream().toList().get(i);
            currentPet = ownerPetService.findAllPets().stream().toList().get(0);
            ownerPetService.deAttachOwnerFromPet(deleteOwner.getId(), currentPet.getId());
        }
        Assertions.assertEquals(ownerPetService.findOwnerByPetId(currentPet.getId()).size(), 0);
    }
}






