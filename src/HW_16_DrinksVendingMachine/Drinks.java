package HW_16_DrinksVendingMachine;

import java.util.Arrays;
import java.util.Scanner;

public class Drinks {

    final static int COFFEE_PRICE = 15;
    final static int TEA_PRICE = 9;
    final static int LEMONADE_PRICE = 25;
    final static int MOJITO_PRICE = 35;
    final static int MINERAL_PRICE = 18;
    final static int COCA_COLA_PRICE = 23;

    final static int[] pricesOfDrinks = {COFFEE_PRICE, TEA_PRICE, LEMONADE_PRICE, MOJITO_PRICE, MINERAL_PRICE, COCA_COLA_PRICE};
    static int[] quantityOfDrinks = new int[6];
    static int deposit, totalSum = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printVendingMachine();
            choice = scanner.nextInt();

            if (choice > 0 && choice < 7) {
                quantityOfDrinks[choice - 1]++;
            }
        } while (choice != 9 && choice != 0);

        if (choice == 9) { //Confirm
            if (getMoney()) {
                giveAwayDrinks();
                System.out.println("Thanks! Come again!");
            }
        }
    }

    private static boolean getMoney() {

        Scanner scanner = new Scanner(System.in);
        int cashInsert;

        do {
            printDeposit();

            System.out.print("Please insert money: ");
            cashInsert = scanner.nextInt();
            if (cashInsert > 0) {
                deposit += cashInsert;
            }
        } while (deposit < totalSum);

        if (deposit > totalSum) {
            System.out.println();
            System.out.println("Take your " + (deposit - totalSum) + " UAH change");
        }

        return true;
    }

    private static void printDeposit() {

        System.out.println("--------------------");
        System.out.println("| Total:   " + formatValue(totalSum == 0 ? "" : String.valueOf(totalSum), 3, true) + " |");
        System.out.println("| Deposit: " + formatValue(deposit == 0 ? "" : String.valueOf(deposit), 3, true) + " |");
        System.out.println("--------------------");

    }

    private static void giveAwayDrinks() {
        for (int i = 0; i < quantityOfDrinks.length; i++) {
            if (quantityOfDrinks[i] != 0) {
                giveAwayDrink(i, quantityOfDrinks[i]);
            }
        }
    }

    private static void giveAwayDrink(int index, int quantity) {
        switch (index) {
            case 0 -> MakeACoffee(quantity);
            case 1 -> MakeATea(quantity);
            case 2 -> MakeALemonade(quantity);
            case 3 -> MakeAMojito(quantity);
            case 4 -> MakeAMineral(quantity);
            case 5 -> MakeACocaCola(quantity);
        }
    }

    private static void printVendingMachine() {

        DrinksMachine[] drinks = DrinksMachine.values();

        int totalQty = Arrays.stream(quantityOfDrinks).sum();
        totalSum = 0;

        System.out.println("-----------------------------------------------");
        System.out.println("|                   Welcome!                  |");
        System.out.println("-----------------------------------------------");
        System.out.println("| # | Drink          | Price  | Qty |   Sum   |");
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < drinks.length; i++) {
            int price = pricesOfDrinks[i];
            int quantity = quantityOfDrinks[i];
            int sum = price * quantity;
            totalSum += sum;

            System.out.println("| " + (i + 1) + " | "
                    + formatValue(drinks[i].name(), 15, false) + "| "
                    + formatValue(price == 0 ? "" : String.valueOf(price), 2, true) + " |  "
                    + formatValue(quantity == 0 ? "" : String.valueOf(quantity), 2, false) + " | "
                    + formatValue(sum == 0 ? "" : String.valueOf(sum), 3, true) + " |");
        }

        System.out.println("-----------------------------------------------");
        System.out.println("                       Total: |  " + formatValue(totalQty == 0 ? "" : String.valueOf(totalQty), 2, false)
                + " | " + formatValue(totalSum == 0 ? "" : String.valueOf(totalSum), 3, true) + " |");
        System.out.println("                              -----------------");
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println("|   Enter 0 to cancel  |   Enter 9 to confirm  |");
        System.out.println("-----------------------------------------------");

        System.out.println();
        System.out.print("Please enter # to add a drink: ");

    }

    private static String formatValue(String value, int length, boolean printCurrency) {
        return (value + "               ").substring(0, length) + (printCurrency ? " UAH" : "");
    }

    static void MakeACoffee(int quantity) {
        System.out.println();
        System.out.println("Take your " + quantity + " cup of coffee");
    }

    static void MakeATea(int quantity) {
        System.out.println();
        System.out.println("Take your " + quantity + " cup of tea");
    }

    static void MakeALemonade(int quantity) {
        System.out.println();
        System.out.println("Take your " + quantity + " glasses of lemonade");
    }

    static void MakeAMojito(int quantity) {
        System.out.println();
        System.out.println("Take your " + quantity + " glasses of mojito");
    }

    static void MakeAMineral(int quantity) {
        System.out.println();
        System.out.println("Take your " + quantity + " bottles of mineral water");
    }

    static void MakeACocaCola(int quantity) {
        System.out.println();
        System.out.println("Take your " + quantity + " bottles of Coca-cola");
    }

}


