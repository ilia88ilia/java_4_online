package ua.com.illia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ClientInterface {

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select Your option");
        String select;
        menu();
        while ((select = reader.readLine()) != null) {
            crud(reader, select);
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("///enter1");
        System.out.println("///enter2");
        System.out.println("///enter3");
        System.out.println("///enter4");
        System.out.println();
    }

    private void crud(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" : create(reader); break;
            case "2" : findByEmail(reader); break;
            case "3" : deleteByEmail(reader); break;
            case "4" : findAll(); break;
            case "0" : stop(); break;
         }
         menu();
    }

    private void create(BufferedReader reader) throws IOException {
        System.out.println("Create client");
        System.out.println("Please, enter your first name");
        String firstName = reader.readLine();
        System.out.println("Please, enter your last name");
        String lastName = reader.readLine();
        System.out.println("Please, enter your email");
        String email = reader.readLine();
        Client client = new Client();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setEmail(email);
        ClientStorage.addClient(client);

    }
    private void findByEmail(BufferedReader reader) throws IOException {
        System.out.println("Find client by email");
        String email = reader.readLine();
        Client client = ClientStorage.getClient(email);
        System.out.println("client = " + client);
    }

    private void deleteByEmail(BufferedReader reader) throws IOException {
        System.out.println("Delete client by email");
        String email = reader.readLine();
        ClientStorage.deleteClients(email);
    }

    private void findAll() {
        System.out.println("Find all users");
        List<Client> clients = ClientStorage.getClients();
        System.out.println("clients = " + clients);
    }

    private void stop() {
        System.exit(0);
    }
}