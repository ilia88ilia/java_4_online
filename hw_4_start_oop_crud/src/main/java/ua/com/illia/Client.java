package  ua.com.illia;

public class Client {
    private String firstName;
    private String lastName;
    private String email;

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        if (firstName.matches(".*\\d.*")) {
            System.out.println("It's not your name )))");
            System.out.println("Please, try again");
        } else {
            this.firstName = firstName;
        }
    }
    public String getLastName() { return lastName; }

    public void setLastName(String lastName) {
        if (lastName.matches(".*\\d.*")) {
            System.out.println("It's not your name )))");
            System.out.println("Please, try again");
        } else {
            this.lastName = lastName;
        }
    }
    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Client {" +
                "first name = '" + firstName + '\'' +
                ", last name = '" + lastName + '\'' +
                ", email = " + email + '\'' +
                '}';
    }

}