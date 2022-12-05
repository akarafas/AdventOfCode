package main.java.previousYear;
import java.util.ArrayList;
import java.util.Scanner;

public class day3 {
    public static void main(String[] args) {
//        part1();
        part2();
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

    public static int gcm(ArrayList<String> nums) {
        ArrayList<String> oxygenNums = nums;
        while (true) {
            // get most common bit
            for (int i = 0; i < (oxygenNums.get(0).length()); i++) {
                int count1 = 0;
                int count0 = 0;
                for (int j = 0; j < oxygenNums.size(); j++) {
                    if (oxygenNums.get(j).charAt(i) == ('0')) {
                        count0++;
                    } else {
                        count1++;
                    }
                }
                // remove any that don't have that
                int greaterCountNum = (count0 > count1) ? 0 : 1;
                final int zz = i;
                oxygenNums.removeIf(s -> Integer.parseInt(String.valueOf(s.charAt(zz))) != greaterCountNum);
                if (oxygenNums.size() == 1) {
                    System.out.println(Integer.parseInt(oxygenNums.get(0), 2));
                    return Integer.parseInt(oxygenNums.get(0), 2);
                }
            }
        }
    }

    public static int lcm(ArrayList<String> nums) {
        ArrayList<String> oxygenNums = nums;
        ArrayList<String> carbonNums = nums;
        while (true) {
            // get most common bit
            for (int i = 0; i < (oxygenNums.get(0).length()); i++) {
                int count1 = 0;
                int count0 = 0;
                for (int j = 0; j < oxygenNums.size(); j++) {
                    if (oxygenNums.get(j).charAt(i) == ('0')) {
                        count0++;
                    } else {
                        count1++;
                    }
                }
                // remove any that don't have that
                int greaterCountNum = (count0 <= count1) ? 0 : 1;
                final int zz = i;
                oxygenNums.removeIf(s -> Integer.parseInt(String.valueOf(s.charAt(zz))) != greaterCountNum);
                if (oxygenNums.size() == 1) {
                    System.out.println(Integer.parseInt(oxygenNums.get(0), 2));
                    return Integer.parseInt(oxygenNums.get(0), 2);
                }
            }
        }
    }
    public static void part2() {
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
        ArrayList<String> lcmNums = (ArrayList<String>) nums.clone();
        int gcm = gcm(nums);
        int lcm = lcm(lcmNums);
        int rate = lcm*gcm;
        System.out.println(rate);
    }
}
