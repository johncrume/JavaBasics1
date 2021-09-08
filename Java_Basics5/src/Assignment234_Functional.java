import java.util.ArrayList;
import java.util.List;

/*
Java Basics 5
Assignment2- 2,3,4
John Crume
9/7/2021
*/
public class Assignment234_Functional {
	
	
	
	/*
	 * Assignment 2: Functional Given a list of non-negative integers, return an
	 * integer list of the rightmost digits. (Note: use %)
	 * 
	 * rightDigit([1, 22, 93]) → [1, 2, 3] rightDigit([16, 8, 886, 8, 1]) → [6, 8,
	 * 6, 8, 1] rightDigit([10, 0]) → [0, 0]
	 */
	
	public List<Integer> rightDigit(List<Integer> l){
		l.replaceAll(n -> n%10);
		return l;
	}

	
	/*
	 * Assignment 3: Functional Given a list of integers, return a list where each
	 * integer is multiplied by 2.
	 * 
	 * doubling([1, 2, 3]) → [2, 4, 6] doubling([6, 8, 6, 8, -1]) → [12, 16, 12, 16,
	 * -2] doubling([]) → []
	 */

	
	public List<Integer> doubling(List<Integer> l){
		 l.replaceAll(n -> n*2);
		 return l;
	}

	/*
	 * Assignment 4: Functional Given a list of strings, return a list where each
	 * string has all its "x" removed.
	 * 
	 * noX(["ax", "bb", "cx"]) → ["a", "bb", "c"] noX(["xxax", "xbxbx", "xxcx"]) →
	 * ["a", "bb", "c"] noX(["x"]) → [""]
	 */
	
	public List<String> noX(List<String> l){
		l.replaceAll(s -> s.replace("x", ""));
		return l;
		
	}

	
	public static void main(String[] args) {
		Assignment234_Functional af = new Assignment234_Functional();
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(22);
		l1.add(93);
		List<Integer >ans = af.rightDigit(l1);
		System.out.println(ans);
		
		ans = af.doubling(ans);
		System.out.println(ans);
		
		List<String> s1 = new ArrayList<String>();
		s1.add("ax");
		s1.add("bb");
		s1.add("cx");
		List<String> ans1 = af.noX(s1);
		System.out.println(ans1);
		
		
		

	}

}
