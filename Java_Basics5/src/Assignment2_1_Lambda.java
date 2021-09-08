/*
Java Basics 5
Assignment 2-1
John Crume
9/7/2021
*/





import java.util.Scanner;
import java.util.InputMismatchException;


//functional interface
interface PerformOperation{
	boolean test(int a);
}
public class Assignment2_1_Lambda {
	
	public static boolean tester(PerformOperation p, int num) {
		return p.test(num);
	}
	
	public static PerformOperation isOdd() {
		PerformOperation odd = (int x)-> x%2 == 0 ? false:true;
		
		return odd;
	}

	public static PerformOperation isPrime() {
	
		PerformOperation prime = (int x) ->{
			if(x<=1) {
				return false;
			}else {
				for(int i = 2; i<= x/2; i++) {
					if((x%i)==0) {
						return false;
					}
				}
				
				return true;
			}
		};
		
		return prime;
	}
	
	public static PerformOperation isPalindrome() {
		PerformOperation pali = (int x) ->{
			int num = x, remainder =0, reversedNum =0;
			while( num !=0){
				remainder = num%10;
				reversedNum = reversedNum * 10 + remainder;
				num/=10;
			}
			
			if(x == reversedNum) {
				return true;
			}else { return false;}
		};
		
		return pali;
	}
	
	public static void main(String[] args) {
		
		//Assignment2_1_Lambda po = new Assignment2_1_Lambda();
		PerformOperation op;
		
		try {
			
			Scanner s = new Scanner(System.in);
			System.out.println("Enter number of test cases:");
			int numOfTestCases = s.nextInt(); 
			
			int [] arrs = new int[numOfTestCases];
			int [] check = new int[numOfTestCases];
			int i =0;
			System.out.println("Enter test case (condition integer):");
			while(i<numOfTestCases) {
				check[i] = s.nextInt();
				arrs[i]=s.nextInt();
				i++;
				System.out.println("Enter next test case(condition integer):");
			}
			s.close();
			int j = 0;
			String ans = "";
			boolean ret = false;
			while(j <numOfTestCases) {
											
				switch(check[j]) {
				
				case 1: op = Assignment2_1_Lambda.isOdd();
						ret = Assignment2_1_Lambda.tester(op,arrs[j]);
						ans = ret ? "ODD" : "EVEN";
						break;
				case 2: op = Assignment2_1_Lambda.isPrime();
						ret = Assignment2_1_Lambda.tester(op,arrs[j]);
						ans = ret ? "PRIME" : "COMPOSITE";		
						break;
				case 3: op = Assignment2_1_Lambda.isPrime();
						ret = Assignment2_1_Lambda.tester(op,arrs[j]);
						ans = ret ? "PRIME" : "COMPOSITE";		
						break;
				}
				
				System.out.println(ans);
			}
			
		}catch(InputMismatchException e) {
			e.printStackTrace();
			
		}

	}

}
