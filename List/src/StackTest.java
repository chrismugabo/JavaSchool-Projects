 

// Exercise 21.10 Solution: StackTest.java
// Program prints the words of a line in reverse
import java.util.Scanner;
import java.util.Stack;

public class StackTest  {
   public static void main(String[] args) {
      Stack<String> stack = new Stack<>();

      // get input text
      Scanner scanner = new Scanner(System.in);
      System.out.println("Please enter a string");
      String input = scanner.nextLine();

      // take each word from input and push on stack
      for (String word : input.split("\\s+")) {
         //Task1: write code here to implement the function above
    	  stack.push(word);
      }

      System.out.println("\nInput string in reverse order:");

      // build reverse string by popping words from stack.
      while (!stack.isEmpty()) {
         //Task 2: write code here to get objects off the stack and print it
    	  String removedObject = stack.pop();
         System.out.printf("%s ", removedObject);
      }

      System.out.println(); // print trailing newline
   }
}


/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Prentice Hall. All Rights Reserved.                                    *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
