import java.util.Scanner;

public class Menu {
    BudgetFunction budgetFunction = new BudgetFunction();

    //useMenu is function which control Budget Manager project.
    public void useMenu() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        budgetFunction.checkMonth();
        budgetFunction.loadFile();

        do {
            System.out.println("WYBIERZ CO CHCESZ ZROBIC:");
            System.out.println("1 - DODAWANIE PRZYCHODU");
            System.out.println("2 - DODAWANIE WYDATKOW");
            System.out.println("3 - WYSWIETL LISTE PRZYCHODU I WYDATKOW");
            System.out.println("4 - PRZEGLĄD Z INNYCH MIESIĘCY ");
            System.out.println("0 - KONIEC");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    budgetFunction.addProfit();
                    budgetFunction.fileWriter();
                    break;
                case "2":
                    budgetFunction.addExpenses();
                    budgetFunction.fileWriter();
                    break;
                case "3":
                    budgetFunction.profitExpensesView();
                    budgetFunction.fileWriter();
                    break;
                case "4":
                    budgetFunction.choiceMonth();
                    break;
                case "0":
                    System.out.println("Koniec");
                    break;
                default:
                    System.out.println("Niepoprawna opcja spróbuj jeszcze raz");
                    break;
            }
        } while (!choice.equalsIgnoreCase("0"));

    }
}
