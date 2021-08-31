/*
 *
 *JAVA Basics 1
 *Assignment 1
 * John Crume
 * 8/30/2021
*/
public class Assignment1 {

	// print half triangle
	public static void halfTri(int n) {
		int i, j;

		for (i = 0; i < n; i++) {

			for (j = 0; j <= i; j++) {

				System.out.print("* ");
			}

			System.out.println();
		}

	}

	// print flipped half triangle
	public static void flippedHalfTri(int n) {
		int i, j;

		for (i = 0; i < n; i++) {
			for (j = n; j > i; j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	// print full triangle
	public static void triangle(int n) {
		// loop for each row
		for (int i = 1; i < n; i++) {
			// print the spaces
			for (int j = n - i; j > 1; j--) {
				System.out.print(" ");
			}
			// print the stars
			for (int j = 0; j < i; j++) {
				System.out.print("* ");
			}
			// move to a new line
			System.out.println();
			i += 1;
		}
	}

	public static void flippedTriangle(int n) {

		// loop for each row
		for (int i = 0; i < n; i++) {
			// print the spaces
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			// print the stars
			for (int j = n - i; j > 1; j--) {
				System.out.print("* ");
			}
			// move to a new line
			System.out.println();
			i += 1;
		}

	}

	public static void main(String[] args) {

		int n = 4;
		halfTri(n);
		System.out.println();
		flippedHalfTri(4);
		System.out.println();
		triangle(8);
		System.out.println();
		flippedTriangle(8);

	}
}