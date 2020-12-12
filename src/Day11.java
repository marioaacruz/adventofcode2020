import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day11 {
    
        public static void main(String[] args) throws IOException {
            File myObj = new File("src/Day11-1.txt");
            Scanner sc = new Scanner(myObj);
            ArrayList<ArrayList<String>> input = new ArrayList<ArrayList<String>>();
            
            while (sc.hasNext()) {
                String s = sc.nextLine();
                ArrayList<String> line = new ArrayList<String>();
                for(int i = 0; i < s.length(); i++) {
                    line.add(s.charAt(i)+"");
                }
                input.add(line);
            }
            
            part1(input);
            part2(input);
        }

        private static void printInput(ArrayList<ArrayList<String>> input) {
            for(int i = 0; i<input.size();i++) {
                for(int j=0; j< input.get(i).size();j++) {
                    System.out.print(input.get(i).get(j));
                }
                System.out.println();
            }
            System.out.println();
        }

        private static void part1(ArrayList<ArrayList<String>> input) {
            
            int i = 1;
            ArrayList<ArrayList<String>> newInput = null;
            while(i != 0) {
                newInput = new ArrayList<ArrayList<String>>(iterateInput(input));
                i = countChanged(input, newInput);
                if(i!=0)
                    input = newInput;
            }
            int oc = countOccupied(newInput);
            //printInput(newInput);
            System.out.println("PART1 - "+oc);
        }

        private static int countOccupied(ArrayList<ArrayList<String>> input) {
            int total = 0;
            for(int i = 0; i<input.size();i++) {
                for(int j=0; j< input.get(i).size();j++) {
                    if(input.get(i).get(j).equalsIgnoreCase("#")) {
                        total++;
                    }
                }
            }
            return total;
        }

        private static ArrayList<ArrayList<String>> iterateInput(ArrayList<ArrayList<String>> input) {
            ArrayList<ArrayList<String>> newInput = new ArrayList<ArrayList<String>>();
            

            for(int i = 0; i<input.size();i++) {
                ArrayList<String> line = new ArrayList<String>();
                for(int j=0; j< input.get(i).size();j++) {
                    line.add(input.get(i).get(j)+"");
                }
                newInput.add(line);
            }
            
            
            for(int i = 0; i<input.size();i++) {
                for(int j=0; j< input.get(i).size();j++) {
                    newInput.get(i).set(j, getNewValue(i, j, input));
                }
            }
            return newInput;
        }
        
        private static ArrayList<ArrayList<String>> iterateInput2(ArrayList<ArrayList<String>> input) {
            ArrayList<ArrayList<String>> newInput = new ArrayList<ArrayList<String>>();
            

            for(int i = 0; i<input.size();i++) {
                ArrayList<String> line = new ArrayList<String>();
                for(int j=0; j< input.get(i).size();j++) {
                    line.add(input.get(i).get(j)+"");
                }
                newInput.add(line);
            }
            
            
            for(int i = 0; i<input.size();i++) {
                for(int j=0; j< input.get(i).size();j++) {
                    newInput.get(i).set(j, getNewValue2(i, j, input));
                }
            }
            return newInput;
        }
        
        private static String getNewValue2(int i, int j, ArrayList<ArrayList<String>> input) {
            switch(input.get(i).get(j)) {
                case ".":
                    return ".";
                case "L":
                    return hasNoOccupiedLine(i,j,input) ? "#" : "L";  
                case "#":
                    return fiveOrMoreOccupied(i,j,input) ? "L" : "#"; 
            }
            return "@";
        }

        private static String getNewValue(int i, int j, ArrayList<ArrayList<String>> input) {
            switch(input.get(i).get(j)) {
                case ".":
                    return ".";
                case "L":
                    return hasNoOccupiedAdjacent(i,j,input) ? "#" : "L";  
                case "#":
                    return fourOrMoreOccupied(i,j,input) ? "L" : "#"; 
            }
            return "@";
        }

        private static boolean fourOrMoreOccupied(int i, int j, ArrayList<ArrayList<String>> input) {
            ArrayList<String> adj = new ArrayList<String>();
            adj.add(getSpecific(i+1,j,input));
            adj.add(getSpecific(i,j+1,input));
            adj.add(getSpecific(i-1,j,input));
            adj.add(getSpecific(i,j-1,input));
            adj.add(getSpecific(i+1,j+1,input));
            adj.add(getSpecific(i+1,j-1,input));
            adj.add(getSpecific(i-1,j+1,input));
            adj.add(getSpecific(i-1,j-1,input));
            return countOccupiedUtil(adj) >= 4;
        }
        
        private static boolean fiveOrMoreOccupied(int i, int j, ArrayList<ArrayList<String>> input) {
            ArrayList<String> adj = new ArrayList<String>();
            adj.add(getSpecific(i+1,j,input, 1,0));
            adj.add(getSpecific(i,j+1,input, 0,1));
            adj.add(getSpecific(i-1,j,input, -1,0));
            adj.add(getSpecific(i,j-1,input, 0,-1));
            adj.add(getSpecific(i+1,j+1,input, 1,1));
            adj.add(getSpecific(i+1,j-1,input, 1,-1));
            adj.add(getSpecific(i-1,j+1,input, -1,1));
            adj.add(getSpecific(i-1,j-1,input, -1,-1));
            return countOccupiedUtil(adj) >= 5;
        }
        
        private static boolean hasNoOccupiedLine(int i, int j, ArrayList<ArrayList<String>> input) {
            ArrayList<String> adj = new ArrayList<String>();
            adj.add(getSpecific(i+1,j,input, 1,0));
            adj.add(getSpecific(i,j+1,input, 0,1));
            adj.add(getSpecific(i-1,j,input, -1,0));
            adj.add(getSpecific(i,j-1,input, 0,-1));
            adj.add(getSpecific(i+1,j+1,input, 1,1));
            adj.add(getSpecific(i+1,j-1,input, 1,-1));
            adj.add(getSpecific(i-1,j+1,input, -1,1));
            adj.add(getSpecific(i-1,j-1,input, -1,-1));
            return countOccupiedUtil(adj) == 0;
        }

        private static boolean hasNoOccupiedAdjacent(int i, int j, ArrayList<ArrayList<String>> input) {
            ArrayList<String> adj = new ArrayList<String>();
            adj.add(getSpecific(i+1,j,input));
            adj.add(getSpecific(i,j+1,input));
            adj.add(getSpecific(i-1,j,input));
            adj.add(getSpecific(i,j-1,input));
            adj.add(getSpecific(i+1,j+1,input));
            adj.add(getSpecific(i+1,j-1,input));
            adj.add(getSpecific(i-1,j+1,input));
            adj.add(getSpecific(i-1,j-1,input));
            return countOccupiedUtil(adj) == 0;
        }

        private static int countOccupiedUtil(ArrayList<String> adj) {
            int count = 0;
            for(String s : adj) {
                if(s.equalsIgnoreCase("#"))
                    count++;
            }
            return count;
        }

        private static String getSpecific(int i, int j, ArrayList<ArrayList<String>> input) {
            try {
                return input.get(i).get(j);                
            }
            catch(Exception e) {
                return "";
            }
        }
        
        private static String getSpecific(int i, int j, ArrayList<ArrayList<String>> input, int k, int l) {
            try {
                return input.get(i).get(j).equalsIgnoreCase(".") ? getSpecific(i+k, j+l,input, k, l) : input.get(i).get(j);
            }
            catch(Exception e) {
                return "";
            }
        }

        private static int countChanged(ArrayList<ArrayList<String>> input, ArrayList<ArrayList<String>> newInput) {
            for(int i = 0; i<input.size();i++) {
                for(int j=0; j< input.get(i).size();j++) {
                    if(!input.get(i).get(j).equalsIgnoreCase(newInput.get(i).get(j))) {
                        return 1;
                    }
                }
            }
            return 0;
        }

        private static void part2(ArrayList<ArrayList<String>> input) {
            
            int i = 1;
            ArrayList<ArrayList<String>> newInput = null;
            while(i != 0) {
                newInput = new ArrayList<ArrayList<String>>(iterateInput2(input));
                i = countChanged(input, newInput);
                if(i!=0)
                    input = newInput;
            }
            int oc = countOccupied(newInput);
            System.out.println("PART2 - "+oc);
        }
        
}
