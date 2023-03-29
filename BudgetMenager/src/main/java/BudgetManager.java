import java.time.LocalDate;

public class BudgetManager {
    public static void main(String[] args) {
        Menu menu = new Menu();
        System.out.print("\nTwój budżet na: ");
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println();
        menu.useMenu();
    }
}
