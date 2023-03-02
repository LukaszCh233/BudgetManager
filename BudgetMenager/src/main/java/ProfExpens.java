public class ProfExpens {
     String name;
     double amount;
     ProfitExpensType type;



    public ProfExpens(String name, double amount, ProfitExpensType type) {
        this.name = name;
        this.amount = amount;
        this.type = type;

    }
    public ProfitExpensType getType() {
        return type;
    }
    @Override
    public String toString() {
        return name +" - "+ amount;
    }
}


