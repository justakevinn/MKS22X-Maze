import java.util.*;
import java.io.*;

public class Maze{
  private char[][]maze;
  private boolean animate;
  private int row;
  private int col;
  private int[] moves;


  public Maze(String filename){
    try{
      moves = new int[]{0, 1, 0, -1, 1, 0, -1, 0};
      row = 0;
      String line = "";
      File text = new File(filename);
      Scanner inf = new Scanner(text);
      while(inf.hasNextLine()){
        line = inf.nextLine();
        row ++;
      //System.out.println(line);//hopefully you can do other things with the line
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

  public int solve(){
    int r = 0;
    int c = 0;
    for (int i = 0; i < row; i++){
      for (int j = 0; j < col; j++){
        if (maze[i][j] == 'S'){
          r = i;
          c = j;
        }
      }
    }
    System.out.println("r: "+ r + " c: "+ c);
    solve(r, c);
    return countPath();
  }


  public boolean solve(int r, int c){
    if (maze[r][c] == 'E'){
      return true;
    }
    maze[r][c] = '@';
    for (int i = 0; i < moves.length; i += 2){
      if (maze[r+moves[i]][c+moves[i+1]] == ' '){
        maze[r+moves[i]][c+moves[i+1]] = '@';
        return solve(r+moves[i], c+moves[i+1]);
      }
    }
    for (int i = 0; i < moves.length; i += 2){
        if (maze[r+moves[i]][c+moves[i+1]] == '@'){
        maze[r][c] = '.';
        return solve(r+moves[i], c+moves[i+1]);
      }
    }
    return false;
  }

  public int countPath(){
    return 0;
  }

  public static void main(String args[]){
    Maze test = new Maze(args[0]);
    System.out.println(test.toString());
    test.solve();
    System.out.println(test.toString());
  }
}
