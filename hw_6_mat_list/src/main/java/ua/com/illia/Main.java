package ua.com.illia;

import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {

        MatList<Integer> matList = new MatList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            matList.add((i) * random.nextInt(10));
        }
        System.out.println(matList);
    }
}

