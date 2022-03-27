package main.java;
import java.util.ArrayList;
import java.util.Scanner;

public class day3 {
    public static void main(String[] args) {
        part1();
//        part2();
    }
    public static void part1() {
        String gammaRate = "";
        String epsilonRate = "";
        // fill arrayList with binary nums
        ArrayList<String> nums = new ArrayList<>();
        int countInc = 0;
        Scanner scanner = new Scanner(System.in);
        String firstStr = scanner.nextLine();
        String secondStr = "";
        nums.add(firstStr);
        while (scanner.hasNextLine() && !secondStr.equals("exit")) {
            secondStr = scanner.nextLine();
            if (secondStr.equals("exit")) {
                break;
            } else {
                nums.add(secondStr);
            }
            firstStr = secondStr;
        }
        scanner.close();
        for (int i = 0; i < nums.get(i).length(); i++) {
            int count1 = 0;
            int count0 = 0;
            for (int j = 0; j < nums.size(); j++) {
                if (nums.get(j).toString().charAt(i) == ('0')) {
                    count0++;
                } else {
                    count1++;
                }
            }
            if (count0 > count1) {
                gammaRate += "0";
                epsilonRate += "1";
            } else {
                gammaRate += "1";
                epsilonRate += "0";
            }

        }
        System.out.println(Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2));
    }

    public static void part2() {
    }
}
