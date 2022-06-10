/*
Game class - wordle lite

From a arraylist of 20 five letter words the code will choose a random answer to the puzzle. User input guesses of five letters which the code will print a five letter string representing which letters are either in the right place with a O, wrong place with a -, or not in the code at all with a X

Author - Dylan Damstrom

Change history:
5/4: Created
version 0.1
*/
// import Hashmap source
//import java.util.Scanner;
import java.util.HashMap;


//class surround the entire code
public class GoodGame {
    
 
//an array of answers the game will randomly chose
  private static String[] possibleAnswers = {"SNACK", "SWORD", "ABOUT", "CRATE", "TOWEL", "STANG", "TRUCK", "POWER", "BLAZE", "OTHER", "GLEAM", "STRING", "BELOW", "VALID", "LIGHT", "MIGHT", "WHITE", "FLAKE", "ZEBRA", "VOICE", "VOCAL", "CHASE", "EIGHT", "WHALE", "GREAT", "FOCUS", "IMAGE", "STEAM", "TRAIN", "BREAD"};
//initialize answer and number of guesses
private String answer;
private int numGuess;
  

  public int play() {


//randomly choose an answer from the array
    answer = Utils.randChoice(possibleAnswers);
//Print a hello message and describe the game
    String guess = Utils.inputStr("\nHello, welcome to wordle lite, a O means its in the right place, a - means its in the wrong place, and X means it is not in the word. Press enter to continue: ");
//ask for user input for the difficulty 1-3 adjusting the amount of turns from 3-9
    int diff = Utils.inputNum("\ninput a number for your difficulty 1-3: ");

// exception handling for numbers and characters that aren't 1, 2, or 3
while (diff < 0 || diff > 3) {
  diff = Utils.inputNum("\ninput a valid number: ");
  }
// switch statement to adjust the amount of turns based the number inputed
  switch(diff){
      case 1:
        diff = 9;
        break;
      case 2:
        diff = 6;
        break;
      case 3:
        diff = 3;
        break;

      
      }

//secondary loop to limit the amount of guesses and repeat the input oppurtunity
for (int i = 0; i < diff; i++) {
//ask for the guess and change it to uppercase
  guess = Utils.inputStr("Enter your guess: ");
  guess = guess.toUpperCase();
//track the amount of guesses
  System.out.println("You have " + (diff - i) + " guesses left");
// handle longer than 5 exceptions
  while(guess.length() != 5){
  
    guess = Utils.inputStr("Enter your guess: ");
    guess = guess.toUpperCase();
    
  }
  
  //Correcting pattern
  for (int j = 0; j < 5; j++) {
    String substra = "";
    String substrb = "";
    substra = answer.substring(j, j+1);
    substrb = guess.substring(j, j+1);
//detect if any letters are in the right spot
     if (substra.equals(substrb) == true) {
       System.out.print("O");
       }
//detect if any letters are in the answer
       else if (answer.contains(substrb)){
        System.out.print("-");
       }
//detect if any letters are not in the answer
       else{
        System.out.print("X");
       }
  }
//space out the prints
  System.out.println();
     
       
      
        
        
//track the amount of guesses used for the hashmap     
   if (guess.equals(answer) == true) {
     numGuess = i;
    break;
    }
  }
//print the answer for the user
    System.out.println("Answer is " + answer);

    return numGuess;
  
    }
    
}

