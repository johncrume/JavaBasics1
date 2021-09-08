/*
Java Basics 5
Assignment 2-5
John Crume
9/7/2021
*/
public class Assignment5_Recursion {
	/*
	 * Assignment 5: Recursion Given an array of ints, is it possible to choose a
	 * group of some of the ints, such that the group sums to the given target, with
	 * this additional constraint: if there are numbers in the array that are
	 * adjacent and the identical value, they must either all be chosen, or none of
	 * them chosen. For example, with the array {1, 2, 2, 2, 5, 2}, either all three
	 * 2's in the middle must be chosen or not, all as a group. (one loop can be
	 * used to find the extent of the identical values).
	 * 
	 * groupSumClump(0, [2, 4, 8], 10) → true groupSumClump(0, [1, 2, 4, 8, 1], 14)
	 * → true groupSumClump(0, [2, 4, 4, 8], 14) → false
	 */

	
	
	public boolean groupSumClump(int start, int []numberList,int target) {
		
		if(start >= numberList.length) {
			if(target==0) {
				return true;
			}else {
				return false;
			}
		}
		int i = start+1;
		int sum =numberList[start];
		int count=1;
		
		while(i<numberList.length) {
			if(numberList[i] ==numberList[start]) {
				sum+=numberList[i];
				count++;
			}
			
			i++;
		}
		
				
		return groupSumClump(start+count,numberList,target-sum) || groupSumClump(start+count,numberList,target);
	}

	public static void main(String[] args) {
		Assignment5_Recursion as = new Assignment5_Recursion();
		
		int[] numberList = new int[] {2, 4, 8}; 
		
		boolean ans = as.groupSumClump(0, numberList, 10);
		
		System.out.println(ans);
		
	}

}
