package ua.com.illia;

import java.util.ArrayList;
import java.util.List;

public class ClientStorage {

    private static List<Client> clients = new ArrayList<>();

    String[] array = new String[3];
    private static Client[] clientsArray;

    private ClientStorage() { }

    public static List<Client> getClients() {
        return clients;
    }

    public static void addClient (Client client) { clients.add(client); }

    public static void deleteClients(String email) {
        clients.removeIf(
                client -> client.getEmail().equals(email)
        );
    }

    public static Client getClient (String email) {
        return clients.
                stream().
                filter(client -> client.getEmail().equals(email)).
                findFirst()
                .get();
    }
}
