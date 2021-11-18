package day02.numbers;

public class PerfectNumbers {
    public boolean isPerfectNumber(int number) {
        return isPerfectNumberComplicatedFast(number);
    }

    private boolean isPerfectNumberSimpleSlow(int number) {
        int sum = 0;

        for (int divisor = 1; divisor < number; divisor++) {
            if (number % divisor == 0) {
                sum += divisor;
            }
        }

        return sum == number;
    }

    private boolean isPerfectNumberComplicatedFast(int number) {
        int sum = 0;
        int quotient = number;
        int remainder = 0;

        for (int divisor = 1; divisor < quotient; divisor++) {
            quotient = number / divisor;
            remainder = number % divisor;
            if (remainder == 0) {
                sum += divisor;
                if (quotient > divisor && quotient < number) {
                    sum += quotient;
                }
            }
        }

        return sum == number;
    }
}
