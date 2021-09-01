
public class Assignment_2 {
	
	//finds the max value, prints it's position and returns the max value
	//This assumes that all inner arrays are the same size
	public static int getMaxElement(int arr[][]) {
		
		int rows = arr.length;
		int cols = arr[0].length;
		//variables to store i, and j to print location
		int a = 0;
		int b = 0;
		
		//set current max value to lowest possible number as a place holder
		int maxElement = Integer.MIN_VALUE;
		
		//search rows and columns for max element comparing to current maxElement
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(arr[i][j] > maxElement) {
					maxElement = arr[i][j];
					a=i;
					b=j;
				}
			}
		}
		
		System.out.printf("The maximum value is located at arr[%d][%d].",a,b);
		
		return maxElement;
	}

	public static void main(String[] args) {
		
		int mat[][] = { { 1, 2, 3, 4 },
                { 25, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15,99 } };
		
		int result = getMaxElement(mat);
		
		System.out.println("The maximum element is "+result+".");

	}

}
