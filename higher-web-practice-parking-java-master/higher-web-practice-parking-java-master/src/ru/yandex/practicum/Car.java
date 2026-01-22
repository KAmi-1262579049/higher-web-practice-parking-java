package ru.yandex.practicum;

// Класс Car
public class Car {
    // Номер автомобиля
    private final String number;
    // Тип автомобиля
    private final CarType type;

    // Конструктор класса Car
    public Car(String number, CarType type) {
        this.number = number;
        this.type = type;
    }

    // Геттер для получения номера автомобиля
    public String getNumber() {
        return number;
    }

    public CarType getType() {
        return type;
    }
}

