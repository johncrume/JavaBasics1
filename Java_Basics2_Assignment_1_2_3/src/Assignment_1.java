import java.util.Scanner;

public class Assignment_1 {
	
	
	//adds 3 values and prints the result to the console
	public static void printAddition(int a, int b, int c) {
		System.out.println("The result is " +(a+b+c)+".");
	}
	
	public static void main(String [] args) {
		
		int a, b, c;
		
		Scanner userIn = new Scanner(System.in);
		
		System.out.println("Enter a number to add:");
		
		a = userIn.nextInt();
		
		System.out.println("Enter a second number to add:");
		
		b = userIn.nextInt();
		
		System.out.println("Enter a last number to add:");
		
		c = userIn.nextInt();
		
		userIn.close();
		
		printAddition(a,b,c);
		
		
	}

}
