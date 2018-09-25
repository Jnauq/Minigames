/**
 * 
 */
package ca.bcit.comp1510.practiceprogs;

import java.util.Scanner;
import java.util.Random;

/**
 * @author Justin
 *
 */
public class TestingMethods {
    private static int userScore;
    
    
    public static void play() {
        int start;
        
        System.out.println("Please select one of the options below:");
        System.out.println("1. Your score.");
        System.out.println("2. Number Guesser");
        System.out.println("3. Addition problems");
        System.out.println("4. Higher or Lower.");
        System.out.println("5. Rock Paper Scissors.");
        System.out.println("6. Quit.");
        
        Scanner sc = new Scanner(System.in);
        start = sc.nextInt();
        
        switch (start) {
            case 1:
                System.out.println("Your score is: " + userScore);
                play();
                break;
            case 2:
                numberGuess();
                break;
            case 3:
                mathProbs();
                break;
            case 4:
                highLow();
                break;
            case 5:
                rockPaperScissors();
                break;
            case 6:
                System.out.println("Thanks for playing.  You final score was "
                        + userScore);
                break;
            default:
                System.out.println("You didn't pick a valid option.");
                play();
        }
        sc.close();
        
        
    }
    
    public static void numberGuess() {
        int pcNum;
        int userNum;
        int start = 101;
        int attempt = 0;
        
        Random rand = new Random();
        pcNum = rand.nextInt(101);
        Scanner sc = new Scanner(System.in);
        
        while (start != pcNum) {
            System.out.println("I've picked a number between 0 and 100 inclusive"
                    + ", can you guess it? You get 7 tries.");
            userNum = sc.nextInt();
            
            if (userNum > pcNum) {
                System.out.println("Too high!");
                attempt++;
            } else if (userNum < pcNum) {
                System.out.println("Too low!");
                attempt++;
            } else if (userNum == pcNum) {
                System.out.println("Correct!");
                start = pcNum;
                if (attempt < 8) {
                    userScore += 5;
                    System.out.println("+5 points");
                } else {
                    userScore -= 3;
                    System.out.println("More than 7 guesses. -3 points");
                }
            }
        }
        play();
        sc.close();
        
    }
    
    public static void mathProbs() {
        int firstNum;
        int secondNum;
        int userGuess;
        int sum;
        
        Random rand = new Random();
        firstNum = rand.nextInt(500) + 15;
        secondNum = rand.nextInt(500) + 15;
        
        sum = firstNum + secondNum;
        
        System.out.println("What is " + firstNum + " + " + secondNum + "?");
        
        Scanner sc = new Scanner(System.in);
        userGuess = sc.nextInt();
        
        if (userGuess == sum) {
            System.out.println("Correct! +1 point");
            userScore += 1;
        } else {
            System.out.println("Wrong. -1 point");
            userScore -= 1;
        }
        play();
        sc.close();
    }
    
    public static void highLow() {
        int numOne;
        int numTwo;
        int user = 0;
        int answer;
        
        Random rand = new Random();
        numOne = rand.nextInt(11);
        numTwo = rand.nextInt(11);
        
        Scanner sc = new Scanner(System.in);
        
        if (numOne != numTwo) {
        System.out.println("Both numbers are between 0 and 10 inclusive.");
        System.out.println("First number is: " + numOne + ". Will the second number be "
                + "higher or lower? Press 1 for higher. 2 for lower.");
        user = sc.nextInt();
        
        System.out.println("The second number is: " + numTwo);
        } else {
            highLow();
        }
        
        if (numOne > numTwo) {
            answer = 2;
        } else {
            answer = 1;
        }
        
        if (user == answer) {
            System.out.println("Nice! +5 points");
            userScore += 5;
        } else {
            System.out.println("Sorry! -3 points");
            userScore -= 3;
        }
        play();
        sc.close();
        
        
    }
    public static void rockPaperScissors() {
        int randNum;
        String userPick;
        String pcPick = null;
        String input;
        String r = "rock";
        String p = "paper";
        String s = "scissors";
        
        Scanner scan = new Scanner(System.in);
       
        System.out.println("Let's play!\nPick rock, paper or scissors: ");
        input = scan.next();
        
        while (input.equals(r) == false && input.equals(p) == false && 
                input.equals(s) == false) {
            System.out.println("Not valid! Try again!");
            input = scan.next();
        } 
            
        userPick = input;
        
        Random rand = new Random();
        randNum = rand.nextInt(3);
        
        if (randNum == 0) {
            pcPick = "rock";
        } else if (randNum == 1) {
            pcPick = "paper";
        } else if (randNum == 2) {
            pcPick = "scissors";
        }
        
                
        if (userPick.equals(pcPick)) {
            System.out.println("It's a tie!");
        } else if (userPick.equals("rock")) {   
            if (pcPick.equals("paper")) {
                System.out.println("You lose. -3 points.");
                userScore -= 3;
            } else if (pcPick.equals("scissors")) {
                System.out.println("You win! +5 points!");
                userScore += 5;
            }
        } else if (userPick.equals("paper")) {
            if (pcPick.equals("scissors")) {
                System.out.println("You lose. -3 points.");
                userScore -= 3;
            } else if (pcPick.equals("rock")) {
                System.out.println("You win! +5 points!");
                userScore += 5;
            }
        } else if (userPick.equals("scissors")) {
            if (pcPick.equals("rock")) {
                System.out.println("You lose. -3 points.");
                userScore -= 3;
            } else if (pcPick.equals("paper")) {
                System.out.println("You win! +5 points!");
                userScore += 5;
            }
        }
        
        play();
        scan.close();
    }    
    
    
    public static void main(String[] args) {
        play();
    }
}
