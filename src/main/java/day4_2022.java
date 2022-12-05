package main.java;

import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class day4_2022 {
    public static void main(String[] args) {
        part1();
//        part2();
    }

    public static void part1() {
        System.out.println("Paste dir and num input and type exit to exit");
        Scanner scanner = new Scanner(in);
        String line = scanner.nextLine();
        int overlapCount = 0;
        while (scanner.hasNextLine() && !line.equals("exit") && line.length() != 0) {
            // add pair one and pair two "2-4,6-8"
            // split by comma, from first char, parse to int, add until second char (parse to int)
            String[] pairs = line.split(","); // [2-4, 6-8]
            String[] p1 = pairs[0].split("-"); // [2.4]
            String[] p2 = pairs[1].split("-"); //[6,8]
            Map<Integer, Integer> pair1 = new HashMap<Integer, Integer>();
            int start1;
            int start2;
            int upTo1;
            int upTo2;
            start1 = parseInt(p1[0]);
            upTo1 = parseInt(p1[1]);
            start2 = parseInt(p2[0]);
            upTo2 = parseInt(p2[1]);
/*            if (completeOverlap(start1, upTo1, start2, upTo2)) {
                overlapCount += 1;
            }*/
            for (int i=0;i<2;i++) {
                int start;
                int upTo;
                if (i==0) {
                    start = parseInt(p1[0]);
                    upTo = parseInt(p1[1]);
                } else {
                    start = parseInt(p2[0]);
                    upTo = parseInt(p2[1]);
                }

                for (int j = start; j <= upTo; j++) {
                    if (pair1.containsKey(j)) {
                        pair1.put(j, pair1.get(j) + 1);
                    } else {
                        pair1.put(j, 1);
                    }
                }
            }
            if (completeOverlap(pair1, parseInt(String.valueOf(pairs[0].charAt(0))))) {
                overlapCount += 1;
            }
            // if does, add to total score

            line = scanner.nextLine();
            if (line == "exit") {
                break;
            }
        }
        scanner.close();
        System.out.println(overlapCount);
    }

    public static boolean completeOverlap(Map<Integer, Integer> pairs, int start) {
        for (int count : pairs.values()) {
            if (count == 2) {
                return true;
            }
        }
        return false;
    }
    /*public static boolean completeOverlap(int s1, int e1, int s2, int e2) {
        // 6-8 2-4
        // check p1 fits in p2
        if (s1 >= s2 && e1 <= e2 || s1 <= s2 && e1 >= e2) {
            return true;
        }
        return false;
    }*/
}