package main.java;

import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class day6_2022 {
    public static void main(String[] args) {
//        part1();
        part2();
    }

    public static void part1() {
        System.out.println("Paste dir and num input and type exit to exit");
        Scanner scanner = new Scanner(in);
        int count = 0;
        String line = scanner.nextLine();
        // count chars before 4 diff chars (store 4... keep counting)
        for (int i = 0; i < line.length() - 4; i++) {
            char[] chars = new char[4];
            line.getChars(i, i + 4, chars, 0);
            if (!checkDuplicates(chars)) {
                count = i + 4;
                break;
            }
        }
        scanner.close();
        System.out.println(count);
    }
    public static void part2() {
        System.out.println("Paste dir and num input and type exit to exit");
        Scanner scanner = new Scanner(in);
        int count = 0;
        String line = scanner.nextLine();
        // count chars before 14 diff chars (store 14... keep counting)
        for (int i = 0; i < line.length() - 14; i++) {
            char[] chars = new char[14];
            line.getChars(i, i + 14, chars, 0);
            if (!checkDuplicates(chars)) {
                count = i + 14;
                break;
            }
        }
        scanner.close();
        System.out.println(count);
    }

    private static boolean checkDuplicates(char[] chars) {
        Arrays.sort(chars);
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return true;
            }
        }
        return false;
    }

}
