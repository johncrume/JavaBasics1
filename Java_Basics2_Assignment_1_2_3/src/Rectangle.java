import java.text.DecimalFormat;

public class Rectangle implements Shape {
	
	double length;
	double width;
	double area;
	
	//Constructor takes length and width
	public Rectangle(double len, double wid) {
		length = len;
		width = wid;
		
	}
	
	//Calculates the area of a rectangle use Area = length*width
	public double calculateArea() {
		return area = length*width;
	}
	
	//Prints area of rectangle to console 
	public void display() {
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		
		System.out.println("The rectangle area is "+numberFormat.format(calculateArea())+".");
		
	}

	public static void main(String[] args) {
		
		
		Rectangle r = new Rectangle(5,10);
		
		System.out.println("The rectangle length is " + r.length +" and the width is "+ r.width+".");
		
		
		r.display();

	}

}
