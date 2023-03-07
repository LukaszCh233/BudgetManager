

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


public class BudgetManager {
    public static void main(String[] args) {
        Menu menu = new Menu();
        BudgetFunction budgetFunction = new BudgetFunction();
        budgetFunction.nextMouth();
        System.out.print("\nTWÓJ BUDŻET DOMOWY NA: ");

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        System.out.println(dateFormat.format(date));
        System.out.println();
        menu.useMenu();
    }
}
