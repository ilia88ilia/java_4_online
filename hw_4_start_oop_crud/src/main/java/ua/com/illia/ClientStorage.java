package ua.com.illia;

public class ClientStorage {

    private static Client[] clients = new Client[1];

    private ClientStorage() { }

    public static int count = 0;

    private static void biggerArray() {
        Client[] newClients = new Client[clients.length + 1];
        for (int i = 0; i < clients.length; i++) {
            newClients[i] = clients[i];
        }
        clients = newClients;
    }

    public static void addClient(Client client) {
        for (int i = 0; i < clients.length; i++) {
            if (count == clients.length) {
                biggerArray();
            } else {
                clients[count] = client;
                count++;
                break;
            }
        }
    }

    public static Client[] getClients() {
        return clients;
    }

    public static Client getClient(String email) {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].getEmail().equals(email)) {
                return clients[i];
            }
        }
        System.out.println("There is no User With Such Email");
        return null;
    }

    public static void deleteClient(String email) {
        Boolean delete = false;
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].getEmail().equals(email)) {
                delete = true;
                break;
            }
        }
        if (!delete) { System.out.println("There is no User With Such Email"); }
        if (delete) {
            if (clients.length != 1) {
                int newCount = 0;
                Client[] newClients = new Client[clients.length - 1];
                for (int i = 0; i < clients.length; i++) {
                    if (!clients[i].getEmail().equals(email)) {
                        newClients[newCount] = clients[i];
                        newCount++;
                    }
                }
                System.out.println("The Client has Been Deleted");
                clients = newClients;
            } else {
                System.out.println("The Last Client has Been Deleted");
                System.out.println("Now the Database is Empty");
                System.out.println("To Fill in the Database, Start the Programme Again");
                {
                    System.exit(0);
                }
            }
        }
    }
}