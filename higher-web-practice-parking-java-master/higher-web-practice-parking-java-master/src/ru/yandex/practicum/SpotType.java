package ru.yandex.practicum;

// Перечисление SpotType
public enum SpotType {
    NORMAL, // Обычное парковочное место
    ELECTRIC, // Парковочное место для электромобилей
    PREMIUM; // Премиум-парковочное место

    // Метод проверяет, может ли машина с заданным типом припарковаться на данном парковочном месте
    public boolean canPark(CarType carType) {
        return switch (carType) {
            case NORMAL -> this == NORMAL;
            case ELECTRIC -> this == ELECTRIC;
            case PREMIUM -> this == PREMIUM || this == NORMAL;
        };
    }
}
