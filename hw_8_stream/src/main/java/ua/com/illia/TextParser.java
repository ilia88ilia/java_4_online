package ua.com.illia;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TextParser {
    public static List<WordParser> wordParsers(String text) {
        String[] textArray = text.replace(".", " ").toLowerCase().trim().split("\\s+");
        long[] countPreviousElement = {0};
        int[] rating = {0};
        return Arrays.stream(textArray)
                .distinct()
                .map(currentWord -> {
                    WordParser wordParser = new WordParser();
                    wordParser.setWord(currentWord);
                    wordParser.setCount(Arrays.stream(textArray)
                            .filter(word -> word.equals(currentWord))
                            .count());
                    long percentage = Math.round((100.0 * wordParser.getCount() / textArray.length));
                    wordParser.setPercentage(percentage);
                    return wordParser;
                })
                .sorted(Comparator.reverseOrder())
                .toList().stream()
                .map(currentWordParser -> {
                    if (countPreviousElement[0] == 0) {
                        rating[0] = rating[0] + 1;
                        currentWordParser.setRating(rating[0]);
                        countPreviousElement[0] = currentWordParser.getCount();
                    } else {
                        if (currentWordParser.getCount() < countPreviousElement[0]) {
                            rating[0]++;
                            currentWordParser.setRating(rating[0]);
                            countPreviousElement[0] = currentWordParser.getCount();
                        } else {
                            currentWordParser.setRating(rating[0]);
                        }
                    }
                    return currentWordParser;
                })
                .toList();
    }

    public static void table(List<WordParser> wordParserList) {
        String cell = "|%1$-15s|%2$-15s|%3$-15s|%4$-15s|\n";
        String cellBottom = "_______________";
        System.out.println(" _______________________________________________________________");
        System.out.format(cell, "", "Rating", "Count", "Percentage");
        System.out.format(cell, cellBottom, cellBottom, cellBottom, cellBottom);
        wordParserList.stream()
                .forEach(element -> {
                    System.out.format(cell, element.getWord(), element.getRating(), element.getCount(), element.getPercentage());
                    System.out.format(cell, cellBottom, cellBottom, cellBottom, cellBottom);
                });
    }
}
