package com.st.jb.tests;
import org.junit.Test;
import com.st.jb.ff.Line;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LineTest {
	
	Line line  = new Line(1, 1, 2, 2);
	Line line1 = new Line(0,0,1,1);
	Line line2 = new Line(22,6,48,50);
	
	@Test
	public void testGetSlope() {
		assertEquals(1.0,line.getSlope(),0.0001);
		assertNotEquals(0.90,line.getSlope(),0.0001);
	}
	
	@Test
	public void testGetDistance() {
		assertEquals(1.4142,line.getDistance(),0.0001);
		assertNotEquals(5.099,line.getDistance(),0.0001);
	}
	@Test
	public void testParallelTo() {
		assertEquals(true,line.parallelTo(line1));
		assertNotEquals(false,line.parallelTo(line1));
		assertNotEquals(true,line.parallelTo(line2));
		
	}

}
