package BankAccountLab;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Create class BankAccount.
The class should have private fields for:
Id: int (Starts from 1 and increments for every new account)
Balance: double
Interest rate: double (Shared for all accounts. Default value: 0.02)
The class should also have public methods for:
setInterestRate(double interest): void (static)
getInterest(int Years): double
deposit(double amount): void
Create a test client supporting the following commands:
Create
Deposit {Id} {Amount}
SetInterest {Interest}
GetInterest {ID} {Years}
End
 */
public class Main {
    public static void main(String[] args) {
        final String CREATE_COMMAND = "Create";
        final String DEPOSIT_COMMAND = "Deposit";
        final String SET_INTEREST_COMMAND = "SetInterest";
        final String GET_INTEREST_COMMAND = "GetInterest";

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        String command = input[0];

        Map<Integer, BankAccount> allAccounts = new HashMap<>();

        while (!command.equals("End")) {
            String output = "";

            switch (command) {
                case CREATE_COMMAND:
                    BankAccount account = new BankAccount();
                    allAccounts.put(account.getID(), account);
                    output = String.format("Account ID%d created", account.getID());
                    break;

                case DEPOSIT_COMMAND: {
                    int accountID = Integer.parseInt(input[1]);
                    double amount = Double.parseDouble(input[2]);

                    BankAccount current = allAccounts.get(accountID);
                    if (current == null) {
                        output = "Account does not exist";
                    } else {
                        current.deposit(amount);
                        allAccounts.put(accountID, current);
                        output = String.format("Deposited %.0f to ID%d", amount, accountID);
                    }

                    break;
                }
                case SET_INTEREST_COMMAND:
                    double interest = Double.parseDouble(input[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case GET_INTEREST_COMMAND:
                    int accountID = Integer.parseInt(input[1]);
                    int years = Integer.parseInt(input[2]);

                    BankAccount current = allAccounts.get(accountID);
                    if (current == null) {
                        output = "Account does not exist";
                    } else {
                        output = String.format("%.2f", current.getRevenue(years));
                        allAccounts.put(accountID, current);
                    }

                    break;
            }

            if (output != "") {
                System.out.println(output);
            }

            input = scanner.nextLine().split("\\s+");
            command = input[0];
        }
    }
}
