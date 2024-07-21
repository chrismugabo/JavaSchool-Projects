 public class Tester {
public static void main(String[] args) {
// Test the Mammals class
Mammals mammal = new Mammals("Elephant", 20, 1000);
mammal.speak(); // Output: Mammals can't speak.
System.out.println(mammal.getName() + " " + mammal.getAge() + " " + mammal.getWeight());

// Test the Dogs class
Dogs dog = new Dogs("Golden Retriever", 2, 10, "Golden Retriever");
dog.speak(); // Output: Woof woof!
System.out.println(dog.getName() + " " + dog.getAge() + " " + dog.getWeight() + " " + dog.getBreed());

// Test the Cats class
Cats cat = new Cats("Siamese", 3, 5, "White");
cat.speak(); // Output: Meow!
System.out.println(cat.getName() + " " + cat.getAge() + " " + cat.getWeight() + " " + cat.getFurColor());

System.out.println(cat);
// Test the interface
Animals animal = new Dogs("dog1", 2, 10,"Golden Retriever"); 
animal.speak(); // Output: Woof woof!
}

}
