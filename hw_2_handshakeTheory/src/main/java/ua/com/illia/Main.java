package ua.com.illia;

import java.util.Random;
public class Main {

    public static void main(String[] args) {
        int count = 1000;
        int handshakeCounter = 0;
        Random random = new Random();
        Test[] totalPerson = new Test[random.nextInt(count)];
        System.out.println("A total of -------- " + totalPerson.length + " ------------ people take part in the test");

        for (int i = 0; i < totalPerson.length; i++) {
            totalPerson[i] = new Test();
            totalPerson[i].number = i;
            random = new Random();
            int result = random.nextInt(2);
            if (result == 0) {
                totalPerson[i].isStupid = true;
            }
            else {
                totalPerson[i].isStupid = false;
                handshakeCounter++;
                if (handshakeCounter <= 6) {
                    int humanCounter = totalPerson[i].number + 1;
                    System.out.println("THE === " + handshakeCounter + " === HANDSHAKE WAS MADE BY A HUMAN NUMBER === " + humanCounter + " ===");
                }
            }
        }
    }
}