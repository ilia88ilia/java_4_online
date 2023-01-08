package ua.com.illia.entity;

import java.util.HashSet;
import java.util.Set;

public class Owner extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Set<String> petIdList = new HashSet<>();

    public String getFirstName() { return firstName; }

    public boolean setFirstName(String firstName) {
        boolean correctFirstName = false;
        if (firstName.matches(".*\\d.*")) {
            System.out.println("May be it's not a Name )))");
            System.out.println("Please, try Again");
            System.out.println();
        } else {
            this.firstName = firstName;
            correctFirstName = true;
        }
        return correctFirstName;
    }

    public String getLastName() { return lastName; }

    public boolean setLastName(String lastName) {
        boolean correctLastName = false;
        if (lastName.matches(".*\\d.*")) {
            System.out.println("May be it's not a Last Name )))");
            System.out.println("Please, try Again");
            System.out.println();
        } else {
            correctLastName = true;
            this.lastName = lastName;
        }
        return correctLastName;
    }

    public String getEmail() { return email; }

    public boolean setEmail(String email) {
        boolean correctEmail = false;
        if (email.matches("^(.+)@(.+)$")) {
            this.email = email;
            correctEmail = true;
        } else {
            System.out.println("It's not an Email");
            System.out.println("Please, try Again");
            System.out.println();
        }
        return correctEmail;
    }

    public String getPhone() {
        return phone;
    }

    public boolean setPhone(String phone) {
        boolean correctPhone = false;
        if (phone.matches("^\\d{10}$")){
            this.phone = phone;
            correctPhone = true;
        } else {
            System.out.println("It's not a Phone Number");
            System.out.println("Please, try Again");
            System.out.println();
        }
        return correctPhone;
    }

    public Set<String> getPetIdList() { return petIdList; }

    @Override
    public String toString() {
        return '\n' +
                " Owner {" +
                " firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", email = '" + email + '\'' +
                ", phone = '" + phone + '\'' +
                ", id = '" + getId() + '\'' +
                ", Pet Groups = '" + petIdList + '\'' +
                "} ";
    }
}
