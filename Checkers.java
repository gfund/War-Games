import java.util.Scanner;

class Checkers {
  public static String[][] cases = new String[10][10];
  public static String playerTurn = "O";
  public static String otherPlayer = "X";
  public static Boolean playing = true;
  public static int playerLives = 0;
  public static int otherPlayerLives = 0;
  public static String killableCase = "";
  public static String killerCase = "";
  
  public static void game(String[] args) {
    instantiateCases();
    while(playing){
      clearConsole();
      System.out.println("It is player " + playerTurn + "'s turn");
      drawGrid();
      if (checkKillablePawns()){
        System.out.println("An ennemy pawn is killable at " + killableCase +" from " + killerCase + ", you have no choice to kill it!");
        System.out.println("Write 'OK' and press 'Enter' to continue!");
        String a = getInput();
      }
      else{
        System.out.print("Choose a pawn to move and where to move it :\n");
        System.out.println("Ex. : Take the pawn from A6 and move it to B5 --> Write : A6B5");
        Boolean notGoodInput = true;
        int[][] moves = new int[2][2];
        while(notGoodInput){
          String input = getInput();
          if (checkInput(input)){
            moves = formatMovement(input);
            System.out.println("You want to move the " + playerTurn + " pawn from " + input.substring(0,2) + " to " + input.substring(2) + ".");
            if (!possibleMovement(moves)){
              System.out.print(" Try again!\n");
            }
            else{
              movePawn(moves);
              notGoodInput = false;
            }
          }
          else{
            System.out.println("The movement you wrote is not in the good format! Try again!");
          }
        }
      }
      if (checkWinner()){
        playing = false;
      }
      switchPlayer();
    }
  }
  
  public static void drawGrid(){
    System.out.println("     A     B     C     D     E     F     G     H     I     J");
    System.out.print("   _____ _____ _____ _____ _____ _____ _____ _____ _____ _____\n");
    for (int i = 0; i < 10; i++){
      System.out.print("  |     |     |     |     |     |     |     |     |     |     |\n");
      String caseInside = i + " |";
      for (int j = 0; j < 10; j++){
        caseInside += "  " + cases[i][j] + "  |";
      }
      System.out.print(caseInside + "\n");
      System.out.print("  |_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|\n");
    }
  }
  
  public static void instantiateCases(){
    for (int i = 0; i < 10; i++){
      for (int j = 0; j < 10; j++){
        if (i == 0 || i == 2){
          cases[i][j] = ((j%2) == 0) ? otherPlayer : " ";
          otherPlayerLives++;
        }
        else if (i == 1 || i == 3){
          cases[i][j] = ((j%2) != 0) ? otherPlayer : " ";
          otherPlayerLives++;
        }
        else if (i == 7 || i == 9){
          cases[i][j] = ((j%2) != 0) ? playerTurn : " ";
          playerLives++;
        }
        else if (i == 8 || i == 6){
          cases[i][j] = ((j%2) == 0) ? playerTurn : " ";
          playerLives++;
        }
        else{
          cases[i][j] = " ";
        }
      }
    }
  }
  
  public static Boolean movePawn(int[][] moves){
    cases[moves[1][1]][moves[1][0]] = cases[moves[0][1]][moves[0][0]];
    cases[moves[0][1]][moves[0][0]] = " ";
    return true;
  }
  
  public static Boolean possibleMovement(int[][] moves){
    String currentCase = cases[moves[0][1]][moves[0][0]];
    String nextCase = cases[moves[1][1]][moves[1][0]];
    if (currentCase != playerTurn){
     System.out.print("You have no pawn in that cell!");
     return false;
    }
    if (moves[0][0] != (moves[1][0]-1) && moves[0][0] != (moves[1][0]+1)){
      System.out.print("Your pawn can only advance 1 diagonally!");
      return false;
    }
    if (moves[0][1] != (moves[1][1]-1) && moves[0][1] != (moves[1][1]+1)){
      System.out.print("Your pawn can only advance 1 diagonally!");
      return false;
    }
    if (nextCase == playerTurn){
      System.out.print("The cell you want to go already contains one of your pawn!");
      return false;
    }
    return true;
  }
  
