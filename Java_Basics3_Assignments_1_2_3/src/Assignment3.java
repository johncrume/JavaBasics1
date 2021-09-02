
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
*
*JAVA Basics 3
*Assignment 3
* John Crume
* 9/1/2021
*/


public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner userIn = new Scanner(System.in);
		
		System.out.println("Enter a character to search:");
		
		char a = userIn.next().charAt(0);
		
		userIn.close();
		int count =0;
		File file = new File("src/Assignment3.txt");
				
		try {
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        String line = null;
	        while ((line = reader.readLine()) !=null) {
	            for(int i=0; i<line.length();i++){
	                if(line.charAt(i) == a){
	                    count++;
	                }
	            }
	        }
	        reader.close();
	        System.out.println("The character "+a+" was counted "+count+" times.");
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	       e.printStackTrace();
	    }


	}

}