public class ProfitExpenses {
    String name;
    double amount;
    ProfitExpensesType type;

    public ProfitExpenses(String name, double amount, ProfitExpensesType type) {
        this.name = name;
        this.amount = amount;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public ProfitExpensesType getType() {
        return type;
    }

    @Override
    public String toString() {
        return name + " - " + amount;
    }
}


