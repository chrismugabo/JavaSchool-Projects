 public class Iterator implements
java.util.Iterator<Integer> {
private Collection collection;
private int currentIndex;
public Iterator(Collection collection) {
this.collection = collection;
this.currentIndex = 0;
}
public boolean hasNext() {
return currentIndex < collection.size();
}
public Integer next() {
Integer element = collection.get(currentIndex);
currentIndex++;
return element;
}
public boolean hasPrev() {
return currentIndex > 0;
}
public Integer prev() {
currentIndex--;
return collection.get(currentIndex);
}
public Integer current() {
return collection.get(currentIndex);
}
public void removeAt(int index) {
collection.remove(index);
if (currentIndex > index) {
currentIndex--;
}
}
public void reset() {
currentIndex = 0;
}
public void skip(int n) {
currentIndex+=n;
if(currentIndex >= collection.size())
currentIndex= collection.size()-1;
}
}
