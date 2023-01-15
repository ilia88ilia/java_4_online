package ua.com.illia.db;

import ua.com.illia.entity.Owner;
import ua.com.illia.entity.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class DbStorage {
    private final List<Owner> owners = new ArrayList<>();
    private final List<Pet> pets = new ArrayList<>();
    private static DbStorage instance;

    private DbStorage() {
    }

    public static DbStorage getInstance() {
        if (instance == null) {
            instance = new DbStorage();
        }
        return instance;
    }

    public void createOwner(Owner owner) {
        owner.setId(generateOwnerId());
        owners.add(owner);
    }

    private String generateOwnerId() {
        String id = UUID.randomUUID().toString();
        if (owners.stream().anyMatch(owner -> owner.getId().equals(id))) {
            return generateOwnerId();
        }
        return id;
    }

    public Owner findOwnerById(String id) {
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

    public boolean existByEmail(String email) {
        return owners.stream().anyMatch(owner -> owner.getEmail().equals(email));
    }

    public List<Owner> findAllOwners() {
        return owners;
    }

    public void createPet(Pet pet) {
        pet.setId(generatePetId());
        pets.add(pet);
    }

    private String generatePetId() {
        String id = UUID.randomUUID().toString();
        if (pets.stream().anyMatch(pet -> pet.getId().equals(id))) {
            return generatePetId();
        }
        return id;
    }

    public Pet findPetById(String id) {
        Pet pet = null;
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i) != null) {
                if (pets.get(i).getId().equals(id)) {
                    pet = pets.get(i);
                    break;
                }
            }
        }
        return pet;
    }

    public List<Pet> findAllPets() {
        return pets;
    }

    public void attachOwnerToPet(String ownerId, String petId) {
        Pet pet = findPetById(petId);
        Owner owner = findOwnerById(ownerId);
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
        } else {
            System.out.println();
            System.out.println("No owner Found with This Id");
            System.out.println();
        }
    }

    public List<Owner> findOwnersByPet(String id) {
        Pet pet = findPetById(id);
        Set<String> ownersIds = pet.getOwnerIdList();
        List<Owner> owners = new ArrayList<>();
        for (String ownerId : ownersIds) {
            Owner owner = findOwnerById(ownerId);
            if (owner != null) {
                owners.add(owner);
            }
        }
        return owners;
    }

    public void deAttachOwnerFromPet(String ownerId, String petId) {
        Owner owner = findOwnerById(ownerId);
        if (owner == null) {
            System.out.println();
            System.out.println("No owner Found with This Id");
            System.out.println();
        } else {
            Set<String> pets = owner.getPetIdList();
            pets.remove(petId);
            Pet pet = findPetById(petId);
            if (pet == null) {
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

    public void deleteOwner(String id) {
        Owner owner = findOwnerById(id);
        if (owner == null) {
            System.out.println();
            System.out.println("No owner Found with This Id");
            System.out.println();
        } else {
            Set<String> petIds = owner.getPetIdList();
            for (String petId : petIds) {
                deleteOwnerFromPet(id, petId);
            }
            owners.remove(owner);
            System.out.println();
            System.out.println("The owner Deleted");
            System.out.println();
        }
    }

    public void deleteOwnerFromPet(String ownerId, String petId) {
        Pet pet = findPetById(petId);
        if (pet == null) {
            System.out.println();
            System.out.println("No pet groups Found with This Id");
            System.out.println();
        } else {
            Set<String> owners = pet.getOwnerIdList();
            owners.remove(ownerId);
        }
    }

    public void deletePet(String id) {
        Pet pet = findPetById(id);
        if (pet == null) {
            System.out.println();
            System.out.println("No pet groups Found with This Id");
            System.out.println();
        } else {
            Set<String> ownerIds = pet.getOwnerIdList();
            for (String ownerId : ownerIds) {
                deletePetFromOwner(id, ownerId);
            }
            pets.remove(pet);
            System.out.println();
            System.out.println("The pet group Deleted");
            System.out.println();
        }
    }

    public void deletePetFromOwner(String petId, String ownerId) {
        Owner owner = findOwnerById(ownerId);
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
