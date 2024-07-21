
public class Lab5Tester {
    public static void main(String[] args) {
        Collection collection = new Collection();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);
        Collection collection2 = new Collection();
        collection2.add(1);
        collection2.add(2);
        System.out.println("Collection size: " + collection.size());

        Iterator iterator = new Iterator(collection);
        System.out.println("Forward: ");
        while (iterator.hasNext()) {
            System.out.println("Next element: " + iterator.next());
        }
        System.out.println("Backward: ");
        while (iterator.hasPrev()) {
            System.out.println("Next element: " + iterator.prev());
        }
        
        iterator.reset();
        System.out.println("Delteing element at index 1 after using the iterator once after reset");
        System.out.println("Forward: ");
        if(iterator.hasNext()) 
            System.out.println("Next element: " + iterator.next());
        iterator.removeAt(1);
        if(iterator.hasNext()) 
            System.out.println("Next element: " + iterator.next());
        while (iterator.hasNext()) {
            System.out.println("Next element: " + iterator.next());
        }

        iterator.reset();
        System.out.println("Delteing element at index 1 before using the iterator after reset");
        System.out.println("Forward: ");
        iterator.removeAt(1);
        while (iterator.hasNext()) {
            System.out.println("Next element: " + iterator.next());
        }
        
        iterator.reset();
        System.out.println("Forward: ");
        System.out.println("Current element without using next() method "+iterator.current());
        System.out.println("Current element without using next() method "+iterator.current());
        System.out.println("after using next() two times ");
        iterator.next(); iterator.next();
        System.out.println("Current element without using next() method "+iterator.current());
        System.out.println("Current element without using next() method "+iterator.current());

        iterator.reset();
        System.out.println("Forward: ");
        iterator.skip(1);
        System.out.println("Current element after using skip(1) "+iterator.current());

        iterator.reset();
        System.out.println("Forward: ");
        iterator.skip(2);
        System.out.println("Current element after using skip(2) "+iterator.current());

        iterator.reset();
        System.out.println("Forward: ");
        iterator.skip(4);
        System.out.println("Current element after using skip(4) "+iterator.current());
        
        iterator.reset();
        System.out.println("Forward: ");
        while (iterator.hasNext()) {
            System.out.println("Next element: " + iterator.next());
        }
        
        collection.addAll(collection2);
        iterator.reset();
        System.out.println("Forward: ");
        while (iterator.hasNext()) {
            System.out.println("Next element: " + iterator.next());
        }
   }
}