import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Day8 {

    public static void main(String[] args) {
        System.out.print("1-");
        part1();
        System.out.print("2-");
        part2();
    }

    private static void part2() {
        for(int i = 0; i<625; i++) {
            runPart1(i);
        }
    }

    private static void runPart1(int i) {
        try {
        File myObj = new File("src/Day8-1.txt");
        Scanner myReader = new Scanner(myObj);

        LinkedList<HashMap<String, Integer>> instructionList = new LinkedList<HashMap<String,Integer>>();

        
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            
            HashMap<String, Integer> instructionTuple = new HashMap<String, Integer>();
            instructionTuple.put(line, 0);
            instructionList.add(instructionTuple);
            
        }
        myReader.close();
        
        int acc = 0;
        int actionIndex = 0;
        boolean print = false;
        while(true) {
            if(actionIndex>624) {
                print = true;
                break;
            }
            HashMap<String, Integer> instruction = instructionList.get(actionIndex);
            if(instruction.values().iterator().next() == 1) {
                break;
            }
            String action = instruction.keySet().iterator().next().split(" ")[0];
            String value = instruction.keySet().iterator().next().split(" ")[1];
            if(i == actionIndex)
                action = trySwitchAction(action);
            switch(action) {
                case "acc":
                    acc = acc + getValue(value);
                    actionIndex++;
                    break;
                case "jmp":
                    actionIndex = actionIndex + getValue(value);
                    break;
                case "nop":
                    actionIndex++;
                    break;
            }
            instruction.put(instruction.keySet().iterator().next(), 1);
        }
        if(print)
        System.out.println(acc);
        
      } catch (Exception e) {
        
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
        
    }

    private static String trySwitchAction(String action) {
        if(action.equalsIgnoreCase("nop"))
            return "jmp";
        if(action.equalsIgnoreCase("jmp"))
            return "nop";
        return action;
    }

    private static void part1() {
        try {
        File myObj = new File("src/Day8-1.txt");
        Scanner myReader = new Scanner(myObj);

        LinkedList<HashMap<String, Integer>> instructionList = new LinkedList<HashMap<String,Integer>>();

        
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            
            HashMap<String, Integer> instructionTuple = new HashMap<String, Integer>();
            instructionTuple.put(line, 0);
            instructionList.add(instructionTuple);
            
        }
        myReader.close();
        
        int acc = 0;
        int actionIndex = 0;
        
        while(true) {
            HashMap<String, Integer> instruction = instructionList.get(actionIndex);
            if(instruction.values().iterator().next() == 1) {
                break;
            }
            String action = instruction.keySet().iterator().next().split(" ")[0];
            String value = instruction.keySet().iterator().next().split(" ")[1];
            switch(action) {
                case "acc":
                    acc = acc + getValue(value);
                    actionIndex++;
                    break;
                case "jmp":
                    actionIndex = actionIndex + getValue(value);
                    break;
                case "nop":
                    actionIndex++;
                    break;
            }
            instruction.put(instruction.keySet().iterator().next(), 1);
        }

        System.out.println(acc);
        
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
        
    }

    private static int getValue(String value) {
        if(value.charAt(0) == '+') {
            return Integer.parseInt(value.substring(1));
        } else {
            return 0 - Integer.parseInt(value.substring(1));
        }
    }


}
