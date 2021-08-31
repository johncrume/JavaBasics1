/*
 *
 *JAVA Basics 1
 *Assignment 2
 * John Crume
 * 8/30/2021
*/


import java.util.Random;
import java.util.Scanner;

public class Assignment2{
	
	public static boolean isWithinTen(int num, int guess) {
		boolean inTen = true;
		int lower = num -10;
		int upper = num + 10;
		
		if(guess >= lower && guess<= upper) {
			inTen = true;
		}else {
			inTen = false;
		}
		return inTen;
		
	}
	//generates a number between 0 and 100
	public static int getRandomNum() {
		Random r = new Random();
		int rand = r.nextInt(101);
		
		return rand;
	}
	
	
	public static void main(String[] args) {
		//get the random number between 0 and 100
		int num = getRandomNum();
		//System.out.println(num); for debugging to know what the number is
		//Create input scanner object
		Scanner userIn = new Scanner(System.in);
		//get user input
		System.out.println("Enter an integer between 0 and 100: ");
		int userGuess = userIn.nextInt();
		int attempt = 1;
		
		//repeat the attempts
		while(attempt<=5) {
			if(isWithinTen(num, userGuess)) {//if it is within 10 of the generated number then exit
				System.out.println("The correct answer is "+num+".");
				userIn.close();
				System.exit(0);
			}else {//if the user guess is not with in 10 then try again and update number of attempts
				System.out.println("Enter another guess: ");
				userGuess = userIn.nextInt();
				attempt++;
			}
			//check if the number of attempts has reached 5 if so exit 
			if(attempt == 5) {
				userIn.close();
				System.out.println("Sorry...The answer was "+num+".");
				System.out.println("Thanks for playing. \n GOODBYE!");
				System.exit(0);
			}
		}
		
		
		
	
		
		
	}
}