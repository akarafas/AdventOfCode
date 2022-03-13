package main.java;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World, Java app");
        Scanner scanner = new Scanner(System.in);
        int startInt = scanner.nextInt();
        int countInc = 0;
        while (scanner.hasNextInt()) {
            int nextInt = scanner.nextInt();
            if (startInt < nextInt) {
                countInc++;
            }
            startInt = nextInt;
        }
        scanner.close();
        System.out.println(countInc);
    }
}
