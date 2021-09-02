import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/*
*
*JAVA Basics 3
*Assignment 1
* John Crume
* 9/1/2021
*/

public class Assignment1 {
	
	

	public static void main(String[] args) {
		
		
		 try (Stream<Path> paths = Files.walk(Paths.get("src/ExampleDir"), 5)) {
	            paths.filter(Files::isRegularFile)
	                    .forEach(System.out::println);
	        }catch(IOException e){
		         e.printStackTrace();
		      }
	}

}
