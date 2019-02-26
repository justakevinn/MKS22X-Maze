import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze{

    public static void main(String args[]){
      try{
        File text = new File(args[0]);
        Scanner inf = new Scanner(text);
        while(inf.hasNextLine()){
          String line = inf.nextLine();
          System.out.println(line);//hopefully you can do other things with the line
        }
      }
      catch (FileNotFoundException e){
        System.out.println("File Not Found");
      }
    }
}
