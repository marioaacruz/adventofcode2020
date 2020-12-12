import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day12 {
    
        public static void main(String[] args) throws IOException {
            File myObj = new File("src/Day12.txt");
            Scanner sc = new Scanner(myObj);
            ArrayList<String> input = new ArrayList<String>();
            
            while (sc.hasNext()) {
                String s = sc.nextLine();
                input.add(s);
            }
            
            //printInput(input);
            
            part1(input);
            part2(input);
        }



        private static void part1(ArrayList<String> input) {

            Position p = new Position();
            
            for(String s : input) {
                takeAction(p, s);
            }
            
            System.out.println(p.answer());
            
            
        }
        
        private static void takeAction(Position p, String s) {
            int value = Integer.parseInt(s.substring(1));
            switch(s.charAt(0)) {
                case 'N':
                    p.posNS += value;
                    break;
                case 'S':
                    p.posNS += (value * -1);
                    break;
                case 'E':
                    p.posWE += (value * -1);
                    break;
                case 'W':
                    p.posWE += value;
                    break;
                case 'L':
                    p.dir = newDirection(p.dir, (value*-1));
                    break;
                case 'R':
                    p.dir = newDirection(p.dir, value);
                    break;
                case 'F':
                    switch(p.dir) {
                        case 3:
                            p.posNS += value;
                            break;
                        case 1:
                            p.posNS += (value * -1);
                            break;
                        case 0:
                            p.posWE += (value * -1);
                            break;
                        case 2:
                            p.posWE += value;
                            break;
                        default:
                            System.out.println("DEU MERDA V2");
                            break;
                    }
                    break;

                default:
                    System.out.println("DEU MERDA");
                    break;
            }
            //return p;
        }



        private static int newDirection(int dir, int rotate) {
            //0 EAST //1 SOUTH  //2 WEST //3 NORTH
            int turn = rotate / 90;
            if(turn<0) {
                turn = 4 + turn;
            }
            return (dir+turn) % 4;
        }

       

        private static void part2(ArrayList<String> input) {
            Position pBoat = new Position();
            Position pWayPoint = new Position(1, -10);
            
            for(String s : input) {
               takeAction(pBoat, pWayPoint, s);
            }
            
           System.out.println(pBoat.answer());
            
        }
        
        private static void takeAction(Position pBoat, Position pWayPoint, String s) {
            int value = Integer.parseInt(s.substring(1));
            switch(s.charAt(0)) {
                case 'N':
                    pWayPoint.posNS += value;
                    break;
                case 'S':
                    pWayPoint.posNS += (value * -1);
                    break;
                case 'E':
                    pWayPoint.posWE += (value * -1);
                    break;
                case 'W':
                    pWayPoint.posWE += value;
                    break;
                case 'L':
                    rotateWaypoint(pWayPoint, 360-value);
                    break;
                case 'R':
                    rotateWaypoint(pWayPoint, value);
                    break;
                case 'F':
                    pBoat.posNS += (pWayPoint.posNS * value);
                    pBoat.posWE += (pWayPoint.posWE * value);
                    break;

                default:
                    System.out.println("DEU MERDA");
                    break;
            }
            //return p;
        }

        private static void rotateWaypoint(Position pWayPoint, int rotate) {
            int turn = rotate / 90;
            if(turn<0) {
                turn = 4 + turn;
            }
            
            int ns = pWayPoint.posNS;
            int we = pWayPoint.posWE;

            switch(rotate) {
                case 90:
                    pWayPoint.posNS = we;
                    pWayPoint.posWE = ns*-1;
                    break;
                case 180:
                    pWayPoint.posNS = ns*-1;
                    pWayPoint.posWE = we*-1;
                    break;
                case 270:
                    pWayPoint.posNS = we*-1;
                    pWayPoint.posWE = ns;
                    break;

                default:
                    System.out.println("COCO");
                    break;
            }
            
        }

        private static class Position{
            //noth positivo, south negative
            int posNS;
            //west positive, east negative
            int posWE;
            //start EAST
            int dir;
            
            public Position() {
                posNS = 0;
                posWE = 0;
                dir = 0;
            }
            
            public Position(int i, int j) {
                posNS = i;
                posWE = j;
                dir = 0;
            }

            public int answer() {
                return Math.abs(posNS) + Math.abs(posWE);
            }

            @Override
            public String toString() {
                return "Position [posNS=" + posNS + ", posWE=" + posWE + ", dir=" + dir + "]";
            }
            
            
            
        }
}

