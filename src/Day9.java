import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Day9 {

    public static void main(String[] args) {
        System.out.print("1-");
        part1();
        //26134589
        System.out.print("2-");
        part2();
    }

    private static void part2() {
        try {
        File myObj = new File("src/Day9-1.txt");
        Scanner myReader = new Scanner(myObj);

        LinkedList<Long> list = new LinkedList<Long>();

        Long l = Long.parseLong("26134589");
        
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            if(Long.parseLong(line) < l) {
                list.add(Long.parseLong(line));
            }
            
        }
        myReader.close();
        
       getSum(l, list);
        
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
        
    }

    

    private static void getSum(Long l, LinkedList<Long> list) {
        for(int i = 0; i<list.size();i++) {
            if(checkFrom(l, list.subList(i, list.size()))) {
                return;
            }
        }
    }

    private static boolean checkFrom(Long l, List<Long> subList) {
        Long sum = Long.parseLong("0");
        for(int i = 0; i<subList.size(); i++) {
            sum = sum + subList.get(i);
            if(sum.equals(l)) {
                printNumbers(subList.subList(0, i+1));
                return true;
            }
            if(sum > l) {
                return false;
            }
        }
        return false;
    }

    private static void printNumbers(List<Long> subList) {
       System.out.println("max:"+Collections.max(subList));
       System.out.println("min:"+Collections.min(subList));
       Long sum = Collections.max(subList)+Collections.min(subList);
       System.out.println("sum of both numbers="+sum);
    }

    private static void part1() {
        try {
        File myObj = new File("src/Day9-1.txt");
        Scanner myReader = new Scanner(myObj);

        LinkedList<Long> list = new LinkedList<Long>();

        
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            list.add(Long.parseLong(line));
            
        }
        myReader.close();
        
        
        for(int i = 25; i<list.size();i++) {
            checkPermeabble(i, list);
        }
        
        
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
        
    }

    private static void checkPermeabble(int i, LinkedList<Long> list) {
        List<Long> list2 = list.subList(i-25, i);
        Long value = list.get(i);
        
        if(!checkValue(value, list2))
            System.out.println(value);
        
    }

    private static boolean checkValue(Long value, List<Long> list2) {
        for(int i = 0; i< list2.size(); i++) {
            for(int j = 0; j< list2.size(); j++) {
                if(i==j) 
                    continue;
                if(list2.get(i) + list2.get(j) == value)
                    return true;
            }
        }
        return false;
    }

}
