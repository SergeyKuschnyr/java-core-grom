package lesson5;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 22.03.2017.
 */
public class TakeOffTheAmount {
    public static void main(String[] args) {
        String[] clients = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};
        String[] clients2 = {};
        int[] balances2 = {};
        String[] clients3 = {null, null, null};
        int[] balances3 = {0, 0, 0};

        System.out.println(Arrays.toString(balances));
        System.out.println("--------------------------------");
        System.out.println(withdraw(clients, balances, "Denis", 100));
        System.out.println(Arrays.toString(balances));
        System.out.println("--------------------------------");
        System.out.println(withdraw(clients2, balances2, "Andrey", 100));
        System.out.println(Arrays.toString(balances));
        System.out.println(withdraw(clients3, balances3, "Andrey", 100));
        System.out.println(Arrays.toString(balances));
    }

    static int withdraw(String[] clients, int[] balances, String client, int amount) {
        if (balances.length != 0 &&
                clients.length != 0 &&
                findClientIndexByName(clients, client) != -1 &&
                balances[findClientIndexByName(clients, client)] >= amount) {
            return depositMoney(clients, balances, client, amount);
        }
        return -1;
    }

    static int depositMoney(String[] clients, int[] balances, String client, int money) {
        if (balances.length != 0)
            return (balances[findClientIndexByName(clients, client)] -= money);
        return 0;
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
}
