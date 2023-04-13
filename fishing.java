import java.util.*;
class Main{

  public static Scanner input = new Scanner(System.in);
  public static int row, col, catchCount = 0;
  //where the fish are hiding
  public static String[][] game = {{"~~~~~", "~~~~~", "~~~~~", "~~~~~", "><((>"},
                                   {"~~~~~", "~~~~~", "~~~~~", "~~~~~", "~~~~~"},
                                   {"~~~~~", "><((>", "~~~~~", "~~~~~", "~~~~~"},
                                   {"~~~~~", "~~~~~", "~~~~~", "~~~~~", "~~~~~"},
                                   {"~~~~~", "~~~~~", "~~~~~", "><((>", "~~~~~"}};
  //the gameboard the user sees
  public static String[][] lake = {{"    Y X  ", "  1   ", "   2  ", "   3  ", "   4  ", "   5  "},
                                   {"    1    ", "~~~~~~", "~~~~~~", "~~~~~~", "~~~~~~", "~~~~~~"},
                                   {"    2    ", "~~~~~~", "~~~~~~", "~~~~~~", "~~~~~~", "~~~~~~"},
                                   {"    3    ", "~~~~~~", "~~~~~~", "~~~~~~", "~~~~~~", "~~~~~~"},
                                   {"    4    ", "~~~~~~", "~~~~~~", "~~~~~~", "~~~~~~", "~~~~~~"},
                                   {"    5    ", "~~~~~~", "~~~~~~", "~~~~~~", "~~~~~~", "~~~~~~"}};
  public static void main(String[] args){ 
    //keeps game running while all 3 fish haven't been caught
    while(catchCount<3){
      System.out.print("\033\143");
      System.out.println("Go fishing!");
      printLake();
      guessCoordinates();
      checkGuess();
    }
    //the while loop stops when all 3 are found
    System.out.print("Great job! You caught your limit!");
  }
  public static void printLake(){
    for(int i = 0; i < 6; i++){
      for(int j = 0; j < 6; j++){
        System.out.print(lake[i][j]);
      }
      System.out.println(); 
    }
  }
  public static void guessCoordinates(){
    System.out.println("What coordinate would you like to fish?");
    System.out.print("X: ");
    col = input.nextInt()-1;
    System.out.print("Y: ");
    row = input.nextInt()-1;
  }
  public static void checkGuess(){
    if(game[row][col].equals("><((>")){
      System.out.println("You  caught a fish!  ><((>");
      lake[row+1][col+1]= " ><((>";
      catchCount++;
      System.out.println("Your catch count is "+ catchCount +". You need 3!");
    }else{
      System.out.println("~Empty Water~");
    }
    input.nextLine();
    input.nextLine();
  }
}