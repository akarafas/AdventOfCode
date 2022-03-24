package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day1 {
    public static void main(String[] args) {
//        part1();
//        part2();
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
        ArrayList<Integer> nums = new ArrayList<>();
        int countInc = 0;
        Scanner scanner = new Scanner(System.in);
        nums.add(scanner.nextInt());
        while (scanner.hasNextInt()) {
            nums.add(scanner.nextInt());
        }
        scanner.close();
        int i = 0;
        while (i + 3 < nums.size()) {
            if (nums.get(i) + nums.get(i+1) + nums.get(i+2) < nums.get(i+1) + nums.get(i+2) + nums.get(i+3)) {
                countInc++;
            }
            i++;
        }
        System.out.println(countInc);
    }
}
