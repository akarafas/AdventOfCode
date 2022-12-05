package main.java;

import java.util.*;

import static java.lang.Integer.parseInt;

public class day1_2022 {
    public static void main(String[] args) {
        part1();
//        part2();
    }
    public static void part1() {
        System.out.println("Paste dir and num input and type exit to exit");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int elfCount = 0;
        boolean keepAdding = false;
//        Map<Integer, Integer> calories = new HashMap<Integer, Integer>();
        List<Integer> calories = new ArrayList<Integer>();
        while (scanner.hasNextLine() && !line.equals("exit")) {
            if (line.length() != 0) {
                if (keepAdding) {
                    calories.set(elfCount, calories.get(elfCount) + parseInt(line));
                } else {
                    calories.add(parseInt(line));
                    keepAdding = true;
                }
            } else {
                // next elf
                elfCount+=1;
                keepAdding = false;
            }
            line = scanner.nextLine();
            if (line == "exit") {
                break;
            }
        }
        // sort list then add top 3
        Collections.sort(calories, Collections.reverseOrder());
        scanner.close();
        System.out.println(calories.get(0) + calories.get(1) + calories.get(2));
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
                xHorizontal += parseInt(String.valueOf(startDir.charAt(8)));
                // It increases your depth by your aim multiplied by X.
                yVertical += (aim* parseInt(String.valueOf(startDir.charAt(8))));
            } else if (front == 'd') {
                aim += parseInt(String.valueOf(startDir.charAt(5)));
            } else if (front == 'u') {
                aim -= parseInt(String.valueOf(startDir.charAt(3)));
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
