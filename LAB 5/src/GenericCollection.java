 import java.util.ArrayList;


public class GenericCollection<T> {
    private ArrayList<T> elements;

    public GenericCollection() {
        elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public T get(int index) {
        return elements.get(index);
    }

    public void remove(int index) {
        elements.remove(index);
    }

    public boolean contains(T element) {
        return elements.contains(element);
    }

    public int size() {
        return elements.size();
    }

    public void addAll(GenericCollection<T> other) {
        elements.addAll(other.elements);
    }
}



