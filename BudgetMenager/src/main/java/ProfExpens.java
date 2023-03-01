public class ProfExpens {
     String name;
     double amount;
     String type;



    public ProfExpens(String name, double amount, String type) {
        this.name = name;
        this.amount = amount;
        this.type = type;

    }
    @Override
    public String toString() {
        return
                name +" - "+
                 amount
                ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
