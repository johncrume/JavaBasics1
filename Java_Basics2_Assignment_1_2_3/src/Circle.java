import java.text.DecimalFormat;

public class Circle implements Shape {

	double radius;
	
	double area;
	
	//Circle contructor initializes radius variable
	public Circle(double rad) {
		radius = rad;
		
	}
	//calculate the area of a circle using formula A=pi*r^2
	public double calculateArea() {
		return area = Math.PI*radius*radius;
	}
	//print circle area to console
	public void display() {
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		
		
		System.out.println("The circle area is "+numberFormat.format(calculateArea())+".");
	}
	public static void main(String[] args) {
		
		Circle c = new Circle(5);
		
		System.out.println("The circle radius is " + c.radius +".");
		
		c.display();


	}

}
