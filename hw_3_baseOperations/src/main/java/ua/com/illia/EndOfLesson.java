package ua.com.illia;

import java.io.BufferedReader;
import java.io.IOException;
public class EndOfLesson {
    public static void enterString(BufferedReader reader) throws IOException{
            System.out.println("Hello!!! Enter the number of lesson from 1 to 10");
            System.out.println("For example:     7      ");
            int numOfLessonInput = Integer.parseInt(reader.readLine());

            int lessonsTime = numOfLessonInput * 45;

            int restCount = numOfLessonInput - 1;

            int restTime = (restCount / 2) * 5 + (restCount / 2) * 15 + (restCount % 2) * 5;

            int minutes = lessonsTime + restTime;

            int hours = 9 + minutes/60;

            int minutesFromAnHour = minutes%60;

            System.out.println("The lesson number " + numOfLessonInput + " ends at " + hours + " : " + minutesFromAnHour);
    }
}