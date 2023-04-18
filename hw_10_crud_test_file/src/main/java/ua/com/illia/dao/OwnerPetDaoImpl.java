package ua.com.illia.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.com.illia.db.OwnerDB;
import ua.com.illia.db.PetDB;
import ua.com.illia.entity.Owner;
import ua.com.illia.entity.Pet;

import java.io.*;
import java.util.*;

public class OwnerPetDaoImpl implements OwnerPetDao {


    String pathOwners = "owners.json";
    String pathPets = "pets.json";

    public OwnerPetDaoImpl() {
        createJsonFiles();
    }

    private void createJsonFiles() {

        File fileOwners = new File(pathOwners);
        try {
            if (!fileOwners.exists()) {
                fileOwners.createNewFile();
                FileWriter fileWriter = new FileWriter(pathOwners);
                fileWriter.write("{ \"owners\": [] }");
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (IOException e) {
            System.out.println("e = " + e);
        }

        File filePets = new File(pathPets);
        try {
            if (!filePets.exists()) {
                filePets.createNewFile();
                FileWriter fileWriter = new FileWriter(pathPets);
                fileWriter.write("{ \"pets\": [] }");
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (IOException e) {
            System.out.println("e = " + e);
        }
    }

    @Override
    public void createOwner(Owner owner) {
        owner.setId(UUID.randomUUID().toString());
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            OwnerDB ownerDB = gson.fromJson(new FileReader(pathOwners), OwnerDB.class);
            List<Owner> owners = ownerDB.getOwners();
            owners.add(owner);
            ownerDB.setOwners(owners);
            String json = gson.toJson(ownerDB);
            FileWriter fileWriter = new FileWriter(pathOwners);
            fileWriter.write(json);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("e = " + e);
        }

    }

    @Override
    public void updateOwner(Owner owner) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        OwnerDB ownerDB;
        try {
            ownerDB = gson.fromJson(new FileReader(pathOwners), OwnerDB.class);
            List<Owner> owners = ownerDB.getOwners();
            for (int i = 0; i < owners.size(); i++) {
                if (owners.get(i).getId().equals(owner.getId())) {
                    owners.set(i, owner);
                }
            }
            ownerDB.setOwners(owners);
            String json = gson.toJson(ownerDB);
            FileWriter fileWriter = new FileWriter(pathOwners);
            fileWriter.write(json);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("e = " + e);
        }
    }

    public Owner getOwner(String id) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        OwnerDB ownerDB;
        try {
            ownerDB = gson.fromJson(new FileReader(pathOwners), OwnerDB.class);
            List<Owner> owners = ownerDB.getOwners();
            return owners
                    .stream()
                    .filter(owner -> owner.getId().equals(id))
                    .findFirst().get();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteOwner(String ownerId) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            OwnerDB ownerDB = gson.fromJson(new FileReader(pathOwners), OwnerDB.class);
            List<Owner> owners = ownerDB.getOwners();
            Owner o = owners
                    .stream()
                    .filter(owner -> owner.getId().equals(ownerId))
                    .findFirst().get();
            Set<String> petIds = o.getPetIdList();
            for (String petId : petIds) {
                deAttachOwnerFromPet(ownerId, petId);
            }
            owners.remove(o);
            ownerDB.setOwners(owners);
            String json = gson.toJson(ownerDB);
            FileWriter fileWriter = new FileWriter(pathOwners);
            fileWriter.write(json);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("e = " + e);
        }
    }

    @Override
    public Optional<Owner> findOwnerById(String id) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        OwnerDB ownerDB;
        try {
            ownerDB = gson.fromJson(new FileReader(pathOwners), OwnerDB.class);
            List<Owner> owners = ownerDB.getOwners();
            return owners
                    .stream()
                    .filter(owner -> owner.getId().equals(id))
                    .findFirst();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<Owner> findAllOwners() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        OwnerDB ownerDB;
        try {
            ownerDB = gson.fromJson(new FileReader(pathOwners), OwnerDB.class);
            return ownerDB.getOwners();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createPet(Pet pet) {
        pet.setId(UUID.randomUUID().toString());
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            PetDB petDB = gson.fromJson(new FileReader(pathPets), PetDB.class);
            List<Pet> pets = petDB.getPets();
            pets.add(pet);
            petDB.setPets(pets);
            String json = gson.toJson(petDB);
            FileWriter fileWriter = new FileWriter(pathPets);
            fileWriter.write(json);
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("e = " + e);
        }
    }

    @Override
    public void updatePet(Pet pet) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PetDB petDB;
        try {
            petDB = gson.fromJson(new FileReader(pathPets), PetDB.class);
            List<Pet> pets = petDB.getPets();
            for (int i = 0; i < pets.size(); i++) {
                if (pets.get(i).getId().equals(pet.getId())) {
                    pets.set(i, pet);
                }
            }
            petDB.setPets(pets);
            String json = gson.toJson(petDB);
            FileWriter fileWriter = new FileWriter(pathPets);
            fileWriter.write(json);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("e = " + e);
        }
    }

    @Override
    public void deletePet(String petId) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            PetDB petDB = gson.fromJson(new FileReader(pathPets), PetDB.class);
            List<Pet> pets = petDB.getPets();
            Pet p = pets
                    .stream()
                    .filter(pet -> pet.getId().equals(petId))
                    .findFirst().get();
            Set<String> ownerIds = p.getOwnerIdList();
            for (String ownerId : ownerIds) {
                deAttachOwnerFromPet(ownerId, petId);
            }
            pets.remove(p);
            petDB.setPets(pets);
            String json = gson.toJson(petDB);
            FileWriter fileWriter = new FileWriter(pathPets);
            fileWriter.write(json);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("e = " + e);
        }
    }


    @Override
    public Optional<Pet> findPetById(String id) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PetDB petDB;
        try {
            petDB = gson.fromJson(new FileReader(pathPets), PetDB.class);
            List<Pet> pets = petDB.getPets();
            return pets
                    .stream()
                    .filter(pet -> pet.getId().equals(id))
                    .findFirst();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<Pet> findAllPets() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PetDB petDB;
        try {
            petDB = gson.fromJson(new FileReader(pathPets), PetDB.class);
            return petDB.getPets();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<Owner> findOwnerByPetId(String petId) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            PetDB petDB = gson.fromJson(new FileReader(pathPets), PetDB.class);
            List<Pet> pets = petDB.getPets();
            Pet p = pets
                    .stream()
                    .filter(pet -> pet.getId().equals(petId))
                    .findFirst().get();
            Set<String> ownersIds = p.getOwnerIdList();
            List<Owner> owners = new ArrayList<>();
            for (String ownerId : ownersIds) {
                Owner owner = getOwner(ownerId);
                if (owner != null) {
                    owners.add(owner);
                }
            }
            return owners;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void attachOwnerToPet(String ownerId, String petId) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            PetDB petDB = gson.fromJson(new FileReader(pathPets), PetDB.class);
            List<Pet> pets = petDB.getPets();
            for (Pet pet : pets) {
                if (pet.getId().equals(petId)) {
                    pet.getOwnerIdList().add(ownerId);
                }
            }
            petDB.setPets(pets);
            String json = gson.toJson(petDB);
            FileWriter fileWriter = new FileWriter(pathPets);
            fileWriter.write(json);
            fileWriter.flush();
            fileWriter.close();
            OwnerDB ownerDB = gson.fromJson(new FileReader(pathOwners), OwnerDB.class);
            List<Owner> owners = ownerDB.getOwners();
            for (Owner owner : owners) {
                if (owner.getId().equals(ownerId)) {
                    owner.getPetIdList().add(petId);
                }
            }
            ownerDB.setOwners(owners);
            String js = gson.toJson(ownerDB);
            FileWriter fw = new FileWriter(pathOwners);
            fw.write(js);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            System.out.println("e = " + e);
        }
    }

    @Override
    public void deAttachOwnerFromPet(String ownerId, String petId) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            PetDB petDB = gson.fromJson(new FileReader(pathPets), PetDB.class);
            List<Pet> pets = petDB.getPets();
            for (Pet p : pets) {
                if (p.getId().equals(petId)) {
                    p.getOwnerIdList().remove(ownerId);
                }
            }
            petDB.setPets(pets);
            String json = gson.toJson(petDB);
            FileWriter fileWriter = new FileWriter(pathPets);
            fileWriter.write(json);
            fileWriter.flush();
            fileWriter.close();
            OwnerDB ownerDB = gson.fromJson(new FileReader(pathOwners), OwnerDB.class);
            List<Owner> owners = ownerDB.getOwners();
            for (Owner o : owners) {
                if (o.getId().equals(ownerId)) {
                    o.getPetIdList().remove(petId);
                }
            }
            ownerDB.setOwners(owners);
            String js = gson.toJson(ownerDB);
            FileWriter fw = new FileWriter(pathOwners);
            fw.write(js);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            System.out.println("e = " + e);
        }
    }

    @Override
    public boolean existByEmail(String email) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        OwnerDB ownerDB;
        try {
            ownerDB = gson.fromJson(new FileReader(pathOwners), OwnerDB.class);
            List<Owner> owners = ownerDB.getOwners();
            return owners.stream().anyMatch(owner -> owner.getEmail().equals(email));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}