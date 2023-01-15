package ua.com.illia.entity;

import java.util.HashSet;
import java.util.Set;

public class Pet extends BaseEntity {
    private String name;
    private Set<String> ownerIdList = new HashSet<>();

    public String getName() { return name; }

    public boolean setName(String name) {
        boolean correctName = false;
        if (name.matches(".*\\d.*")) {
            System.out.println("May be it's not a Name )))");
            System.out.println("Please, try Again");
            System.out.println();
        } else {
            this.name = name;
            correctName = true;
        }
        return correctName;
    }
    public Set<String> getOwnerIdList() { return ownerIdList; }


    @Override
    public String toString() {
        return '\n' +
                " PetGroups { " +
                " name = '" + name + '\'' +
                ", id = '" + getId() + '\'' +
                ", Owners id = '" + ownerIdList + '\'' +
                " } ";
    }
}
