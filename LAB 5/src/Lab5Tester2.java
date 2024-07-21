public class Lab5Tester2 {
    public static void main(String[] args) {
        // Task 1: Create a new Collection object and add the numbers 1 through 10 to it.
        Collection collection1 = new Collection();
        for (int i = 1; i <= 10; i++) {
            collection1.add(i);
        }
        
        // Use an Iterator object to iterate through the collection and print out each element.
        Iterator iterator1 = new Iterator(collection1);
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        
        // Task 2: Create two Collection objects and add some numbers to each one.
        Collection collection2 = new Collection();
        collection2.add(11);
        collection2.add(12);
        collection2.add(13);
        
        Collection collection3 = new Collection();
        collection3.add(21);
        collection3.add(22);
        collection3.add(23);
        
        // Use the addAll() method to add the second collection to the first one.
        collection1.addAll(collection2);
        
        // Use an Iterator object to iterate through the combined collection and print out each element.
        Iterator iterator2 = new Iterator(collection1);
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
        
        // Create a new Collection object and add the numbers 1 through 6 to it.
        Collection collection4 = new Collection();
        for (int i = 1; i <= 6; i++) {
            collection4.add(i);
        }
        
        // Use an Iterator object to iterate through the collection and perform the specified operations.
        Iterator iterator3 = new Iterator(collection4);
        while (iterator3.hasNext()) {
            System.out.println(iterator3.current());
            iterator3.skip(2);
            if (iterator3.hasNext()) {
                System.out.println(iterator3.next());
            }
        }
    }
}

