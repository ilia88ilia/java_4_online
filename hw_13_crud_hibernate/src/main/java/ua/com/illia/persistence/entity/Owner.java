package ua.com.illia.persistence.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owner")
public class Owner extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;


    @ManyToMany(mappedBy = "owners", cascade = CascadeType.ALL)
    private Set<Pet> pets;

    public Owner() {
        super();
        pets = new HashSet<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public boolean setFirstName(String firstName) {
        boolean correctFirstName = false;
        if (firstName.matches(".*\\d.*") || firstName.equals("")) {
            System.out.println("May be it's not a Name )))");
            System.out.println("Please, try Again");
            System.out.println();
        } else {
            this.firstName = firstName;
            correctFirstName = true;
        }
        return correctFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean setLastName(String lastName) {
        boolean correctLastName = false;
        if (lastName.matches(".*\\d.*") || lastName.equals("")) {
            System.out.println("May be it's not a Last Name )))");
            System.out.println("Please, try Again");
            System.out.println();
        } else {
            correctLastName = true;
            this.lastName = lastName;
        }
        return correctLastName;
    }

    public String getEmail() {
        return email;
    }

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
        if (phone.matches("^\\d{10}$")) {
            this.phone = phone;
            correctPhone = true;
        } else {
            System.out.println("It's not a Phone Number");
            System.out.println("Please, try Again");
            System.out.println();
        }
        return correctPhone;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

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
                " Owner {" +
                ", id = '" + getId() + '\'' +
                " firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", email = '" + email + '\'' +
                ", phone = '" + phone + '\'' +
                ", created = '" + getCreated() + '\'' +
                "} ";
    }
}
