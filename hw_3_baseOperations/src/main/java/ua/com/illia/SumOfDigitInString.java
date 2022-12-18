package ua.com.illia;

import java.io.BufferedReader;
import java.io.IOException;

public class SumOfDigitInString {
    public static void enterString(BufferedReader reader) throws IOException {
        System.out.println("Hello!!! Enter any set of characters without a space ");
        System.out.println("and the program will calculate the sum of all the numbers entered )))");
        System.out.println("For example:     1w4tt!7      ");
        String stringToParseInput = reader.readLine();
        char[] chars = stringToParseInput.toCharArray();
        int summ = 0;
        for(int i = 0; i < chars.length; i++){
            int symbol = Character.digit(chars[i], 10);
            if (symbol > 0 && symbol < 10) {
                summ = summ + symbol;
            }
        }
        System.out.println("The sum of all the numbers in your row ");
        System.out.println("======= " + summ + " =======");
    }

}