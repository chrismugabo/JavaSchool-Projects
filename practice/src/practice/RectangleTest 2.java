package practice;

public class RectangleTest {

	public RectangleTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// Create two Rectangles then see if they're equal
		Rectangle firstRec = new Rectangle(12, 20);
		Rectangle secondRec = new Rectangle(12, 20);
		
		if (firstRec.equals(secondRec))
			System.out.println(" Two equal Rectangles");

	}

}
