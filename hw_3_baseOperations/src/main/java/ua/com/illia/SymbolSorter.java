package ua.com.illia;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class SymbolSorter {
    public static void enterString(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("Hello!!! Enter a random sequence of characters ");
        System.out.println("For example:     1w4tt!7      ");
        String stringToSortInput = reader.readLine();
        char[] chars = stringToSortInput.toCharArray();
        Arrays.sort(chars);
        String s = String.copyValueOf(chars);
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                System.out.println(chars[i] + " - " + (s.lastIndexOf(chars[i]) - s.indexOf(chars[i]) + 1));
                i += (s.lastIndexOf(chars[i]) - s.indexOf(chars[i]));
            }
        }
    }
}