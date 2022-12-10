package main.java;

import main.java.helpers.Signal;
import main.java.helpers.signalStrength;

import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class day10_2022 {
    public static void main(String[] args) {
//        part1();
        part2();
    }

    public static void part1() {
        System.out.println("Paste input and type exit to exit");
        Scanner scanner = new Scanner(in);
        String line = scanner.nextLine();
        ArrayList<signalStrength> arr = new ArrayList<signalStrength>(); // store cycle and X (can use for signal strength)
        arr.add(new signalStrength(1));
        while (scanner.hasNextLine() && !line.equals("exit") && line.length()!=0) {
            if (line.contains("noop")) {
                int addX = 0;
                arr.add(new signalStrength(0));
            } else {
                int addX = parseInt(line.substring(5));
                arr.add(new signalStrength(0)); // need to account for empty cycle
                arr.add(new signalStrength(addX));
            }

            line = scanner.nextLine();
            if (line == "exit") {
                break;
            }
        }
        scanner.close();
        int sum = sumCycles(arr);
        System.out.println(sum);
    }
    public static int sumCycles(ArrayList<signalStrength> signals) { // could change to do this while adding
        int total = 0;
        int fortySums = 0;
        for (int i=0;i<220;i++) {
            int signal = signals.get(i).getx();
            total += signals.get(i).getx();
            if (i==19 || i==59 || i==99 || i==139 || i==179 || i==219) {
                int round = total * (i+1);
                fortySums += round;
            }
        }
        return fortySums;
    }

    public static void part2() {
        System.out.println("Paste input and type exit to exit");
        Scanner scanner = new Scanner(in);
        String line = scanner.nextLine();
        ArrayList<signalStrength> arr = new ArrayList<signalStrength>(); // store cycle and X (can use for signal strength)
        arr.add(new signalStrength(1));
        while (scanner.hasNextLine() && !line.equals("exit") && line.length()!=0) {
            if (line.contains("noop")) {
                int addX = 0;
                arr.add(new signalStrength(0));
            } else {
                int addX = parseInt(line.substring(5));
                arr.add(new signalStrength(0)); // need to account for empty cycle
                arr.add(new signalStrength(addX));
            }

            line = scanner.nextLine();
            if (line == "exit") {
                break;
            }
        }
        scanner.close();
        System.out.println();
        draw(arr);
    }

    public static void draw(ArrayList<signalStrength> signals) {
        String image = "";
        int total = 0;
        for (int i = 0; i < 240; i++) {
            int signal = signals.get(i).getx();
            total += signals.get(i).getx();
            int iMult = i % 40;
            if (iMult == total || iMult == total -1 || iMult == total+1) {
                image += "#";
            } else {
                image += ".";
            }
        }
        System.out.println(image.substring(0,40));
        System.out.println(image.substring(40,80));
        System.out.println(image.substring(80,120));
        System.out.println(image.substring(120,160));
        System.out.println(image.substring(160,200));
        System.out.println(image.substring(200,240));
    }
}
