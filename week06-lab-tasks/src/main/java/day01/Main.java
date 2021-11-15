package day01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PositiveNumberContainer container = new PositiveNumberContainer();

        double number;
        try {
            do {
                System.out.print("Írjon be egy pozitív valós számot! ");
                number = scanner.nextDouble();

                if (number > 0.0) {
                    container.addNumber(number);
                } else {
                    System.out.println("Nem pozitív szám, bevitel vége!");
                }
            } while (number > 0.0);
        } catch (InputMismatchException exception) {
            System.out.println("Hibás szám, bevitel vége!");
        }

        System.out.println();
        System.out.println("A megadott pozitív számok: ");
        System.out.println(container.getNumbers());
    }
}
