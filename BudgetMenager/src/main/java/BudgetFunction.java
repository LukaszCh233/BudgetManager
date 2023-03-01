import java.util.Scanner;

public class BudgetFunction {
        // BudgetFunction is class where the functions for the Budget Manager project are performed.

    // addProfit is function which allows the user add Profit to Budget Manager.
    public static void addProfit() {
        Scanner scanner = new Scanner(System.in);
        String b;

        do {
            System.out.println("PODAJ NAZWE I KWOTE PRZYCHODU: ");
            try {
                String name = scanner.nextLine();
                while (!scanner.hasNextDouble()) {
                    System.out.println("Niepoprawna kwota. Podaj jeszcze raz: ");
                    scanner.next();
                }
                double amount = scanner.nextDouble();
                scanner.nextLine();
                ProfExpenList.list.add(new ProfExpens(name, amount, "Przychod"));
            } catch (Exception e) {
                scanner.nextLine();
            }
            System.out.println("CZY CHCESZ KONTYNUOWAC? TAK/NIE");
            b = scanner.nextLine();
        } while (!b.equalsIgnoreCase("NIE"));
    }

    // addExpenses is function which allows the user add Expenses to Budget Manager.
    public static void addExpenses() {
        Scanner scanner = new Scanner(System.in);
        String b;

        do {
            System.out.println("PODAJ NAZWE I KWOTE WYDATKU: ");
            try {
                String name = scanner.nextLine();
                while (!scanner.hasNextDouble()) {
                    System.out.println("Niepoprawna kwota. Podaj jeszcze raz: ");
                    scanner.next();
                }
                double amount = scanner.nextDouble();
                scanner.nextLine();
                ProfExpenList.list.add(new ProfExpens(name, amount, "Wydatek"));
            } catch (Exception d) {
                scanner.nextLine();
            }
            System.out.println("CZY CHCESZ KONTYNUOWAC? TAK/NIE");
            b = scanner.nextLine();
        } while (!b.equalsIgnoreCase("NIE"));
    }

    // ProfExpenView is function which is to be displayed list of profit and expenses, sum of profit and expenses.
    // Check our budget balance also this function can can remove the selected index from the list.
    public static void ProfExpenView() {
        Scanner scanner = new Scanner(System.in);
        String b;
        double sumP;
        double sumE;

        do {
            sumP = 0;
            sumE = 0;
            System.out.println("LISTA PRZYCHODOW i WYDATKOW: ");
            System.out.println("PRZYCHODY:");
            for (int i = 1; i <= ProfExpenList.list.size(); i++) {
                ProfExpens profitExpens = ProfExpenList.list.get(i);
                if (profitExpens.type.equals("Przychod")) {
                    System.out.println(i + ". " + profitExpens+" zl");
                    sumP += profitExpens.amount;
                }
            }
            System.out.println("SUMA PRZYCHODU - " + sumP + " zl");

            System.out.println("---------------------------");
            System.out.println("WYDATKI:");
            for (int a = 1; a <= ProfExpenList.list.size(); a++) {
                ProfExpens profitExpens1 = ProfExpenList.list.get(a);
                if (profitExpens1.type.equals("Wydatek")) {
                    System.out.println(a + ". " + profitExpens1+" zl");
                    sumE += profitExpens1.amount;
                }
            }
            System.out.println("SUMA WYDATKOW - " + sumE + " zl");

            System.out.println("\n##############################\n");

            double balance = sumP - sumE;
            System.out.println("AKTUALNE SALDO TO:" + balance + " zl");

            System.out.println("JESLI CHCESZ USNUNAC COS Z LISTY WYBIERZ /TAK/ JESLI CHCESZ WYJSC WYBIERZ /NIE/:");
            b = scanner.nextLine();
            if (b.equalsIgnoreCase("tak")) {
                System.out.println("WYBIERZ NUMER:");
                int index = scanner.nextInt();
                scanner.nextLine();
                ProfExpenList.list.remove(index);
            }
        } while (!b.equalsIgnoreCase("nie"));
    }
}