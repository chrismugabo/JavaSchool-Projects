 
// Program concatenates two lists


public class ListConcatenate {
   public static void main(String[] args) {
      // create two linked lists
      List<Integer> list1 = new List<Integer>("list1");
      List<Integer> list2 = new List<Integer>("list2");

      // use List insert methods to add characters to list1
      System.out.println("List 1:");
      list1.insertAtBack(1);
      list1.print();
      list1.insertAtBack(3);
      list1.print();
      list1.insertAtBack(5);
      list1.print();
      list1.insertAtBack(7);
      list1.print();

      // use List insert methods to add character to list2
      System.out.println("\nList 2:");
      list2.insertAtBack(2);
      list2.print();
      list2.insertAtBack(4);
      list2.print();
      list2.insertAtBack(6);
      list2.print();
      list2.insertAtBack(8);
      list2.print();

      // concatenate lists using method concatenate
      concatenate(list1, list2);
      System.out.println("\nConcatenated list is:");
      list1.print();
   }

   public static <T> void concatenate(
      List<T> list1, List<T> list2) {
      if (!list1.isEmpty() && !list2.isEmpty()) {
         //TODO: complete the code here to move items from list2 to list1
    	  while (!list2.isEmpty()) {
              T item = list2.removeFromFront(); // Remove item from the front of list2
              list1.insertAtBack(item);
      }
      }
   }
}

 