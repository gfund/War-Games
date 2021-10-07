//Purpose to produce an AI simliar to the AI From the movie WarGames
import java.util.Scanner;
import java.util.*;

public class Main {

  static List<String>  options = new ArrayList<>(List.of("Thermonuclear War","Chess","Checkers","Backgammon","Poker","Falken's maze","Theaterwide Biotoxic and Chemical Warfare"));
  public static void consoleprint(String output) throws InterruptedException{

    for (char i :output.toCharArray()){

        System.out.print("\u001b[38;5;34m"+i+"\u001B[0m");
        
        Thread.sleep(100);
   
    }
   
      
  }
  
  
  
  public static  void main(String[] args) throws InterruptedException {

    
Scanner myObj = new Scanner(System.in);

  try {
    consoleprint("Shall we play a game?");
  } catch (InterruptedException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }

    // String input
    String Response = myObj.nextLine();


if(Response.equalsIgnoreCase("yes")){
    System.out.println("Which of the following would you like to play?");


    //array list of options
   
   
    consoleprint(options.toString()+'\n');

// String input
    String Answer = myObj.nextLine();

    //Bring the if statements
  if(true){ //reference stuff in array

    if(Answer.equalsIgnoreCase("Thermonuclear War")){
      System.out.println("Preparing Thermonuclear War");
    }

    if(Answer.equalsIgnoreCase("chess")){
      System.out.println("Preparing Chess");
     
    }

    if(Answer.equalsIgnoreCase("checkers")){
      System.out.println("Preparing Checkers");
      

    }

    if(Answer.equalsIgnoreCase("poker")){
      System.out.println("Preparing Poker");
    }

    if(Answer.equalsIgnoreCase("backgammon")){
      System.out.println("Preparing Backgammon");
    }
    if(Answer.equalsIgnoreCase("Falken's maze")){
      System.out.println("Preparing Falken's maze");
    }
    if(Answer.equalsIgnoreCase("Theaterwide Biotoxic and Chemical Warfare")){
      System.out.println("Preparing Theaterwide Biotoxic and Chemical Warfare");
    }

    }
    else{
      System.out.println("Input Not understood, Good Bye Professor Falken");
    }
  }


    

    //else{
     // System.out.println("Input Not understood, Good //Bye Professor Falken");
    //}

      

if(Response.equalsIgnoreCase("no")){
      System.out.println("Okay, Have a good day");
    }
    //else{
   //   System.out.println("Response Not Understood, Good Bye Professor Falken");
  //  }
  }
  
}