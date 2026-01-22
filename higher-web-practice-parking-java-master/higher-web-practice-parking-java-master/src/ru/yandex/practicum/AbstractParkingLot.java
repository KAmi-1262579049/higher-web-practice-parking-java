package ru.yandex.practicum;

import java.util.Set;

// Абстрактный класс AbstractParkingLot
public abstract class AbstractParkingLot {

    // Конструктор класса AbstractParkingLo
    public AbstractParkingLot(int totalSpots, int electricSpots, int premiumSpots) {

    }

    // Метод проверяет, пуста ли парковка
    boolean isEmpty() {
        return getNumbers().isEmpty();
    }

    // Абстрактный метод въезда автомобиля на парковку
    public abstract void enter(String carType, String number) throws ParkingException;

    // Абстрактный метод выезда автомобиля с парковки
    public abstract void leave(String number) throws ParkingException;

    // Абстрактный метод, возвращающий множество номеров
    public abstract Set<String> getNumbers();
}
