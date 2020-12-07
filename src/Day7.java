import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class Day7 {

    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part2() {
        try {
        File myObj = new File("src/Day7-1.txt");
        Scanner myReader = new Scanner(myObj);

        HashMap<String, HashMap<String, Integer>> ruleList = new HashMap<String, HashMap<String, Integer>>();

        
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            String colourString = line.split("bags contain")[0].trim();
            String rawContent = line.split("bags contain")[1].trim();
            
            ruleList.put(colourString, getcontent(rawContent));
            
        }
        myReader.close();
        
        int sum = 0;
        
        sum = countBagsInside("shiny gold", ruleList);
        
        System.out.println(sum);
        
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
        
    }

    private static int countBagsInside(String bagName, HashMap<String, HashMap<String, Integer>> ruleList) {
        //this was at 0, changed it to one, and the example gave me 127, so i just did it like this and subtracted one
        int result = 1;
        if(ruleList.get(bagName) == null) {
            return 1;
        }
        for(String s : ruleList.get(bagName).keySet()) {
            result = result + (ruleList.get(bagName).get(s)*countBagsInside(s,ruleList));
        }
        return result;
    }

    private static void part1() {
        try {
        File myObj = new File("src/Day7-1.txt");
        Scanner myReader = new Scanner(myObj);

        HashMap<String, HashMap<String, Integer>> ruleList = new HashMap<String, HashMap<String, Integer>>();

        
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            String colourString = line.split("bags contain")[0].trim();
            String rawContent = line.split("bags contain")[1].trim();
            
            ruleList.put(colourString, getcontent(rawContent));
            
        }
        myReader.close();
        
        int sum = 0;
        
        for(String s : ruleList.keySet()) {
            sum = sum + canHoldShinyGold(s, ruleList);
        }
        
        System.out.println(sum);
        
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
        
    }

    private static int canHoldShinyGold(String s, HashMap<String, HashMap<String, Integer>> ruleList) {
        if(ruleList.get(s) == null) {
            return 0;
        }
        if(insidesContainsOneShinyGold(ruleList.get(s))) {
            return 1;
        }
        for(String insideString : ruleList.get(s).keySet()) {
            if (canHoldShinyGold(insideString, ruleList) == 1) {
                return 1;
            }
        }
        return 0;
    }

    private static boolean insidesContainsOneShinyGold(HashMap<String, Integer> hashMap) {
        for(String s : hashMap.keySet()) {
            if(s.equalsIgnoreCase("shiny gold")) {
                return true;
            }
        }
        return false;
    }

    private static HashMap<String, Integer> getcontent(String rawContent) {
        //System.out.println(rawContent);
        if(rawContent.equalsIgnoreCase("no other bags")) {
            return null;
        }
        HashMap<String, Integer> content = new HashMap<String, Integer>();
        String[] bags = rawContent.split(",");
        
        for(String bag : bags) {
            bag = bag.trim();
            //System.out.println(bag.split(" ")[1]+" "+bag.split(" ")[2]);
            //System.out.println(bag.split(" ")[0]);
            String bagName = bag.split(" ")[1]+" "+bag.split(" ")[2];
            Integer number = Integer.parseInt(bag.split(" ")[0]);
            content.put(bagName, number);
        }
        
        return content;
    }

}
