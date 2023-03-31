package ua.com.illia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("========pathfinder===pathfinder===WELCOME TO PATH_FINDER========");
        String select;
        menu();
        while ((select = reader.readLine()) != null) {
            menuItems(select);
        }
    }

    public void menu() {
        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~--~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
        System.out.println("-~-~-~-~-~-TO START With Template File.....................Enter 1");
        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~--~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~--~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
        System.out.println("-~-~-~-~-~-TO START With Ukraine Cities File...............Enter 2");
        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~--~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~--~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~--~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
        System.out.println("....................Exit....................Enter 0...............");
        System.out.println("---make your choice under this line-------------------------------");
    }

    public void menuItems(String select) throws IOException {
        FileHandler fileHandler = new FileHandler();
        if (select.equals("1") || select.equals("2")) {
            fileHandler.inputFileChanger(select);
            menu();
        } else if (select.equals("0")) {
            exit();
        } else {
            menu();
        }
    }

    public void exit() {
        System.exit(0);
    }
}
