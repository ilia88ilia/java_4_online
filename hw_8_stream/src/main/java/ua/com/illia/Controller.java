package ua.com.illia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    public void start() {
        menu();
        try {
            result();
        } catch (IOException e) {
            System.out.println("Something Wrong...");
            System.out.println("Try Again");
        }
    }

    public void menu() {
        System.out.println();
        System.out.println("If You Want To Parse A Default Text ..................................Enter 0");
        System.out.println();
        System.out.println("If You Want To Parse Your Text ................Enter Your Text Under The Line");
    }

    public void result() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text;
        while (true) {
            System.out.println();
            System.out.println("_____________________________________________________________________________");
            text = reader.readLine();
            if (text.equals("0")) {
                System.out.println();
                System.out.println("This is some dummy text. This is dummy dummy text. Dummy text");
                String defaultText = "This is some dummy text. This is dummy dummy text. Dummy text";
                TextParser.table(TextParser.wordParsers(defaultText));
                System.out.println();
                break;
            }
            if (text.equals("")) {
                System.out.println();
                System.out.println("It's Nothing)))");
                System.out.println();
                System.out.println("I need a text!!!");
                menu();
            } else {
                TextParser.table(TextParser.wordParsers(text));
                break;
            }
        }
    }
}

