
public class Dogs extends Mammals {
	//private attribute
private String breed;

//Dogs Constructor
public Dogs(String name,int age,double weight,String breed) {
	super(name,age,weight);
	this.breed=breed;
}
// Getter
public String getBreed() {
    return breed;
}

// Setter
public void setBreed(String breed) {
    this.breed = breed;
}

//override method
public void speak() {
	System.out.println("Woof woo3!");
}
}
