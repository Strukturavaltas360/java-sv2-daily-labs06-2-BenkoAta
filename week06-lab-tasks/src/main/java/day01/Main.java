package day01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PositiveNumberContainer container = new PositiveNumberContainer();

        double number;
        do {
            System.out.print("Írjon be egy pozitív valós számot! ");
            try {
                number = scanner.nextDouble();
            }
            catch (InputMismatchException exception) {
                System.out.println("Hibás szám, bevitel vége!");
                break;
            }
            if (number > 0.0) {
                container.addNumber(number);
            } else {
                System.out.println("Nem pozitív szám, bevitel vége!");
                break;
            }
        } while (true);

        System.out.println();
        System.out.println("A megadott pozitív számok: ");
        System.out.println(container.getNumbers());
    }
}
