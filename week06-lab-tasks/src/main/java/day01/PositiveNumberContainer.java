package day01;

import java.util.ArrayList;
import java.util.List;

public class PositiveNumberContainer {
    private List<Double> numbers = new ArrayList<>();

    public void addNumber(double number) {
        numbers.add(number);
    }

    public List<Double> getNumbers() {
        return numbers;
    }
}
