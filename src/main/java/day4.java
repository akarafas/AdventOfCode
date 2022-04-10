package main.java;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class day4 {
    public static void main(String[] args) {
//        part1();
        part2();
    }
    public static void part1() {
        // collect list of bingo nums to call out and bingo cards
        int countInc = 0;
        Scanner scanner = new Scanner(System.in);
        String bingoNumsString = scanner.nextLine();
        String[] bingoNums = bingoNumsString.split(",");
        ArrayList<String[]> bingoCards = new ArrayList<>();
        String bingoIntake = "";
        while (scanner.hasNextLine() && !bingoIntake.equals("exit")) {
            bingoIntake = scanner.nextLine();
            if (bingoIntake.equals("exit")) {
                break;
            } else if (bingoIntake.strip().isEmpty()) {
                continue;
            } else {
                bingoCards.add(bingoIntake.strip().split(" +"));
            }
        }
        scanner.close();

        int[] winningCounts = new int[bingoCards.size()/5];
        int puzzleWinnerNum = -1;
        int bingoNumsWinningNum = 0;
        for (int n = 0; n < bingoNums.length; n++) {
            for (int i = 0; i < bingoCards.size(); i++) {
                for (int j = 0; j < 5; j++) {
                    if (bingoCards.get(i)[j].equals(bingoNums[n])) {
                        bingoCards.get(i)[j] = "-1";
                        int winningSpot = checkWin(bingoCards);
                        if (winningSpot != -2 && winningCounts[winningSpot / 5] == 0) {
                            winningCounts[winningSpot / 5] = n;
                            puzzleWinnerNum = i;
                            bingoNumsWinningNum = Integer.parseInt(bingoNums[n]);
                            // add win part
                            System.out.println("bingo");
                            puzzleWinnerNum = (puzzleWinnerNum / 5)*5;
                            int winningSum = 0;
                            for (int x = 0; x < 5; x++) {
                                for (int z = 0; z < 5; z++) {
                                    if (bingoCards.get(x+puzzleWinnerNum)[z] != "-1") {
                                        winningSum += Integer.parseInt(bingoCards.get(x+puzzleWinnerNum)[z]);
                                    }
                                }
                            }
                            System.out.println(winningSum);
                            System.out.println(winningSum*bingoNumsWinningNum);
                            return;
                        }
                    }
                }
            }
        }
    }

    public static int checkWin(ArrayList<String[]> bingoCards) {
        // horizontal check
        for (int i = 0; i < bingoCards.size(); i++) {
            int sum = 0;
            for (int j = 0; j < 5; j++) {
                if (bingoCards.get(i)[j].equals("-1")) {
                    sum -= 1;
                }
            }
            if (sum == -5) {
                return i;
            }
        }
        // vertical check
        for (int n = 0; n < bingoCards.size() / 5; n++) {
            for (int i = 0; i < 5; i++) {
                int sum = 0;
                for (int j = 0; j < 5; j++) {
                    if (bingoCards.get(j+(n*5))[i].equals("-1")) {
                        sum -= 1;
                    }
                }
                if (sum == -5) {
                    return (i+(n*5));
                }
            }
        }
        return -2;
    }

    public static void part2() {
        // collect list of bingo nums to call out and bingo cards
        int countInc = 0;
        Scanner scanner = new Scanner(System.in);
        String bingoNumsString = scanner.nextLine();
        String[] bingoNums = bingoNumsString.split(",");
        ArrayList<String[]> bingoCards = new ArrayList<>();
        String bingoIntake = "";
        while (scanner.hasNextLine() && !bingoIntake.equals("exit")) {
            bingoIntake = scanner.nextLine();
            if (bingoIntake.equals("exit")) {
                break;
            } else if (bingoIntake.strip().isEmpty()) {
                continue;
            } else {
                bingoCards.add(bingoIntake.strip().split(" +"));
            }
        }
        scanner.close();

        int[] winningCounts = new int[bingoCards.size()/5];
        int puzzleWinnerNum = -1;
        int bingoNumsWinningNum = 0;
        int numBingoWins = 0;
        for (int n = 0; n < bingoNums.length; n++) {
            for (int i = 0; i < bingoCards.size(); i++) {
                for (int j = 0; j < 5; j++) {
                    if (bingoCards.get(i)[j].equals(bingoNums[n])) {
                        bingoCards.get(i)[j] = "-1";
                        int winningSpot = checkWin(bingoCards);
                        if (winningSpot != -2 && winningCounts[winningSpot / 5] == 0) {
                            winningCounts[winningSpot / 5] = n;
                            puzzleWinnerNum = i;
                            bingoNumsWinningNum = Integer.parseInt(bingoNums[n]);
                            // add win part
                            System.out.println("bingo " + bingoNumsWinningNum);
                            numBingoWins++;
                            // if we are on the last board, calculate the wins
                            if (numBingoWins <= bingoCards.size()/5) {
                                puzzleWinnerNum = (puzzleWinnerNum / 5)*5;
                                int winningSum = 0;
                                for (int x = 0; x < 5; x++) {
                                    for (int z = 0; z < 5; z++) {
                                        if (bingoCards.get(x+puzzleWinnerNum)[z] != "-1") {
                                            winningSum += Integer.parseInt(bingoCards.get(x+puzzleWinnerNum)[z]);
                                            bingoCards.get(x+puzzleWinnerNum)[z] = "-3";
                                        } else {
                                            bingoCards.get(x+puzzleWinnerNum)[z] = "-3";
                                        }
                                    }
                                }
                                if (numBingoWins == bingoCards.size()/5) {
                                    System.out.println(winningSum);
                                    System.out.println(winningSum * bingoNumsWinningNum);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
