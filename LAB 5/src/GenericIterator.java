import java.util.Iterator;

public class GenericIterator<T> implements Iterator<T> {
    private GenericCollection<T> collection;
    private int currentIndex;

    public GenericIterator(GenericCollection<T> collection) {
        this.collection = collection;
        this.currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex < collection.size();
    }

    public T next() {
        T element = collection.get(currentIndex);
        currentIndex++;
        return element;
    }

    public boolean hasPrev() {
        return currentIndex > 0;
    }

    public T prev() {
        currentIndex--;
        return collection.get(currentIndex);
    }

    public T current() {
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
        currentIndex += n;
        if (currentIndex >= collection.size())
            currentIndex = collection.size() - 1;
    }
}
