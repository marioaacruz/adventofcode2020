import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Day6 {

    public static void main(String[] args) {
        part1();
        part2();

    }

    private static void part2() {
        try {
        File myObj = new File("src/Day6-1.txt");
        Scanner myReader = new Scanner(myObj);

        HashMap<String, Integer> answers = new HashMap<String, Integer>();
        int sum = 0;
        int numPersons = 0;
        
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();

            if(line.trim().isEmpty()) {
                int toAdd = getNumberFullReplies(numPersons, answers);
                sum = sum + toAdd;
                numPersons = 0;
                answers = new HashMap<String, Integer>();
            }else {
                checkLinePart2(line, answers);
                numPersons++;
            }
        }
        System.out.println("2-"+sum);
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }

    private static int getNumberFullReplies(int numPersons, HashMap<String, Integer> answers) {
        int i = 0;
        for(String s : answers.keySet()) {
            if(answers.get(s) == numPersons) {
                i++;
            }
        }
        return i;
    }

    private static void checkLinePart2(String line, HashMap<String, Integer> answers) {
        for(int i = 0; i < line.length(); i++) {
            String reply = line.charAt(i)+"";
            if(answers.containsKey(reply)) {
                int v = answers.get(reply) + 1;
                answers.put(reply, v);  
            }else {
                answers.put(reply, 1);  
            }
        }
    }

    private static void part1() {       
        try {
        File myObj = new File("src/Day6-1.txt");
        Scanner myReader = new Scanner(myObj);

        HashSet<String> list = new HashSet<String>();
        int sum = 0;
        
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            if(line.trim().isEmpty()) {
                sum = sum + list.size();
                list = new HashSet<String>();
            }else {
                checkLine(line, list);
            }
        }
        System.out.println("1-"+sum);
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }

    private static void checkLine(String line, HashSet<String> list) {
        for(int i = 0; i < line.length(); i++) {
            list.add(line.charAt(i)+"");
        }
    }

}
