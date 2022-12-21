package ua.com.illia;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ClientInterface clientInterface = new ClientInterface();
        clientInterface.start();
    }
}