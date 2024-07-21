import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static final String DATA_FILE = "data.dat";

    private List<Income> incomes;

    public DataManager() {
        this.incomes = new ArrayList<>();
        loadData();
    }

    public void addIncome(Income income) {
        incomes.add(income);
        saveData();
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    private void saveData() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            outputStream.writeObject(incomes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadData() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            incomes = (List<Income>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing data found. Creating new data file.");
        }
    }
}
