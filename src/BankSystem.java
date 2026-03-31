import java.util.*;

public class BankSystem {

    static LinkedList<BankAccount> accounts = new LinkedList<>();
    static Stack<String> history = new Stack<>();
    static Queue<String> billQueue = new LinkedList<>();
    static Queue<BankAccount> accountRequestQueue = new LinkedList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        bankMainMenu();
    }

    // =================== MAIN MENU ===================
    static void bankMainMenu() {
        while (true) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1 – Enter Bank");
            System.out.println("2 – Enter ATM");
            System.out.println("3 – Admin Area");
            System.out.println("4 – Exit");
            System.out.print("Select: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> bankMenu();
                case 2 -> atmMenu();
                case 3 -> adminMenu();
                case 4 -> { System.out.println("Goodbye!"); return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // =================== BANK MENU ===================
    static void bankMenu() {
        while (true) {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1 – Submit account opening request");
            System.out.println("2 – Deposit money");
            System.out.println("3 – Withdraw money");
            System.out.println("4 – Back");
            System.out.print("Select: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> submitRequest();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    // =================== ATM MENU ===================
    static void atmMenu() {
        System.out.print("Enter username: ");
        String user = sc.nextLine();

        BankAccount acc = findAccount(user);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }

        while (true) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1 – Balance enquiry");
            System.out.println("2 – Withdraw");
            System.out.println("3 – Back");
            System.out.print("Select: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> System.out.println("Balance: " + acc.balance);
                case 2 -> {
                    System.out.print("Withdraw amount: ");
                    double am = sc.nextDouble();
                    if (am <= acc.balance) {
                        acc.balance -= am;
                        history.push("ATM Withdraw " + am + " from " + acc.username);
                        System.out.println("Withdraw successful.");
                    } else System.out.println("Not enough balance.");
                }
                case 3 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // =================== ADMIN MENU ===================
    static void adminMenu() {
        while (true) {
            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1 – Process account requests");
            System.out.println("2 – Process bill payments");
            System.out.println("3 – View transaction history");
            System.out.println("4 – Back");
            System.out.print("Select: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> processAccountRequests();
                case 2 -> processBills();
                case 3 -> System.out.println(history);
                case 4 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    // =================== TASK 1–2 ===================
    static void submitRequest() {
        System.out.print("Enter account number: ");
        String num = sc.nextLine();

        System.out.print("Enter username: ");
        String user = sc.nextLine();

        System.out.print("Enter initial balance: ");
        double bal = sc.nextDouble();

        BankAccount acc = new BankAccount(num, user, bal);
        accountRequestQueue.add(acc);

        System.out.println("Request submitted.");
    }

    static void deposit() {
        System.out.print("Enter username: ");
        String user = sc.nextLine();

        BankAccount acc = findAccount(user);
        if (acc == null) { System.out.println("Not found."); return; }

        System.out.print("Deposit amount: ");
        double am = sc.nextDouble();

        acc.balance += am;
        history.push("Deposit " + am + " to " + acc.username);

        System.out.println("New balance: " + acc.balance);
    }

    static void withdraw() {
        System.out.print("Enter username: ");
        String user = sc.nextLine();

        BankAccount acc = findAccount(user);
        if (acc == null) { System.out.println("Not found."); return; }

        System.out.print("Withdraw amount: ");
        double am = sc.nextDouble();

        if (am <= acc.balance) {
            acc.balance -= am;
            history.push("Withdraw " + am + " from " + acc.username);
            System.out.println("New balance: " + acc.balance);
        } else {
            System.out.println("Not enough balance.");
        }
    }

    // =================== TASK 4 ===================
    static void processBills() {
        if (billQueue.isEmpty()) System.out.println("No bills.");
        else System.out.println("Processing: " + billQueue.poll());
    }

    // =================== TASK 5 ===================
    static void processAccountRequests() {
        if (accountRequestQueue.isEmpty()) {
            System.out.println("No pending requests.");
        } else {
            BankAccount acc = accountRequestQueue.poll();
            accounts.add(acc);
            System.out.println("Account added: " + acc.username);
        }
    }

    // =================== HELPER ===================
    static BankAccount findAccount(String user) {
        for (BankAccount a : accounts)
            if (a.username.equalsIgnoreCase(user)) return a;
        return null;
    }
}