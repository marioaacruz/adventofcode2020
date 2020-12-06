import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day5 {

    public static void main(String[] args) {
        //part1();
        part2();
    }

    private static void part2() {
        List<Integer> list = new ArrayList<Integer>();
        try {
            File myObj = new File("src/Day5-1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                
                Integer row = getRow(line.substring(0, 7));
                Integer seat = getSeat(line.substring(7, 10));
                
                Integer idSeat = (row * 8) + seat;
                
                list.add(idSeat);

            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        
        Collections.sort(list);
        for(int i = 0; i < list.size() ; i++) {
           System.out.println(list.get(i)); 
        }
        
        //https://planetcalc.com/7471/
        
    }

    private static void part1() {
        try {
            File myObj = new File("src/Day5-1.txt");
            Scanner myReader = new Scanner(myObj);
            int highID = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                
                Integer row = getRow(line.substring(0, 7));
                Integer seat = getSeat(line.substring(7, 10));
                
                Integer idSeat = (row * 8) + seat;
                
                if(idSeat > highID) {
                    highID = idSeat;
                }

            }
            System.out.println(highID);
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        
    }

    private static Integer getSeat(String line) {
        int seatMax = 7;
        int seatMin = 0;
        int diff = seatMax - seatMin;

        for(int i = 0; i < line.length() ; i++) {
            if(line.charAt(i) == 'L') {
                seatMax = seatMax - (diff/2) - 1;
            }else {
                seatMin = seatMin + (diff/2) + 1;
            }
            diff = seatMax - seatMin;
        }
        
        //System.out.println(seatMin);
        //System.out.println(seatMin);
        //System.out.println(diff);
        
        return seatMax;
    }

    private static Integer getRow(String line) {
        int rowMax = 127;
        int rowMin = 0;
        int diff = rowMax - rowMin;
        
        for(int i = 0; i < line.length() ; i++) {
            if(line.charAt(i) == 'F') {
                rowMax = rowMax - (diff/2) - 1;
            }else {
                rowMin = rowMin + (diff/2) + 1;
            }
            diff = rowMax - rowMin;
        }
        
        //System.out.println(rowMax);
        //System.out.println(rowMin);
        //System.out.println(diff);
        
        return rowMax;
    }

}
