import java.util.ArrayList;
import java.util.Scanner;

class Account {
    int accNo;
    String name;
    double balance;

    Account(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }
}

public class BankingManagementSystem {

    static ArrayList<Account> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // INSERT
    static void insert() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        sc.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Balance: ");
        double balance = sc.nextDouble();

        accounts.add(new Account(accNo, name, balance));

        System.out.println("Account inserted successfully!");
    }

    // DELETE
    static void delete() {
        System.out.print("Enter Account Number to Delete: ");
        int accNo = sc.nextInt();

        for (Account a : accounts) {
            if (a.accNo == accNo) {
                accounts.remove(a);
                System.out.println("Account deleted successfully!");
                return;
            }
        }

        System.out.println("Account not found!");
    }

    // UPDATE
    static void update() {
        System.out.print("Enter Account Number to Update: ");
        int accNo = sc.nextInt();

        for (Account a : accounts) {
            if (a.accNo == accNo) {

                sc.nextLine();
                System.out.print("Enter New Name: ");
                a.name = sc.nextLine();

                System.out.print("Enter New Balance: ");
                a.balance = sc.nextDouble();

                System.out.println("Account updated successfully!");
                return;
            }
        }

        System.out.println("Account not found!");
    }

    // DISPLAY
    static void display() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts available!");
            return;
        }

        System.out.println("\n===== ACCOUNT DETAILS =====");

        for (Account a : accounts) {
            System.out.println("Account Number : " + a.accNo);
            System.out.println("Name           : " + a.name);
            System.out.println("Balance        : " + a.balance);
            System.out.println("---------------------------");
        }
    }

    // MAIN
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== BANKING MANAGEMENT SYSTEM =====");
            System.out.println("1. Insert Account");
            System.out.println("2. Delete Account");
            System.out.println("3. Update Account");
            System.out.println("4. Display Accounts");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    insert();
                    break;

                case 2:
                    delete();
                    break;

                case 3:
                    update();
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}