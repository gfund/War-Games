//Purpose to produce an AI simliar to the AI From the movie WarGames
import java.util.Scanner;
import java.util.ArrayList; 

public class Main {
  
  

  public static  void main(String[] args) {

  
        
 
Scanner myObj = new Scanner(System.in);

  System.out.println("Shall we play a game?");

    // String input
    String Response = myObj.nextLine();


if(Response.equalsIgnoreCase("yes")){
    System.out.println("Which of the following would you like to play?");


    //array list of options
ArrayList<String> options = new ArrayList<String>();
    options.add("Thermonuclear War");
    options.add("Chess");
    options.add("Checkers");
    options.add("Backgammon");
    options.add("Poker");
    options.add("Falken's maze");
    options.add("Theaterwide Biotoxic and Chemical Warfare");
    System.out.println(options);

// String input
    String Answer = myObj.nextLine();

    //Bring the if statements
  if(Answer.equals(options)){ //reference stuff in array

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