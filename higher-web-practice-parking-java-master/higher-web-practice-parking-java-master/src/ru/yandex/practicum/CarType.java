package ru.yandex.practicum;

// Перечисление CarType
public enum CarType {
    NORMAL, // Обычный автомобиль
    ELECTRIC, // Электромобиль
    PREMIUM; // Премиум-автомобиль

    // Метод для преобразования строки в CarType
    public static CarType from(String value) throws ParkingException {
        try {
            return CarType.valueOf(value);
        } catch (Exception e) {
            throw new ParkingException("unknown car type");
        }
    }
}