import java.util.*;
import java.io.*;

public class Maze{
  private char[][]maze;
  private boolean animate;


  public Maze(String filename){
    try{
      int c = -1;
      String line = "";
      File text = new File(filename);
      Scanner inf = new Scanner(text);
      while(inf.hasNextLine()){
        line = inf.nextLine();
        c ++;
        System.out.println(line);//hopefully you can do other things with the line
      }
      System.out.println(c);
      int r = line.length()
      System.out.println(r);
    }
    catch (FileNotFoundException e){
      System.out.println("File Not Found");
    }
   }



  public static void main(String args[]){
    Maze test = new Maze(args[0]);
  }
}
