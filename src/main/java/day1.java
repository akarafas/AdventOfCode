package main.java;

import java.util.Scanner;

public class day1 {
    public static void main(String[] args) {
        part1();
    }
    public static void part1() {
        System.out.println("Paste number input and type any char to exit");
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
    public static void part2() {
        // todo;
    }
}
