import java.io.*;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

    // BudgetFunction is class where the functions for the Budget Manager project are performed.
public class BudgetFunction {
    LocalDate lastWriteDate = LocalDate.now().withDayOfMonth(1);
    LocalDate currentDate = LocalDate.now();
    String fileName = lastWriteDate.getMonth().toString() + "_" + lastWriteDate.getYear() + ".txt";

    ProfitExpensesList profExpenList = new ProfitExpensesList();

    // addProfit is function which allows the user add Profit to Budget Manager.
    public void addProfit() {
        Scanner scanner = new Scanner(System.in);
        String backMenu;
        if (profExpenList == null) {
            profExpenList = new ProfitExpensesList();
        }
        do {
            System.out.println("Podaj nazwę i kwotę przychodu: ");
            try {
                String name = scanner.nextLine();
                while (!scanner.hasNextDouble()) {
                    System.out.println("Niepoprawna kwota. Podaj jeszcze raz: ");
                    scanner.next();
                }
                double amount = scanner.nextDouble();
                scanner.nextLine();
                profExpenList.getList().add(new ProfitExpenses(name, amount, ProfitExpensesType.PROFIT));
            } catch (Exception e) {
                scanner.nextLine();
            }
            System.out.println("Chcesz kontynuować? tak/nie");
            backMenu = scanner.nextLine();
        } while (!backMenu.equalsIgnoreCase("nie"));
    }

    // addExpenses is function which allows the user add Expenses to Budget Manager.
    public void addExpenses() {
        Scanner scanner = new Scanner(System.in);
        String backMenu;

        do {
            System.out.println("Podaj nazwę i kwotę wydatku: ");
            try {
                String name = scanner.nextLine();
                while (!scanner.hasNextDouble()) {
                    System.out.println("Niepoprawna kwota. Podaj jeszcze raz: ");
                    scanner.next();
                }
                double amount = scanner.nextDouble();
                scanner.nextLine();
                profExpenList.getList().add(new ProfitExpenses(name, amount, ProfitExpensesType.EXPENS));
            } catch (Exception d) {
                scanner.nextLine();
            }
            System.out.println("Chcesz kontynuować? tak/nie");
            backMenu = scanner.nextLine();
        } while (!backMenu.equalsIgnoreCase("nie"));
    }

