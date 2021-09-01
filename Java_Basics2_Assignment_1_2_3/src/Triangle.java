import java.text.DecimalFormat;

public class Triangle {
	
	double base;
	double height;
	double area;
	public Triangle(double b, double h) {
		base = b;
		height = h;
	}
	
	public double calculateArea() {
		return area = 0.5*base*height;
	}
	
	public void display() {
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		
		
		System.out.println("The triangle area is "+numberFormat.format(calculateArea())+".");
	}

	public static void main(String[] args) {

		Triangle t = new Triangle(12.5,17);
		
		System.out.println("The triangle base is " + t.base +" and the height is "+ t.height+".");
		
		t.display();
	}

}
