import java.util.*;
import java.io.*;

public class Maze{
  private char[][]maze;
  private boolean animate;
  private int row;
  private int col;


  public Maze(String filename){
    try{
      row = 0;
      String line = "";
      File text = new File(filename);
      Scanner inf = new Scanner(text);
      while(inf.hasNextLine()){
        line = inf.nextLine();
        row ++;
        System.out.println(line);//hopefully you can do other things with the line
      }
      //  System.out.println(col);
      col = line.length();
      //  System.out.println(row);
      maze = new char[row][col];
      fillMaze(filename);

    }
    catch (FileNotFoundException e){
      System.out.println("File Not Found");
    }
  }

  public void fillMaze(String filename){
    try{
      String l = "";
      File text = new File(filename);
      Scanner inf = new Scanner(text);
      while(inf.hasNextLine()){
        //System.out.println("SSS");
        for (int x = 0; x < row; x++){
          l = inf.nextLine();
          for (int i = 0; i < l.length(); i++){
            maze[x][i] = l.charAt(i);
          }
        }
      }
    }
    catch (FileNotFoundException e){
      System.out.println("File Not Found");
  }
}


  public String toString(){
    String s = "";
    for (int i = 0; i < row; i++){
      s += "\n";
      for (int j = 0; j < col; j++){
        s+= maze[i][j];
        //System.out.println(s);
      }
    }
    return s;
  }

  public static void main(String args[]){
    Maze test = new Maze(args[0]);
    System.out.println(test.toString());
  }
}
