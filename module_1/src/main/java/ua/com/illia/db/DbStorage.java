package ua.com.illia.db;

import ua.com.illia.entity.Owner;
import ua.com.illia.entity.Pet;

import java.util.*;
import java.util.stream.Collectors;

public class DbStorage {
    private static List<Owner> owners = new ArrayList<>();
    private static List<Pet> pets = new ArrayList<>();

    private DbStorage() {
    }


    public static void addOwner(Owner owner) {
        owner.setId(generateOwnerId());
        owners.add(owner);
    }

    private static String generateOwnerId() {
        String id = UUID.randomUUID().toString();
        if (owners.stream().anyMatch(owner -> owner.getId().equals(id))) {
            return generateOwnerId();
        }
        return id;
    }
   public static Owner getOwner(String id) {
        Owner owner = null;
        for (int i = 0; i < owners.size(); i++) {
            if (owners.get(i) != null) {
                if (owners.get(i).getId().equals(id)) {
                    owner = owners.get(i);
                    break;
                }
            }
        }
        return owner;
   }

    public static List<Owner> findAllOwners() {
        return owners.
                stream().
                sorted(Comparator.comparing(owner -> owner.getLastName()))
                .collect(Collectors.toList());
    }

    public static void addPet(Pet pet) {
        pet.setId(generatePetId());
        pets.add(pet);
    }

    private static String generatePetId() {
        String id = UUID.randomUUID().toString();
        if (pets.stream().anyMatch(pet -> pet.getId().equals(id))) {
            return generatePetId();
        }
        return id;
    }

    public static Pet getPet(String id) {
        Pet pet = null;
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i) != null) {
                if (pets.get(i).getId().equals(id)){
                    pet = pets.get(i);
                    break;
                }
            }
        }
        return pet;
    }

    public static List<Pet> findAllPetGroups() {
        return pets.
                stream().
                sorted(Comparator.comparing(pet -> pet.getName()))
                .collect(Collectors.toList());
    }

    public static void addOwnerToPet(String ownerId, String petId) {
        Pet pet = getPet(petId);
        Owner owner = getOwner(ownerId);
        if (pet != null && owner != null) {
            Set<String> owners = pet.getOwnerIdList();
            owners.add(ownerId);
            Set<String> pets = owner.getPetIdList();
            pets.add(petId);
            System.out.println();
            System.out.println("Attached SUCCESSFULLY )))");
            System.out.println();
        } else if (pet == null) {
            System.out.println();
            System.out.println("No pet groups Found with This Id");
            System.out.println();
        }
        else if (owner == null) {
            System.out.println();
            System.out.println("No owner Found with This Id");
            System.out.println();
        }
    }

    public static List<Owner> findOwnersByPet(String id) {
        Pet pet = getPet(id);
        Set<String> ownersIds = pet.getOwnerIdList();
        List<Owner> owners = new ArrayList<>();
        for (String ownerId : ownersIds) {
            Owner owner = getOwner(ownerId);
            if (owner != null) {
                owners.add(owner);
            }
        }
        return owners;
    }

    public static void deleteOwnerFromPet(String ownerId, String petId) {
        Owner owner = getOwner(ownerId);
        if (owner == null) {
            System.out.println();
            System.out.println("No owner Found with This Id");
            System.out.println();
        } else {
            Set<String> pets = owner.getPetIdList();
            pets.remove(petId);
            Pet pet = getPet(petId);
            if (pet == null){
              System.out.println();
              System.out.println("No pet groups Found with This Id");
              System.out.println();
            } else {
                Set<String> owners = pet.getOwnerIdList();
                owners.remove(ownerId);
                System.out.println();
                System.out.println("The owner from pet group Deleted");
                System.out.println();
            }
        }
    }
    public static void deleteOwner(String ownerId) {
        Owner owner = getOwner(ownerId);
        if (owner == null) {
            System.out.println();
            System.out.println("No owner Found with This Id");
            System.out.println();
        } else {
            Set<String> petIds = owner.getPetIdList();
            for (String petId : petIds) {
                deleteOnlyOwnerFromPet(ownerId, petId);
            }
            owners.remove(owner);
            System.out.println();
            System.out.println("The owner Deleted");
            System.out.println();
        }
    }

    public static void deleteOnlyOwnerFromPet(String ownerId, String petId) {
        Pet pet = getPet(petId);
        if (pet == null){
            System.out.println();
            System.out.println("No pet groups Found with This Id");
            System.out.println();
        } else {
            Set<String> owners = pet.getOwnerIdList();
            owners.remove(ownerId);
        }
    }


    public static void deletePet(String petId) {
            Pet pet = getPet(petId);
        if (pet == null){
            System.out.println();
            System.out.println("No pet groups Found with This Id");
            System.out.println();
        } else {
            Set<String> ownerIds = pet.getOwnerIdList();
            for (String ownerId : ownerIds) {
                deleteOnlyPetFromOwner(petId, ownerId);
            }
            pets.remove(pet);
            System.out.println();
            System.out.println("The pet group Deleted");
            System.out.println();
        }
    }

    public static void deleteOnlyPetFromOwner(String petId, String ownerId) {
        Owner owner = getOwner(ownerId);
        if (owner == null) {
            System.out.println();
            System.out.println("No owner Found with This Id");
            System.out.println();
        } else {
            Set<String> pets = owner.getPetIdList();
            pets.remove(petId);
        }
    }
}