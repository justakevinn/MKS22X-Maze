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
      row = 0;
      String line = "";
      File text = new File(filename);
      Scanner inf = new Scanner(text);
      moves = new int[] {1,0,0,1,-1,0,0,-1};
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

    private void wait(int millis){
           try {
               Thread.sleep(millis);
           }
           catch (InterruptedException e) {
           }
       }
    public void setAnimate(boolean b){
          animate = b;
      }

    public void clearTerminal(){
          //erase terminal, go to top left of screen.
          System.out.println("\033[2J\033[1;1H");
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
    return solve(r, c);
  }


  public int solve(int r, int c){
    if (maze[r][c] == 'E'){
      return 1;
    }
    else if (maze[r][c] == '#' || maze[r][c] == '@' || maze[r][c] == '.') {
			return 0;
		}
    maze[r][c] = '@';
    for (int i = 0; i < moves.length; i +=2) {
      int x = solve(r+moves[i],c+moves[i+1]);
			if (x > 0) {
				return  x;
			}
		}
		maze[r][c] = '.';
		return -1;
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
