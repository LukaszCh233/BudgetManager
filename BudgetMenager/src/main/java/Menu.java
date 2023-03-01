import java.util.Scanner;

public class Menu {
    public static void useMenu() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("WYBIERZ CO CHCESZ ZROBIC:");
            System.out.println("1 - DODAWANIE PRZYCHODU");
            System.out.println("2 - DODAWANIE WYDATKOW");
            System.out.println("3 - WYSWIETL LISTE PRZYCHODU I WYDATKOW");
            System.out.println("0 - KONIEC");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    BudgetFunction.addProfit();
                    break;
                case "2":
                    BudgetFunction.addExpenses();
                    break;
                case "3":
                    BudgetFunction.ProfExpenView();
                    break;
                case "0":
                    System.out.println("KONIEC");
                    break;
                default:
                    System.out.println("NIEPOPRAWNA OPCJA, SPROBUJ JESZCZE RAZ");
                    break;
            }
        } while (!choice.equalsIgnoreCase("0"));
    }
}
