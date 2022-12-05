package main.java.previousYear;

import java.util.Scanner;
import java.lang.*;

public class day2 {
    public static void main(String[] args) {
//        part1();
        part2();
    }
    public static void part1() {
        System.out.println("Paste dir and num input and type exit to exit");
        Scanner scanner = new Scanner(System.in);
        String startDir = scanner.nextLine();
        int x = 0;
        int y = 0;
        while (scanner.hasNextLine() && !startDir.equals("exit") && !startDir.equals("")) {
            char front = startDir.charAt(0);
            if (front == ('f')) {
                x += Integer.parseInt(String.valueOf(startDir.charAt(8)));
            } else if (front == 'd') {
                y += Integer.parseInt(String.valueOf(startDir.charAt(5)));
            } else if (front == 'u') {
                y -= Integer.parseInt(String.valueOf(startDir.charAt(3)));
            }
            startDir = scanner.nextLine();
            if (startDir == "exit") {
                break;
            }
        }
        scanner.close();
        System.out.println(x*y);
    }

    public static void part2() {
        System.out.println("Paste dir and num input and type exit to exit");
        Scanner scanner = new Scanner(System.in);
        String startDir = scanner.nextLine();
        int xHorizontal = 0;
        int yVertical = 0;
        int aim = 0;
        while (scanner.hasNextLine() && !startDir.equals("exit") && !startDir.equals("")) {
            char front = startDir.charAt(0);
            if (front == ('f')) {
                xHorizontal += Integer.parseInt(String.valueOf(startDir.charAt(8)));
                // It increases your depth by your aim multiplied by X.
                yVertical += (aim*Integer.parseInt(String.valueOf(startDir.charAt(8))));
            } else if (front == 'd') {
                aim += Integer.parseInt(String.valueOf(startDir.charAt(5)));
            } else if (front == 'u') {
                aim -= Integer.parseInt(String.valueOf(startDir.charAt(3)));
            }
            startDir = scanner.nextLine();
            if (startDir == "exit") {
                break;
            }
        }
        scanner.close();
        System.out.println(xHorizontal*yVertical);
    }
}
