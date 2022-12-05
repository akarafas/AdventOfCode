package main.java;

import java.util.*;

import static java.lang.System.in;

public class day3_2022 {
    public static void main(String[] args) {
//        part1();
        part2();
    }

    public static void part1() {
        System.out.println("Paste dir and num input and type exit to exit");
        Scanner scanner = new Scanner(in);
        String line = scanner.nextLine();
        char[] scoreIndex = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        List<Character> scoreList = new ArrayList<Character>();
        for (char c: scoreIndex) {
            scoreList.add(c);
        }
        int totalScore = 0;
        while (scanner.hasNextLine() && !line.equals("exit") && line.length()!=0) {
            Map<Character, Integer> doubles = new HashMap<Character, Integer>();
            //            String firstCompartment = line.substring(0,(line.length()-1)/2);
            //            String secondCompartment = line.substring((line.length()-1)/2, line.length()-1);
            for (int i = 0; i<line.length(); i++) {
                char letter = line.charAt(i);
                if (i <= Math.floorDiv(line.length()-1,2)) {
                    if (doubles.containsKey(letter)) {
                        doubles.put(letter, doubles.get(letter)+1);
                    } else {
                        doubles.put(letter, 1);
                    }
                } else {
                    if (doubles.containsKey(letter)) {
                        // add to total score
                        int score = scoreList.indexOf(letter) + 1;
                        totalScore += score;
                        break;
                    }
                }
            }
            line = scanner.nextLine();
            if (line == "exit") {
                break;
            }
        }
        // sort list then add top 3
        scanner.close();
        System.out.println(totalScore);
    }

    public static void part2() {
        System.out.println("Paste dir and num input and type exit to exit");
        Scanner scanner = new Scanner(in);
        String line = scanner.nextLine();
        char[] scoreIndex = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        List<Character> scoreList = new ArrayList<Character>();
        for (char c: scoreIndex) {
            scoreList.add(c);
        }
        int totalScore = 0;
        int lineCount = 0;
        Map<Character, Integer> group1 = new HashMap<Character, Integer>();
        Map<Character, Integer> group2 = new HashMap<Character, Integer>();
        while (scanner.hasNextLine() && !line.equals("exit") && line.length()!=0) {

            for (int i = 0; i<line.length(); i++) {
                char letter = line.charAt(i);
                if (lineCount == 0) {
                    if (group1.containsKey(letter)) {
                        group1.put(letter, group1.get(letter) + 1);
                    } else {
                        group1.put(letter, 1);
                    }
                } else if (lineCount == 1){
                    if (group2.containsKey(letter)) {
                        group2.put(letter, group2.get(letter) + 1);
                    } else {
                        group2.put(letter, 1);
                    }
                } else {
                    if (group1.containsKey(letter) && group2.containsKey(letter)) {
                        // add to total score
                        int score = scoreList.indexOf(letter) + 1;
                        totalScore += score;
                        group1.clear();
                        group2.clear();
                        break;
                    }
                }
            }
            line = scanner.nextLine();
            lineCount += 1;
            if (lineCount > 2) {
                lineCount = 0;
            }
            if (line == "exit") {
                break;
            }
        }
        // sort list then add top 3
        scanner.close();
        System.out.println(totalScore);
    }

}
