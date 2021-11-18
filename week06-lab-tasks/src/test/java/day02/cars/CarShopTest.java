package day02.cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarShopTest {
    private Car car1;
    private Car car2;
    private Car car3;
    private Car car4;
    private CarShop carShop;

    @BeforeEach
    void init() {
        car1 = new Car("Toyota", 1.2, Color.BLACK, 2_300_000);
        car2 = new Car("Lamborghini", 5.2, Color.BLACK, 10_300_000);
        car3 = new Car("Suzuki", 1.4, Color.RED, 1_500_000);
        car4 = new Car("Toyota", 1.4, Color.GREY, 2_700_000);
        carShop = new CarShop("Best Car", 10_000_000);
    }

    @Test
    void addCar() {
        assertTrue(carShop.addCar(car1));
        assertFalse(carShop.addCar(car2));
    }

    @Test
    void sumCarPrice() {
        carShop.addCar(car1);
        carShop.addCar(car2);
        car1.decreasePrice(10);
        carShop.addCar(car3);
        carShop.addCar(car4);

        assertEquals(6270000,carShop.sumCarPrice());
    }

    @Test
    void numberOfCarsCheaperThan() {
        carShop.addCar(car1);
        carShop.addCar(car2);
        car1.decreasePrice(10);
        carShop.addCar(car3);
        carShop.addCar(car4);

        assertEquals(1, carShop.numberOfCarsCheaperThan(2_000_000));
        assertEquals(0, carShop.numberOfCarsCheaperThan(1_000_000));
    }

    @Test
    void carsWithBrand() {
        carShop.addCar(car1);
        carShop.addCar(car2);
        car1.decreasePrice(10);
        carShop.addCar(car3);
        carShop.addCar(car4);

        assertEquals(2, carShop.carsWithBrand("Toyota").size());
        assertEquals(0, carShop.carsWithBrand("BMW").size());
    }

    @Test
    void getCarsForSell() {
        carShop.addCar(car1);
        assertEquals(1, carShop.getCarsForSell().size());
        carShop.addCar(car2);
        assertEquals(1, carShop.getCarsForSell().size());
    }
}