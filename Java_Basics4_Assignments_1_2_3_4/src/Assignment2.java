/*
*
*JAVA Basics 4
*Assignment 2
* John Crume
* 9/2/2021
*/
public class Assignment2 {

	public static void main(String[] args) {
		 final Object resourceOne = "res1";
	        final Object resourceTwo = "res2";
	         
	        new Thread(new Runnable() {
	             
	            @Override
	            public void run() {
	                 
	                synchronized(resourceOne) {
	                    System.out.println(Thread.currentThread().getName() + " accquired resource 1");
	                    try {
	                        Thread.sleep(2000);
	                    } catch (InterruptedException e) {
	                        
	                        e.printStackTrace();
	                    }
	                    synchronized(resourceTwo) {
	                        System.out.println(Thread.currentThread().getName() + " accquired resource 2");
	                    }
	                }
	            }
	        }).start();
	         
	        new Thread(new Runnable() {
	             
	            @Override
	            public void run() {
	                synchronized(resourceTwo) {
	                    try {
	                        Thread.sleep(2000);
	                    } catch (InterruptedException e) {
	                        // TODO Auto-generated catch block
	                        e.printStackTrace();
	                    }
	                    System.out.println(Thread.currentThread().getName() + " accquired resource 2");
	                    synchronized(resourceOne) {
	                        System.out.println(Thread.currentThread().getName() + " accquired resource 1");
	                    }
	                }
	            }
	        }).start();
	         

	}

}
