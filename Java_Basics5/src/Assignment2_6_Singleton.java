import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/*
Java Basics 5
Assignment 2-1
John Crume
9/7/2021
*/
@SuppressWarnings("unused")
public class Assignment2_6_Singleton {

	
	public static class SampleSingleton {

		private static Connection conn = null;
		
		private static SampleSingleton instance = null;
		
		public static SampleSingleton getInstance() {
			if(instance ==null) {
				synchronized (SampleSingleton.class) {
					if(instance == null) {
						instance = new SampleSingleton();
					}
				}
			}
			return instance;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
