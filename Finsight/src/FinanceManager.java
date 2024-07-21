import java.util.List;

public class FinanceManager {
    private DataManager dataManager;

    public FinanceManager(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void addIncome(String source, double amount) {
        Income income = new Income(source, amount);
        dataManager.addIncome(income);
    }

    public List<Income> getIncomes() {
        return dataManager.getIncomes();
    }
}
