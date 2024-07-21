//Cats inherits from Mammals
public class Cats extends Mammals {
	
	//private attribute
	private String furColor;
	
 //TosTRING METHOD
	public ToString() {
	}
	//Cats Constructor
	public Cats(String name,int age,double weight,String furColor) {
		super(name,age,weight);
		this.furColor=furColor;
	}
	// Getter
	public String getFurColor() {
	    return furColor;
	}

	// Setter
	public void setFurcolor(String furColor) {
	    this.furColor = furColor;
	}
	
	//override the method
	public void speak() {
		System.out.println("Woof woof!");
	}
}