    // ProfExpenView is function which is to be displayed list of profit and expenses, sum of profit and expenses.
    // Check our budget balance also this function can can remove the selected index from the list.
    public void profitExpensesView() {

        Scanner scanner = new Scanner(System.in);
        String backMenu;
        double sumProfit;
        double sumExpenses;

        do {
            sumProfit = 0;
            sumExpenses = 0;
            System.out.println("Lista przychodów i wydatków: ");

            System.out.println("Przychody:");
            for (int i = 0; i < profExpenList.list.size(); i++) {
                ProfitExpenses profitExpens = profExpenList.list.get(i);
                if (profitExpens.getType() == ProfitExpensesType.PROFIT) {
                    System.out.println(i + ". " + profitExpens + " zl");
                    sumProfit += profitExpens.amount;
                }
            }
            System.out.println("Suma przychodów - " + sumProfit + " zl");
            System.out.println("---------------------------");
            System.out.println("Wydatki:");
            for (int a = 0; a < profExpenList.list.size(); a++) {
                ProfitExpenses profitExpens1 = profExpenList.list.get(a);
                if (profitExpens1.getType() == ProfitExpensesType.EXPENS) {
                    System.out.println(a + ". " + profitExpens1 + " zl");
                    sumExpenses += profitExpens1.amount;
                }
            }
            System.out.println("Suma wydatków - " + sumExpenses + " zl");

            System.out.println("\n##############################\n");

            double balance = sumProfit - sumExpenses;
            System.out.println("Aktualne saldo to:" + balance + " zl\n");
            if (balance < 0) {
                System.out.println("Wydatki przekoroczyły twój budżet!!!!");
            }
            System.out.println("Jeśli chcesz usunąć z listy wybierz /tak/ jeśli chcesz wyjść /nie/:");
            backMenu = scanner.nextLine();

            if (backMenu.equalsIgnoreCase("tak")) {
                try {
                    System.out.println("WYBIERZ NUMER:");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    profExpenList.list.remove(index);
                } catch (InputMismatchException e) {
                    System.out.println("Niepoprawny format numeru, spróbuj ponownie.");
                    scanner.nextLine();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Nie ma elementu o podanym numerze, spróbuj ponownie.");
                }
            }
        } while (!backMenu.equalsIgnoreCase("nie"));
    }
    public void fileWriter() {

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            for (ProfitExpenses pe : profExpenList.list) {
                fileWriter.write(pe.getName() + "," + pe.getAmount() + "," + pe.getType() + "\n");
            }
            fileWriter.close();
            System.out.println("Lista zapisana do pliku.");
        } catch (
                FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku.");
            e.printStackTrace();
        } catch (
                IOException e) {
            System.out.println("Błąd podczas zapisu do pliku.");
            e.printStackTrace();
        }
    }
    public void loadFile() {

        try {
            FileReader reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                if (line.length == 3) {
                    ProfitExpensesType type = ProfitExpensesType.valueOf(line[2]);
                    String name = line[0];
                    double amount = Double.parseDouble(line[1]);
                    profExpenList.list.add(new ProfitExpenses(name, amount, type));
                }
            }
            scanner.close();
            reader.close();
            System.out.println("Lista wczytana z pliku.");
        } catch (IOException e) {
            System.out.println("Błąd podczas odczytu z pliku.");
            e.printStackTrace();
        }
    }

    //CheckMonth is function which check month, if we have new month file is saved and function create new file.
    public void checkMonth() {

        if (!lastWriteDate.equals(currentDate)) {
            try {
                File file = new File(fileName);
                if (file.createNewFile()) {
                    System.out.println("Utworzono plik " + fileName);
                } else {
                    System.out.println("Plik " + fileName + " już istnieje.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //ChoiceMonth is function which displays file data for the selected month.
    public void choiceMonth() {
        Scanner scanner = new Scanner(System.in);
        String numberMonth;

        do {
            System.out.println("Wybierz miesiąc, po wpisaniu 0 wracasz do menu:");
            numberMonth = scanner.nextLine();

            switch (numberMonth) {
                case "1":
                    numberMonth = "JANUARY" + "_" + lastWriteDate.getYear() + ".txt";
                    loadSelectedMonth(numberMonth);
                    System.out.println("Budżet na: "+ numberMonth);
                    break;
                case "2":
                    numberMonth = "FEBRUARY" + "_" + lastWriteDate.getYear() + ".txt";
                    loadSelectedMonth(numberMonth);
                    break;
                case "3":
                    numberMonth = "MARCH" + "_" + lastWriteDate.getYear() + ".txt";
                    loadSelectedMonth(numberMonth);
                    break;
                case "4":
                    numberMonth = "APRIL" + "_" + lastWriteDate.getYear() + ".txt";
                    break;
                case "5":
                    numberMonth = "MAY" + "_" + lastWriteDate.getYear() + ".txt";
                    break;
                case "0":
                    System.out.println("Koniec");
                default:
                    System.out.println("Nieporawna opcja, spróbuj jeszcze raz:");
            }
            File file = new File(numberMonth);
            if (!file.exists()) {
                System.out.println("Plik " + numberMonth + " nie istnieje.");
            } else profitExpensesView();

        } while (!numberMonth.equals("0"));
    }

    //LoadSelectedMonth is function which read selected file if existed.
    public void loadSelectedMonth(String numberMonth) {

        profExpenList.list.clear();
        try {
            FileReader reader = new FileReader(numberMonth);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                if (line.length == 3) {
                    ProfitExpensesType type = ProfitExpensesType.valueOf(line[2]);
                    String name = line[0];
                    double amount = Double.parseDouble(line[1]);
                    profExpenList.list.add(new ProfitExpenses(name, amount, type));
                }
            }
            scanner.close();
            reader.close();
            System.out.println("Lista wczytana z pliku.");

        } catch (FileNotFoundException e) {
            System.out.println("Plik nie istnieje");
        } catch (IOException e) {
            System.out.println("Błąd podczas odczytu z pliku.");
            e.printStackTrace();
        }
    }
}