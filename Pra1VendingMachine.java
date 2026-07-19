/**
 Practical 1 (Part A) - 1.1 : Vending Machine
 (a) Define an enum Coin with constants ONE, TWO, FIVE, TEN.
 (b) In main, set a snack price of 15 and a running total of 0; create a Scanner.
 (c) Loop: read a coin name, use a switch expression to convert the Coin to its value
 (ONE→1, TWO→2, FIVE→5, TEN→10), add it to the total, and print the total so
 far.
 (d) Stop the loop once the total reaches 15 or more.
 (e) Print the change to return (total − 15).
 Expected output:
            TEN then FIVE prints “Paid. Change: 0”; TEN then TEN prints
            “Paid. Change: 5”.
 */

//CODE :

import java.util.Scanner;
public class Pra1VendingMachine {
    enum Coin { ONE, TWO, FIVE, TEN }

    public static void main(String[] args) {
        final int PRICE = 15;
        int total = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Snack price: " + PRICE);
        System.out.println("Insert coins (ONE, TWO, FIVE, TEN):");


        while (total < PRICE) {
            System.out.print("Coin: ");
            String input = sc.next().toUpperCase();

            Coin coin;
            try {
                coin = Coin.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("  Not a valid coin, try again.");
                continue;
            }
            int value =0;
            switch(coin)
            {
                case ONE :
                    value = 1;
                    break;

                case TWO :
                    value = 2;
                    break;

                case FIVE :
                    value = 5;
                    break;

                case TEN :
                    value = 10;
                    break;

                default :
                    value = 0;
                    break;
            }

            total += value;
            System.out.println("  Inserted so far: " + total);
        }
        System.out.println("Paid. Change: " + (total - PRICE));
        sc.close();
    }
}