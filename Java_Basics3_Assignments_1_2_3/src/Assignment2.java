import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/*
*
*JAVA Basics 3
*Assignment 2
* John Crume
* 9/1/2021
*/

public class Assignment2 {

	public static void main(String[] args) {
		
		try {
	         String data = " Fear is the path to the dark side. Fear leads to anger; anger leads to hate; hate leads to suffering. I sense much fear in you.";
	         File f = new File("src/Yoda.txt");
	         FileWriter fileWriter = new FileWriter(f.getName(),true);
	         BufferedWriter bw = new BufferedWriter(fileWriter);
	         bw.write(data);
	         bw.close();
	         System.out.println("Done");
	      } catch(IOException e){
	         e.printStackTrace();
	      }

	}

}
