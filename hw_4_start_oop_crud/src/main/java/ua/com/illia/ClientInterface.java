package ua.com.illia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ClientInterface {
    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Discaunt Data Base");
        String select;
        menu();
        while ((select = reader.readLine()) != null) {
            crud(reader,select);
        }
    }
    public void menu() {
        System.out.println();
        System.out.println("Add to Client Data Base Enter 1");
        System.out.println("Show all Clients of This Store Enter 2");
        System.out.println("Find The Client by Email Enter 3");
        System.out.println("Delete User From Data Base Enter 4");
        System.out.println("Exit Enter 0");
        System.out.println();
    }
    private void crud(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" : create(reader); break;
            case "2" : findAll(); break;
            case "3" : findByEmail(reader); break;
            case "4" : deleteClientByEmail(reader); break;
            case "0" : stop(); break;
        }
        menu();
    }
    private void create(BufferedReader reader) throws IOException {

        Client client = new Client();

        System.out.println("Enter the First Name");
        String firstName = reader.readLine();
        boolean correctFirstName = client.setFirstName(firstName);
        while(!correctFirstName) {
            firstName = reader.readLine();
            correctFirstName = client.setFirstName(firstName);
        }

        System.out.println("Enter the Last Name");
        String lastName = reader.readLine();
        boolean correctLastName = client.setLastName(lastName);
        while(!correctLastName) {
            lastName = reader.readLine();
            correctLastName = client.setLastName(lastName);
        }

        System.out.println("Enter the Email");
        String email = reader.readLine();
        boolean correctEmail = client.setEmail(email);
        while(!correctEmail) {
            email = reader.readLine();
            correctEmail = client.setEmail(email);
        }

        System.out.println("Enter the Phone After +38");
        System.out.println("For Example : 0675476432");
        String phone = reader.readLine();
        boolean corrrectPhoneNumber = client.setPhone(phone);
        while (!corrrectPhoneNumber) {
            phone = reader.readLine();
            corrrectPhoneNumber = client.setPhone(phone);
        }

        ClientStorage.addClient(client);

    }
    private void findAll() {
        Client[] clients = ClientStorage.getClients();
        System.out.println("Clients of Data Base " + Arrays.toString(clients));

    }
    private void findByEmail(BufferedReader reader) throws IOException {
        System.out.println("Find Client by Email");
        System.out.println("Enter the Client Email");
        String email = reader.readLine();
        Client client = ClientStorage.getClient(email);
        System.out.println(client);
    }
    private void deleteClientByEmail(BufferedReader reader) throws IOException {
        System.out.println("Enter the Email of the Client to be Deleted");
        String email = reader.readLine();
        ClientStorage.deleteClient(email);
    }
    private void stop() { System.exit(0); }
}