package ua.com.illia;

public class WordParser implements Comparable<WordParser> {

    private String word;
    private int rating;
    private Long count;
    private long percentage;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getPercentage() {
        return percentage;
    }

    public void setPercentage(long percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "WordStatistics{" +
                "word='" + word + '\'' +
                ", rating=" + rating +
                ", count=" + count +
                ", percentage=" + percentage +
                '}';
    }

    @Override
    public int compareTo(WordParser o) {
        int compareToByCount = this.count.compareTo(o.getCount());
        if (compareToByCount == 0) {
            return this.word.compareTo(o.getWord());
        }
        return compareToByCount;
    }
}
