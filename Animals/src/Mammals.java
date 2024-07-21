public class Mammals implements Animals {

//Class Attributes
protected String name;
protected int age;
protected double weight;

//Mammals Constructor
public Mammals(String name,int age,double weight) {
	this.name=name;
	this.age=age;
	this.weight=weight;
}
 
//Speak method
public void speak() {
	System.out.println("Mammals can't speak.");
}

//Setters
public void setName(String name) {
	this.name=name;
}
public void setAge(int age) {
	this.age=age;
}
public void setWeight(double weight) {
	this.weight=weight;
}

//getters
public String getName() {
return name;
}
public int getAge() {
return age;
}
public double getWeight() {
return weight;
}

}