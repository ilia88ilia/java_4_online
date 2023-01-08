package ua.com.illia;

import ua.com.illia.db.DbStorage;
import ua.com.illia.entity.Owner;
import ua.com.illia.entity.Pet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class OwnerInterface {

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("--------Welcome to PETS-FRIENDS :)-------");
        String select;
        menu();
        while ((select = reader.readLine()) != null) {
            crud(reader,select);
        }
    }

    public void menu() {
        System.out.println("..........................................");
        System.out.println("Crete Owner........................Enter 1");
        System.out.println("Update Owner.......................Enter 2");
        System.out.println("Find Owner.........................Enter 3");
        System.out.println("Find all Owners....................Enter 4");
        System.out.println("----------------------------------------- ");
        System.out.println("Crete Pet Group....................Enter 5");
        System.out.println("Update Pet Group...................Enter 6");
        System.out.println("Find Pet Group.....................Enter 7");
        System.out.println("Find all Pet Groups................Enter 8");
        System.out.println("------------------------------------------");
        System.out.println("Attach Owner to PetGroup...........Enter 9");
        System.out.println("Find Owners by Pet................Enter 10");
        System.out.println("------------------------------------------");
        System.out.println("Delete Owner from Pet Group.......Enter 11");
        System.out.println("Delete Owner......................Enter 12");
        System.out.println("Delete Pet Group..................Enter 13");
        System.out.println("------------------------------------------");
        System.out.println("...............Exit...............Enter 14");
        System.out.println("------------------------------------------");
        System.out.println("ENTER :");
    }

    private void crud(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" : createOwner(reader); break;
            case "2" : updateOwner(reader); break;
            case "3" : findOwnerById(reader); break;
            case "4" : findAllOwners(); break;
            case "5" : createPetGroup(reader); break;
            case "6" : updatePetGroup(reader); break;
            case "7" : findPetGroupById(reader); break;
            case "8" : findAllPetGroups(); break;
            case "9" : attachOwnerToPetGroup(reader); break;
            case "10" : findOwnerByPet(reader); break;
            case "11" : deleteOwnerFromPet(reader); break;
            case "12" : deleteOwner(reader); break;
            case "13" : deletePet(reader); break;
            case "14" : stop(); break;
        }
        menu();
    }

    private void createOwner(BufferedReader reader) throws IOException {
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
        while(!correctLastName) {
            lastName = reader.readLine();
            correctLastName = owner.setLastName(lastName);
        }

        System.out.println();
        System.out.println("Enter the Email");
        System.out.println();
        String email = reader.readLine();
        boolean correctEmail = owner.setEmail(email);
        while(!correctEmail) {
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

        DbStorage.addOwner(owner);

        System.out.println();
        System.out.println("Owner Creation was SUCCESSFUL )))");
        System.out.println();
    }

    private void updateOwner(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("To Update the Owner");
        System.out.println("Please, ENTER owner's ID");
        String id = reader.readLine();
        Owner owner = DbStorage.getOwner(id);
        if (owner == null) {
            System.out.println();
            System.out.println("No owner Found with This Id");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("You are Going to Change the Owner " + owner);
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
            while(!correctLastName) {
                lastName = reader.readLine();
                correctLastName = owner.setLastName(lastName);
            }
            System.out.println();
            System.out.println("Enter the new Owner's Email");
            String email = reader.readLine();
            boolean correctEmail = owner.setEmail(email);
            while(!correctEmail) {
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
            System.out.println();
            System.out.println("Updated SUCCESSFULLY )))");
            System.out.println();

            Owner ownerUpdated = DbStorage.getOwner(id);
            System.out.println("Updated Owner is " + ownerUpdated);
            System.out.println();
        }
    }

    private void findOwnerById(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("To Find the Owner by id");
        System.out.println("Please, ENTER owner's ID");
        String id = reader.readLine();
        Owner owner = DbStorage.getOwner(id);
        if (owner == null) {
            System.out.println("No owner Found with This Id");
        } else {
            System.out.println();
            System.out.println("This Owner is " + owner);
            System.out.println();
        }
    }

    private void findAllOwners(){
        List<Owner> owners = DbStorage.findAllOwners();
        System.out.println();
        System.out.println("Owners of Data Base " + owners);
        System.out.println();
    }

    private void createPetGroup(BufferedReader reader) throws IOException {
        Pet pet = new Pet();
        System.out.println();
        System.out.println("Create Pet Group");
        System.out.println("Please enter name");
        System.out.println("dog, cat, parrot or something else...");
        String name = reader.readLine();
        boolean correctName = pet.setName(name);
        while (!correctName) {
            name = reader.readLine();
            correctName = pet.setName(name);
        }

        DbStorage.addPet(pet);

        System.out.println();
        System.out.println("Pet Group Creation was SUCCESSFUL )))");
        System.out.println();
    }

    private void updatePetGroup(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("To Update the Pet Group");
        System.out.println("Please, ENTER pet group's ID");
        String id = reader.readLine();
        Pet pet = DbStorage.getPet(id);
        if (pet == null) {
            System.out.println();
            System.out.println("No pet groups Found with This Id");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("You are Going to Change the Pet Group = " + pet);
            System.out.println();
            System.out.println("Enter the new Pet Group's Name");
            String name = reader.readLine();
            boolean correctName = pet.setName(name);
            while (!correctName) {
                name = reader.readLine();
                correctName = pet.setName(name);
            }
            System.out.println();
            System.out.println("Updated SUCCESSFULLY )))");
            System.out.println();

            Pet petUpdated = DbStorage.getPet(id);
            System.out.println();
            System.out.println("Updated Pet Group is " + petUpdated);
            System.out.println();
        }
    }

    private void findPetGroupById(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("To Find the Pet Group by id");
        System.out.println("Please, Enter pet group's ID");
        String id = reader.readLine();
        Pet pet = DbStorage.getPet(id);
        if (pet == null) {
            System.out.println();
            System.out.println("No pet groups Found with This Id");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Pet Group = " + pet);
            System.out.println();
        }
    }

    private void findAllPetGroups(){
        List<Pet> pets = DbStorage.findAllPetGroups();
        System.out.println();
        System.out.println("Pet Groups " + pets);
        System.out.println();
    }

    private void attachOwnerToPetGroup(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("To Attach the Owner to Pet Group");
        System.out.println("Please, ENTER pet group's ID");
        String petId = reader.readLine();
        System.out.println();
        System.out.println("Please, ENTER owner's ID");
        String ownerId = reader.readLine();
        DbStorage.addOwnerToPet(ownerId, petId);
    }

    private void findOwnerByPet(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("To Find All Owners by Pet Group");
        System.out.println("Please, ENTER pet groups ID");
        String id = reader.readLine();
        Pet pet = DbStorage.getPet(id);
        if (pet != null) {
            List<Owner> owners = DbStorage.findOwnersByPet(id);
            System.out.println();
            System.out.println("Owners by This Pet Group " + owners);
            System.out.println();
        } else {
            System.out.println();
            System.out.println("No pet groups Found with This Id");
            System.out.println();
        }
    }

    private void deleteOwnerFromPet(BufferedReader reader) throws IOException{
        System.out.println();
        System.out.println("To DELETE the Owner from Pet Group");
        System.out.println("Please, ENTER owner's ID");
        String ownerId = reader.readLine();
        System.out.println();
        System.out.println("Please, ENTER pet group's ID");
        String petId = reader.readLine();
        DbStorage.deleteOwnerFromPet(ownerId, petId);
    }

    private void deleteOwner(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("To DELETE the owner");
        System.out.println("Please, ENTER owner's ID");
        String ownerId = reader.readLine();
        DbStorage.deleteOwner(ownerId);
    }

    private void deletePet(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("To DELETE a Pet Group");
        System.out.println("Please, ENTER pet group's ID");
        String petId = reader.readLine();
        DbStorage.deletePet(petId);
    }

    private void stop() {
        System.exit(0);
    }
}