  public static int[][] formatMovement(String move){
    int[][] movement = new int[2][2];
    movement[0][0] = move.charAt(0)-65;
    movement[0][1] = move.charAt(1)-48;
    movement[1][0] = move.charAt(2)-65;
    movement[1][1] = move.charAt(3)-48;
    return movement;
  }
  
  public static String getInput(){
    Scanner sc = new Scanner(System.in);
    if(sc.equals("\\n")){ 
      return "";
    }
    return sc.next();
  }
  
  public static Boolean checkInput(String move){
    if (move.length() != 4){
      System.out.println("The movement you write should be 4 characters long! (letter-number-letter-number)");
      return false;
    }
    if (move.charAt(0) < 'A' || move.charAt(0) > 'J' || move.charAt(2) < 'A' || move.charAt(2) > 'J'){
      System.out.println("One of the cells you specified does not exist!");
      return false;
    }
    if (move.charAt(1) < '0' || move.charAt(1) > '9' || move.charAt(3) < '0' || move.charAt(3) > '9'){
      System.out.println("One of the cells you specified does not exist!");
      return false;
    }
    return true;
  }
  
  public static void switchPlayer(){
    String b = playerTurn;
    playerTurn = otherPlayer;
    otherPlayer = b;
    int a = playerLives;
    playerLives = otherPlayerLives;
    otherPlayerLives = a;
  }
  
  public static Boolean checkWinner(){
    if (playerLives == 0 || otherPlayerLives == 0){
      System.out.println("GAME OVER!");
      return true;
    }
    return false;
  }
  
  public static Boolean checkKillablePawns(){
    for (int i = 0; i < cases.length; i++){
      for (int j = 0; j < cases[i].length; j++){
        if (cases[i][j] == playerTurn){
          char g = (char) (j + 65);
          if (i<=7 && j>=2 && cases[i+1][j-1] == otherPlayer && cases[i+2][j-2] == " "){
            cases[i+1][j-1] = " ";
            cases[i+2][j-2] = playerTurn;
            cases[i][j] = " ";
            char letter = (char)((j-1) + 65);
            killableCase = "" + letter + Integer.toString(i+1);
            killerCase = "" + g +"" + i;
            otherPlayerLives--;
            return true;
          }
          else if (i<=7 && j<=7 && cases[i+1][j+1] == otherPlayer && cases[i+2][j+2] == " "){
            cases[i+1][j+1] = " ";
            cases[i+2][j+2] = playerTurn;
            cases[i][j] = " ";
            char letter = (char)((j+1) + 65);
            killableCase = "" + letter + Integer.toString(i+1);
            killerCase = "" + g +"" + i;
            otherPlayerLives--;
            return true;
          }
          else if (i>=2 && j>=2 && cases[i-1][j-1] == otherPlayer && cases[i-2][j-2] == " "){
            cases[i-1][j-1] = " ";
            cases[i-2][j-2] = playerTurn;
            cases[i][j] = " ";
            char letter = (char)((j-1) + 65);
            killableCase = "" + letter + Integer.toString(i-1);
            killerCase = "" + g +"" + i;
            otherPlayerLives--;
            return true;
          }
          else if (i>=2 && j<=7 && cases[i-1][j+1] == otherPlayer && cases[i-2][j+2] == " "){
            cases[i-1][j+1] = " ";
            cases[i-2][j+2] = playerTurn;
            cases[i][j] = " ";
            char letter = (char)((j+1) + 65);
            killableCase = "" + letter + Integer.toString(i-1);
            killerCase = "" + g +"" + i;
            otherPlayerLives--;
            return true;
          }
        }
      }
    }
    return false; 
  }
  
  public static void clearConsole(){
    for (int i = 0; i < 10; i++){
      System.out.println("\n");
    }
  }
  
}