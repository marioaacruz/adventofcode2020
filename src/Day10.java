import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day10 {
    
        public static void main(String[] args) throws IOException {
            File myObj = new File("src/Day10-1.txt");
            Scanner sc = new Scanner(myObj);
            List<Integer> input = new ArrayList<Integer>();
            
            input.add(0); 
            while (sc.hasNext()) {
               input.add(Integer.parseInt(sc.nextLine()));
            }
            Collections.sort(input);
            input.add(input.get(input.size() - 1) + 3);
            
            
            part1(input);
            part2(input);
        }

        private static void part2(List<Integer> inputs) { 
            Map<Integer, List<Integer>> possibleConnections = new HashMap<>();
            for (int i = inputs.size() - 1; i >=0; --i) {
                int j = i - 1;
                List<Integer> children = new ArrayList<>();
                while (j >= 0 && inputs.get(i) <= inputs.get(j) + 3) {
                    children.add(inputs.get(j));
                    j--;
                }
                possibleConnections.put(inputs.get(i), children);
            }
            
            Map<Integer, Long> availablePerNum = new HashMap<>();
            availablePerNum.put(0, 1L);
            long total = 0;
            for (int i = 1; i < inputs.size(); ++i) {
                total = 0;
                for (int e : possibleConnections.get(inputs.get(i))) {
                    total = total + availablePerNum.get(e);
                }
                availablePerNum.put(inputs.get(i), total);
                //System.out.println(inputs.get(i) + " in : " + total+" ways");
            }
        
            System.out.println("Part 2 - " + total);
        }

        private static void part1(List<Integer> inputs) {
            int case1 = 0;
            int case2 = 0;
            int case3 = 0;            
        
            for (int i = 1; i < inputs.size(); ++i) {
                int current = inputs.get(i);
                int previous = inputs.get(i - 1);
                int difference = current - previous;
                switch(difference) {
                    case 1:
                        case1++;
                        break;
                    case 2:
                        case2++;                    
                        break;
                    case 3:
                        case3++;
                        break;

                    default:
                        break;
                }
            }
            int part1 = 0;
            part1 = case1 * case3;
            System.out.println("Part 1 - " + part1);
        }
        
}
