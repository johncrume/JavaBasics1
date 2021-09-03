/*
*
*JAVA Basics 4
*Assignment 1
* John Crume
* 9/2/2021
*/
public class Singleton {

	private static volatile Singleton _instance;
	
	public static Singleton getInstance() {
		if(_instance == null) {
			synchronized(Singleton.class) {
				if(_instance==null) {
					_instance = new Singleton();
				}
			}
		}
		
		return _instance;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
