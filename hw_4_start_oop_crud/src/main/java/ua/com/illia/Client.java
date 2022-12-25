package  ua.com.illia;

public class Client {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public String getFirstName() { return firstName; }

    public boolean setFirstName(String firstName) {
        boolean correctFirstName = false;
        if (firstName.matches(".*\\d.*")) {
            System.out.println("May be it's not a Name )))");
            System.out.println("Please, try Again");
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
        }
        return correctEmail;
    }
    public String getPhone() { return phone; }
    public boolean setPhone(String phone) {
        boolean correctPhoneNumber = false;
        if (phone.matches("^\\d{10}$")){
            this.phone = phone;
            correctPhoneNumber = true;
        } else {
            System.out.println("It's not a Phone Number");
            System.out.println("Please, try Again");
        }
        return correctPhoneNumber;
    }
    @Override
    public String toString() {
        return "Client {" +
                "First Name = '" + firstName + '\'' +
                ", Last Name = '" + lastName + '\'' +
                ", Email = " + email + '\'' +
                ", Phone = " + phone + '\'' +
                '}';
    }
}
