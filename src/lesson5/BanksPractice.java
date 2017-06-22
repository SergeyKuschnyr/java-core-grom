package lesson5;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 17.03.2017.
 */
public class BanksPractice {
    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};
        String[] names2 = {};
        int[] balances2 = {};
        int[] balances3 = {0, 0, 0, 0, 0};
        String[] names3 = {null, null, null, null, null};

        System.out.println(Arrays.toString(findClientsHasBalance(names, balances, 8000)));
        System.out.println(Arrays.toString(findClientsHasBalance(names2, balances2, 8000)));
        System.out.println(Arrays.toString(findClientsHasBalance(names3, balances3, 8000)));

        System.out.println(Arrays.toString(findClientsWithNegativeBalance(names, balances)));
        System.out.println(Arrays.toString(findClientsWithNegativeBalance(names2, balances2)));
        System.out.println(Arrays.toString(findClientsWithNegativeBalance(names3, balances3)));

        System.out.println(findClientIndexByName(names2, "Denis"));
        System.out.println(findClientIndexByName(names3, "Denis"));

        System.out.println(calculateDepositAmountAfterCommission(1000));

        depositMoney(names, balances, "Ann", 2000);
        System.out.println(Arrays.toString(balances));
        depositMoney(names2, balances2, "Ann", 2000);
        System.out.println(Arrays.toString(balances));
        depositMoney(names3, balances3, "Ann", 2000);
        System.out.println(Arrays.toString(balances));
    }

    static String[] findClientsHasBalance(String[] clients, int[] balances, int n) {
        if (balances.length != 0 && clients.length != 0) {
            int count = 0;
            for (int balance : balances) {
                if (balance >= n)
                    count++;
            }

            String[] results = new String[count];

            int index = 0;
            int resIndex = 0;
            for (int balance : balances) {
                if (balance >= n) {
                    results[resIndex] = clients[index];
                    resIndex++;
                }
                index++;
            }
            return results;
        }
        System.out.println("Empty array.");
        return null;
    }

    static String[] findClientsWithNegativeBalance(String[] clients, int[] balances) {
        if (clients.length != 0 && balances.length != 0) {
            int count = 0;
            for (int balance : balances) {
                if (balance < 0)
                    count++;
            }

            String[] results = new String[count];

            int index = 0;
            int resIndex = 0;
            for (int balance : balances) {
                if (balance < 0) {
                    results[resIndex] = clients[index];
                    resIndex++;
                }
                index++;
            }
            return results;
        }
        System.out.println("Empty array.");
        return null;
    }

    static void depositMoney(String[] clients, int[] balances, String client, int money) {
        if (findClientIndexByName(clients, client) != -1 &&
                balances.length != 0)
            balances[findClientIndexByName(clients, client)] +=
                    calculateDepositAmountAfterCommission(money);
    }

    static int findClientIndexByName(String[] clients, String client) {
        int clientIndex = 0;
        for (String cl : clients) {
            if (cl == client) {
                return clientIndex;
            }
            clientIndex++;
        }
        return -1;
    }

    static int calculateDepositAmountAfterCommission(int money) {
        return money <= 100 ? (int) (money - money * 0.02) : (int) (money - money * 0.01);
    }
}


