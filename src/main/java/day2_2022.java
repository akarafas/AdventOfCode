package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class day2_2022 {
    public static void main(String[] args) {
        part1();
//        part2();
    }

    public static void part1() {
        System.out.println("Paste dir and num input and type exit to exit");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int totalScore = 0;
        while (scanner.hasNextLine() && !line.equals("exit") && line.length()!=0) {
            totalScore += score(line.charAt(0), line.charAt(2));
            line = scanner.nextLine();
            if (line == "exit") {
                break;
            }
        }
        // sort list then add top 3
        scanner.close();
        System.out.println(totalScore);
    }

    public static int score(char opp, char you) {
        // char 0 is opp, char 2 is you
        int score = 0;
        switch (opp) {
            case 'A': //rock
                switch (you) {
                    case 'X': // lose
                        score += (0 + 3); //sciss
                        break;
                    case 'Y': // draw
                        score += (3 + 1); // r
                        break;
                    case 'Z': // win
                        score += (6 + 2); // paper
                        break;
                }
                break;
            case 'B': //p
                switch (you) {
                    case 'X': // lose
                        score += (0 + 1); //rock
                        break;
                    case 'Y': // draw
                        score += (3 + 2); //pap
                        break;
                    case 'Z': // win
                        score += (6 + 3); // sciss
                        break;
                }
                break;
            case 'C': //scis
                switch (you) {
                    case 'X': //lose
                        score += (0 + 2); // pap
                        break;
                    case 'Y': //draw
                        score += (3 + 3); // sciss
                        break;
                    case 'Z': //win
                        score += (6 + 1); //rock
                        break;
                }
                break;
        }
        return score;
    }

}
