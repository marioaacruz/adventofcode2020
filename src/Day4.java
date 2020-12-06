import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {
    
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static void main(String[] args) {
        part1();
        part2();

    }

    private static void part1() {
        try {
            File myObj = new File("src/Day4-1.txt");
            Scanner myReader = new Scanner(myObj);
            int valid = 0;
            boolean hasCID = false;
            int numFields = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                
                if(line.trim().isEmpty()) {
                    if((numFields == 8) || (numFields == 7 && hasCID == false)) {
                        valid++;
                    }
                    hasCID = false;
                    numFields = 0;
                }else {
                    hasCID = hasCID || line.contains("cid:");
                    numFields = numFields + line.split(" ").length;
                }
            }
            System.out.println(valid);
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    
    private static void part2() {
        try {
            File myObj = new File("src/Day4-1.txt");
            Scanner myReader = new Scanner(myObj);
            int valid = 0;
            String temp = "";
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                
                if(line.trim().isEmpty()) {
                    if(validLine(temp)) {
                        valid++;
                    }
                    temp = "";
                }else {
                    temp = temp + " " +line;
                }
            }
            myReader.close();
            System.out.println(valid);
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    private static boolean validLine(String temp) {
        String[] fields = temp.trim().split(" ");
        int numFields = fields.length;
        System.out.println("LINE - "+numFields +":"+temp);
        boolean hasCID = temp.contains("cid:");
        
        if(numFields < 7 || (numFields == 7 && hasCID) || numFields > 8) {
            return false;
        }
        for(int i = 0; i < fields.length ; i++) {
            if(!validateField(fields[i])) {
                return false;
            }
            
        }
        
        return true;
    }

    private static boolean validateField(String f) {
        String field = f.trim().split(":")[0];
        String value = f.trim().split(":")[1];
        
        switch(field) 
        { 
            case "byr": 
                int i = Integer.parseInt(value);
                return 1920 <= i && i <= 2002;
            case "iyr": 
                int u = Integer.parseInt(value);
                return 2010 <= u && u <= 2020; 
            case "eyr": 
                int x = Integer.parseInt(value);
                return 2020 <= x && x <= 2030;
            case "hgt": 
                if(value.contains("cm")) {
                    int number = Integer.parseInt(value.substring(0, value.length()-2));
                    return 150 <= number && number <= 193;
                }else if (value.contains("in")) {
                    int number = Integer.parseInt(value.substring(0, value.length()-2));
                    return 59 <= number && number <= 76;
                }
                return false;
            case "hcl": 
                return value.length() == 7 && value.charAt(0) == '#' && isHexadecimal(value.substring(1));
            case "ecl": 
                return value.equalsIgnoreCase("amb") || value.equalsIgnoreCase("blu") || value.equalsIgnoreCase("brn") || value.equalsIgnoreCase("gry") || value.equalsIgnoreCase("grn") || value.equalsIgnoreCase("hzl") || value.equalsIgnoreCase("oth");
            case "pid": 
                return value.length() == 9 && isNumeric(value);
            case "cid": 
                    return true;
            default: 
                break;
        }
        
        return false;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false; 
        }
        return pattern.matcher(strNum).matches();
    }
    
    private static final Pattern HEXADECIMAL_PATTERN = Pattern.compile("\\p{XDigit}+");

    private static boolean isHexadecimal(String input) {
        final Matcher matcher = HEXADECIMAL_PATTERN.matcher(input);
        return matcher.matches();
    }

}
