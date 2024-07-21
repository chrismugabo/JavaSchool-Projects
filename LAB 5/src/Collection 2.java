import java.util.ArrayList;
public class Collection {
	
private ArrayList<Integer> elements;
public Collection() {
	elements = new ArrayList<>();
	}
	public void add(int element) {
	elements.add(element);
	}
	public int get(int index) {
	return elements.get(index);
	}
	public void remove(int index) {
	elements.remove(index);
	}
	public boolean contains(int element) {
	return elements.contains(element);
	}
	public int size() {
	return elements.size();
	}
	public void addAll(Collection other) {
	elements.addAll(other.elements);
	}
	}

