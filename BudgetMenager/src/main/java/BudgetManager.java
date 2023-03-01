import java.text.SimpleDateFormat;
import java.util.Date;

public class BudgetManager {
    public static void main(String[] args) {

        System.out.print("\nTWÓJ BUDŻET DOMOWY NA: ");
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        System.out.println(dateFormat.format(date));
        System.out.println();
        Menu.useMenu();
    }
}
