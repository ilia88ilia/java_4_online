package ua.com.illia.controller;

import ua.com.illia.annotations.BeanClass;
import ua.com.illia.annotations.Controller;
import ua.com.illia.annotations.InjectBean;
import ua.com.illia.annotations.Start;
import ua.com.illia.persistence.entity.Owner;
import ua.com.illia.persistence.entity.Pet;
import ua.com.illia.service.OwnerService;
import ua.com.illia.service.PetService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

@Controller
@BeanClass
public class CrudControllerImpl implements CrudController {

    @InjectBean
    private OwnerService ownerService;
    @InjectBean
    private PetService petService;


    @Start
    @Override
    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("--------Welcome to PETS-FRIENDS :)-------");
        String select;
        menu();
        while ((select = reader.readLine()) != null) {
            crud(reader, select);
        }
    }

    public void menu() {
        System.out.println("..........................................");
        System.out.println("Crete Owner........................Enter 1");
        System.out.println("Update Owner.......................Enter 2");
        System.out.println("Find Owner by Id...................Enter 3");
        System.out.println("Find all Owners....................Enter 4");
        System.out.println("----------------------------------------- ");
        System.out.println("Create Pet Groups by Default.......Enter 5");
        System.out.println("Find Pet Group by Id...............Enter 6");
        System.out.println("Look all Pet Groups................Enter 7");
        System.out.println("------------------------------------------");
        System.out.println("Attach Owner to PetGroup...........Enter 8");
        System.out.println("Find Owners by Pet.................Enter 9");
        System.out.println("Find Pet Groups by Owner..........Enter 10");
        System.out.println("------------------------------------------");
        System.out.println("Delete Owner from Pet Group.......Enter 11");
        System.out.println("Delete Owner......................Enter 12");
        System.out.println("------------------------------------------");
        System.out.println("...............Exit................Enter 0");
        System.out.println("------------------------------------------");
        System.out.println("ENTER :");
    }

    private void crud(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1":
                create(reader);
                break;
            case "2":
                update(reader);
                break;
            case "3":
                findOwnerById(reader);
                break;
            case "4":
                findAllOwners();
                break;
            case "5":
                createPet();
                break;
            case "6":
                findPetById(reader);
                break;
            case "7":
                findAllPets();
                break;
            case "8":
                addPetToOwner(reader);
                break;
            case "9":
                findOwnerByPet(reader);
                break;
            case "10":
                findPetByOwner(reader);
                break;
            case "11":
                deleteOwnerFromPet(reader);
                break;
            case "12":
                deleteOwner(reader);
                break;
            case "0":
                stop();
                break;
        }
        menu();
    }

    private void create(BufferedReader reader) throws IOException {

        Owner owner = new Owner();

        System.out.println();
        System.out.println("Enter the First Name");
        System.out.println();
        String firstName = reader.readLine();
        boolean correctFirstName = owner.setFirstName(firstName);
        while (!correctFirstName) {
            firstName = reader.readLine();
            correctFirstName = owner.setFirstName(firstName);
        }

        System.out.println();
        System.out.println("Enter the Last Name");
        System.out.println();
        String lastName = reader.readLine();
        boolean correctLastName = owner.setLastName(lastName);
        while (!correctLastName) {
            lastName = reader.readLine();
            correctLastName = owner.setLastName(lastName);
        }

        System.out.println();
        System.out.println("Enter the Email");
        System.out.println();
        String email = reader.readLine();
        boolean correctEmail = owner.setEmail(email);
        while (!correctEmail) {
            email = reader.readLine();
            correctEmail = owner.setEmail(email);
        }

        System.out.println();
        System.out.println("Enter the Phone After +38");
        System.out.println("For Example : 0675476432");
        String phone = reader.readLine();
        boolean correctPhone = owner.setPhone(phone);
        while (!correctPhone) {
            phone = reader.readLine();
            correctPhone = owner.setPhone(phone);
        }

        ownerService.create(owner);
    }

    private void update(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("To Update the Owner");
        System.out.println("Please, ENTER owner's ID");
        String id = reader.readLine();
        try {
            Owner o = ownerService.findById(Long.valueOf(id));
            System.out.println();
            System.out.println("You are Going to Change the Owner " + o);
        } catch (Exception e) {
            System.out.println("No such element");
            start();
        }
        Owner owner = new Owner();
        System.out.println();
        System.out.println("Enter the new Owner's First Name");
        String firstName = reader.readLine();
        boolean correctFirstName = owner.setFirstName(firstName);
        while (!correctFirstName) {
            firstName = reader.readLine();
            correctFirstName = owner.setFirstName(firstName);
        }
        System.out.println();
        System.out.println("Enter the new Owner's Last Name");
        String lastName = reader.readLine();
        boolean correctLastName = owner.setLastName(lastName);
        while (!correctLastName) {
            lastName = reader.readLine();
            correctLastName = owner.setLastName(lastName);
        }
        System.out.println();
        System.out.println("Enter the new Owner's Email");
        String email = reader.readLine();
        boolean correctEmail = owner.setEmail(email);
        while (!correctEmail) {
            email = reader.readLine();
            correctEmail = owner.setEmail(email);
        }
        System.out.println();
        System.out.println("Enter the new Owner's Phone Number");
        String phone = reader.readLine();
        boolean correctPhone = owner.setPhone(phone);
        while (!correctPhone) {
            phone = reader.readLine();
            correctPhone = owner.setPhone(phone);
        }
        ownerService.update(owner, Long.valueOf(id));
    }

    private void findOwnerById(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("To Find the Owner by id");
        System.out.println("Please, ENTER owner's ID");
        String id = reader.readLine();
        try {
            Owner owner = ownerService.findById(Long.valueOf(id));
            System.out.println();
            System.out.println("This Owner is " + owner);
            System.out.println();
        } catch (Exception e) {
            System.out.println();
            System.out.println("No such element");
            System.out.println();
            start();
        }
    }

    private void findAllOwners() {
        Collection<Owner> owners = ownerService.findAll();
        System.out.println();
        System.out.println("Owners of Data Base " + owners);
        System.out.println();
    }

    private void createPet() {
        if (!petService.findAll().isEmpty()) {
            findAllPets();
        } else {
            petService.create();
            findAllPets();
        }
    }

    private void findPetById(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("To Find the Pet Group by id");
        System.out.println("Please, Enter pet group's ID");
        String id = reader.readLine();
        try {
            Pet pet = petService.findById(Long.valueOf(id));
            System.out.println();
            System.out.println("Pet Group = " + pet);
            System.out.println();
        } catch (Exception e) {
            System.out.println();
            System.out.println("No pet group with this id");
            System.out.println();
            start();
        }
    }

    private void findAllPets() {
        Collection<Pet> pets = petService.findAll();
        System.out.println();
        System.out.println("Pet Groups " + pets);
        System.out.println();
    }

    private void addPetToOwner(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("To Attach the Owner to Pet Group");
        System.out.println("Please, ENTER owner ID");
        String ownerId = reader.readLine();
        findAllPets();
        System.out.println("Please, ENTER pet groups ID");
        String petId = reader.readLine();
        System.out.println();
        try {
            ownerService.addPetToOwner(Long.valueOf(petId), Long.valueOf(ownerId));
        } catch (Exception e) {
            System.out.println();
            System.out.println("No owners or pet group with this id");
            System.out.println();
            start();
        }
    }

    private void findOwnerByPet(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("To Find All Owners by Pet Group");
        findAllPets();
        System.out.println("Please, ENTER pet groups ID");
        String petId = reader.readLine();
        try {
            Collection<Owner> owners = ownerService.findByPet(Long.valueOf(petId));
            System.out.println();
            System.out.println("Owners by This Pet Group " + owners);
            System.out.println();
        } catch (Exception e) {
            System.out.println();
            System.out.println("No pet group with this id");
            System.out.println();
            start();
        }
    }

    private void findPetByOwner(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("To Find All Pet Groups by Owner");
        System.out.println("Please, ENTER owner's ID");
        String ownerId = reader.readLine();
        try {
            Collection<Pet> pets = petService.findByOwner(Long.valueOf(ownerId));
            System.out.println();
            System.out.println("Pet Groups by This Owner " + pets);
            System.out.println();
        } catch (Exception e) {
            System.out.println();
            System.out.println("No owners with this id");
            System.out.println();
            start();
        }
    }


    private void deleteOwnerFromPet(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("To DELETE the owner");
        System.out.println("From Pet Group");
        System.out.println("Please, ENTER owner's ID");
        String ownerId = reader.readLine();
        System.out.println();
        findAllPets();
        System.out.println("Please, ENTER pet group's ID");
        String petId = reader.readLine();
        try {
            ownerService.deleteOwnerFromPet(Long.valueOf(petId), Long.valueOf(ownerId));
        } catch (Exception e) {
            System.out.println();
            System.out.println("Incorrect data");
            System.out.println();
            start();
        }
    }

    private void deleteOwner(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("To DELETE the owner");
        System.out.println("Please, ENTER owner's ID");
        Long id = Long.valueOf(reader.readLine());
        ownerService.delete(id);
    }

    private void stop() {
        System.exit(0);
    }
}
