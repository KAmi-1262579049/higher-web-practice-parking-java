package ru.yandex.practicum;

// Класс ParkingSpot
public class ParkingSpot {
    // Тип парковочного места
    private final SpotType type;
    // Машина, которая сейчас стоит на этом месте
    private Car car;

    // Конструктор ParkingSpot
    public ParkingSpot(SpotType type) {
        this.type = type;
    }

    // Метод проверяет, свободно ли парковочное место
    public boolean isFree() {
        return car == null;
    }

    // Метод проверяет, можно ли поставить конкретную машину на это место
    public boolean canPark(Car car) {
        return isFree() && type.canPark(car.getType());
    }

    // Метод для парковки машины на место
    public void park(Car car) {
        this.car = car;
    }

    // Метод освобождения парковочного места
    public void leave() {
        this.car = null;
    }

}
