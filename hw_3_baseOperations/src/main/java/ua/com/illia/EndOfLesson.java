package ua.com.illia;

import java.io.BufferedReader;
import java.io.IOException;
public class EndOfLesson {
    public static void enterString(BufferedReader reader) throws IOException{
            System.out.println("Hello!!! Enter the number of lesson from 1 to 10");
            System.out.println("For example:     3      ");
            String numOfLessonInput=reader.readLine();
        switch (numOfLessonInput) {
            case "1":
                System.out.println("The lesson number 1 ends at 9 : 45");
                break;
            case "2":
                System.out.println("The lesson number 2 ends at 10 : 35");
                break;
            case "3":
                System.out.println("The lesson number 3 ends at 11 : 35");
                break;
            case "4":
                System.out.println("The lesson number 4 ends at 12 : 25");
                break;
            case "5":
                System.out.println("The lesson number 5 ends at 13 : 25");
                break;
            case "6":
                System.out.println("The lesson number 6 ends at 14 : 25");
                break;
            case "7":
                System.out.println("The lesson number 7 ends at 15 : 15");
                break;
            case "8":
                System.out.println("The lesson number 8 ends at 16 : 15");
                break;
            case "9":
                System.out.println("The lesson number 9 ends at 17 : 05");
                break;
            case "10":
                System.out.println("The lesson number 10 ends at 17 : 55");
                break;
        }
    }
}