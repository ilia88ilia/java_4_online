package ua.com.illia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println();
        System.out.println("Select what do you want yo do: ");
        String select;
        operationList();
        while ((select = reader.readLine()) != null) {
            operationMenu(reader, select);
        }
    }
    private void operationList() {
        System.out.println();
        System.out.println("###If you want to know the SUM OF DIGIT in your string ------------ Enter 1");
        System.out.println();
        System.out.println("###If you want to sort out duplicate characters in a string ------- Enter 2");
        System.out.println();
        System.out.println("###If you want to know what time the lesson ends ------------------ Enter 3");
        System.out.println();
        System.out.println("###If you want to EXIT ---------------------------------------------Enter 0");
    }
    public void operationMenu(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1": SumOfDigitInString.enterString(reader); break;
            case "2": SymbolSorter.enterString(reader); break;
            case "3": EndOfLesson.enterString(reader); break;
            case "0" : stop(); break;
        }
        operationList();
    }

    private void stop() {
        System.out.println("Thank you for your time!!!");
        System.exit(0);
    }
}