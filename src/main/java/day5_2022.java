package main.java;

import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class day5_2022 {
    public static void main(String[] args) {
        part1();
//        part2();
    }

    public static void part1() {
        System.out.println("Paste dir and num input and type exit to exit");
        Scanner scanner = new Scanner(in);
        String line = scanner.nextLine();
        // make stack setup
        // create list of x stacks, put from bottom?
        List<Stack<Character>> listOfStacks = new ArrayList<Stack<Character>>();
         for (int i=0;i<9;i++) {
            listOfStacks.add(new Stack<Character>());
        }
       //0
        listOfStacks.get(0).push('H');
        listOfStacks.get(0).push('T');
        listOfStacks.get(0).push('Z');
        listOfStacks.get(0).push('D');
        //1
        listOfStacks.get(1).push('Q');
        listOfStacks.get(1).push('R');
        listOfStacks.get(1).push('W');
        listOfStacks.get(1).push('T');
        listOfStacks.get(1).push('G');
        listOfStacks.get(1).push('C');
        listOfStacks.get(1).push('S');
        //2
        listOfStacks.get(2).push('P');
        listOfStacks.get(2).push('B');
        listOfStacks.get(2).push('F');
        listOfStacks.get(2).push('Q');
        listOfStacks.get(2).push('N');
        listOfStacks.get(2).push('R');
        listOfStacks.get(2).push('C');
        listOfStacks.get(2).push('H');
        //3
        listOfStacks.get(3).push('L');
        listOfStacks.get(3).push('C');
        listOfStacks.get(3).push('N');
        listOfStacks.get(3).push('F');
        listOfStacks.get(3).push('H');
        listOfStacks.get(3).push('Z');
        //4
        listOfStacks.get(4).push('G');
        listOfStacks.get(4).push('L');
        listOfStacks.get(4).push('F');
        listOfStacks.get(4).push('Q');
        listOfStacks.get(4).push('S');
        //5
        listOfStacks.get(5).push('V');
        listOfStacks.get(5).push('P');
        listOfStacks.get(5).push('W');
        listOfStacks.get(5).push('Z');
        listOfStacks.get(5).push('B');
        listOfStacks.get(5).push('R');
        listOfStacks.get(5).push('C');
        listOfStacks.get(5).push('S');
        //6
        listOfStacks.get(6).push('Z');
        listOfStacks.get(6).push('F');
        listOfStacks.get(6).push('J');
        //7
        listOfStacks.get(7).push('D');
        listOfStacks.get(7).push('L');
        listOfStacks.get(7).push('V');
        listOfStacks.get(7).push('Z');
        listOfStacks.get(7).push('R');
        listOfStacks.get(7).push('H');
        listOfStacks.get(7).push('Q');
        //8
        listOfStacks.get(8).push('B');
        listOfStacks.get(8).push('H');
        listOfStacks.get(8).push('G');
        listOfStacks.get(8).push('N');
        listOfStacks.get(8).push('F');
        listOfStacks.get(8).push('Z');
        listOfStacks.get(8).push('L');
        listOfStacks.get(8).push('D');

        while (scanner.hasNextLine() && !line.equals("exit") && line.length()!=0) {
            // split by whitespace: move,1,from,2,to,1
            String[] instructions = line.split(" ");
            //arr[1] = # repeat moves (loop)
            //arr[3] = from stack
            //arr[5] = to stack
            int repeatMoves = parseInt(instructions[1]);
            int moveFrom = parseInt(instructions[3]);
            int moveTo = parseInt(instructions[5]);
            List<Character> itemsToMove = new ArrayList<Character>();
            for (int i=0;i<repeatMoves;i++) {
                // instead of peeking top, peek below then push (instead of from top, move two means from 2 below)
                char c = listOfStacks.get(moveFrom-1).peek();
                itemsToMove.add(c);
                listOfStacks.get(moveFrom-1).pop();
            }
            // put in list
            for (int i=repeatMoves;i>0;i--) {
                listOfStacks.get(moveTo-1).push(itemsToMove.get(i-1));

            }
            line = scanner.nextLine();
            if (line == "exit") {
                break;
            }
        }
        // for x stacks, get top and concat with str
        String topStacks = "";
        for (Stack s: listOfStacks) {
            topStacks += s.peek();
        }
        scanner.close();
        System.out.println(topStacks);
    }
    public static void part2() {
        System.out.println("Paste dir and num input and type exit to exit");
        Scanner scanner = new Scanner(in);
        String line = scanner.nextLine();
        // make stack setup
        // create list of x stacks, put from bottom?
        List<Stack<Character>> listOfStacks = new ArrayList<Stack<Character>>();
        for (int i=0;i<9;i++) {
            listOfStacks.add(new Stack<Character>());
        }
        //0
        listOfStacks.get(0).push('H');
        listOfStacks.get(0).push('T');
        listOfStacks.get(0).push('Z');
        listOfStacks.get(0).push('D');
        //1
        listOfStacks.get(1).push('Q');
        listOfStacks.get(1).push('R');
        listOfStacks.get(1).push('W');
        listOfStacks.get(1).push('T');
        listOfStacks.get(1).push('G');
        listOfStacks.get(1).push('C');
        listOfStacks.get(1).push('S');
        //2
        listOfStacks.get(2).push('P');
        listOfStacks.get(2).push('B');
        listOfStacks.get(2).push('F');
        listOfStacks.get(2).push('Q');
        listOfStacks.get(2).push('N');
        listOfStacks.get(2).push('R');
        listOfStacks.get(2).push('C');
        listOfStacks.get(2).push('H');
        //3
        listOfStacks.get(3).push('L');
        listOfStacks.get(3).push('C');
        listOfStacks.get(3).push('N');
        listOfStacks.get(3).push('F');
        listOfStacks.get(3).push('H');
        listOfStacks.get(3).push('Z');
        //4
        listOfStacks.get(4).push('G');
        listOfStacks.get(4).push('L');
        listOfStacks.get(4).push('F');
        listOfStacks.get(4).push('Q');
        listOfStacks.get(4).push('S');
        //5
        listOfStacks.get(5).push('V');
        listOfStacks.get(5).push('P');
        listOfStacks.get(5).push('W');
        listOfStacks.get(5).push('Z');
        listOfStacks.get(5).push('B');
        listOfStacks.get(5).push('R');
        listOfStacks.get(5).push('C');
        listOfStacks.get(5).push('S');
        //6
        listOfStacks.get(6).push('Z');
        listOfStacks.get(6).push('F');
        listOfStacks.get(6).push('J');
        //7
        listOfStacks.get(7).push('D');
        listOfStacks.get(7).push('L');
        listOfStacks.get(7).push('V');
        listOfStacks.get(7).push('Z');
        listOfStacks.get(7).push('R');
        listOfStacks.get(7).push('H');
        listOfStacks.get(7).push('Q');
        //8
        listOfStacks.get(8).push('B');
        listOfStacks.get(8).push('H');
        listOfStacks.get(8).push('G');
        listOfStacks.get(8).push('N');
        listOfStacks.get(8).push('F');
        listOfStacks.get(8).push('Z');
        listOfStacks.get(8).push('L');
        listOfStacks.get(8).push('D');

        while (scanner.hasNextLine() && !line.equals("exit") && line.length()!=0) {
            // split by whitespace: move,1,from,2,to,1
            String[] instructions = line.split(" ");
            //arr[1] = # repeat moves (loop)
            //arr[3] = from stack
            //arr[5] = to stack
            int repeatMoves = parseInt(instructions[1]);
            int moveFrom = parseInt(instructions[3]);
            int moveTo = parseInt(instructions[5]);
            for (int i=0;i<repeatMoves;i++) {
                char c = listOfStacks.get(moveFrom-1).peek();
                listOfStacks.get(moveFrom-1).pop();
                listOfStacks.get(moveTo-1).push(c);
            }
            line = scanner.nextLine();
            if (line == "exit") {
                break;
            }
        }
        // for x stacks, get top and concat with str
        String topStacks = "";
        for (Stack s: listOfStacks) {
            topStacks += s.peek();
        }
        scanner.close();
        System.out.println(topStacks);
    }
}
