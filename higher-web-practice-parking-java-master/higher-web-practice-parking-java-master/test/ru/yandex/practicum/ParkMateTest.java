package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Тестовый класс ParkMateTest
class ParkMateTest {

    // Тест (обычная машина может припарковаться на обычном месте)
    @Test
    void normalCarParksOnlyOnNormal() throws Exception {
        ParkingLot lot = new ParkingLot(1, 0, 0);
        lot.enter("NORMAL", "A123BC");
        assertEquals(1, lot.getNumbers().size());
    }

    // Тест (электромобиль не может парковаться на обычном месте)
    @Test
    void electricCarCannotParkOnNormal() {
        ParkingLot lot = new ParkingLot(1, 0, 0);
        assertThrows(ParkingException.class,
                () -> lot.enter("ELECTRIC", "E111EE"));
    }

    // Тест (премиум-автомобиль может парковаться на обычном месте)
    @Test
    void premiumCarCanParkOnNormal() throws Exception {
        ParkingLot lot = new ParkingLot(1, 0, 0);
        lot.enter("PREMIUM", "P777PP");
        assertTrue(lot.getNumbers().contains("P777PP"));
    }

    // Тест (после отъезда место освобождается)
    @Test
    void leaveFreesSpot() throws Exception {
        ParkingLot lot = new ParkingLot(1, 0, 0);
        lot.enter("NORMAL", "A000AA");
        lot.leave("A000AA");
        assertTrue(lot.isEmpty());
    }

    // Тест (нельзя уехать с парковки, если машина не была припаркована)
    @Test
    void cannotLeaveNotParkedCar() {
        ParkingLot lot = new ParkingLot(1, 0, 0);
        assertThrows(ParkingException.class,
                () -> lot.leave("X999XX"));
    }

    // Тест (нельзя припарковать машину, если парковка уже заполнена)
    @Test
    void parkingOverflowThrowsException() throws Exception {
        ParkingLot lot = new ParkingLot(1, 0, 0);
        lot.enter("NORMAL", "A111AA");
        assertThrows(ParkingException.class,
                () -> lot.enter("NORMAL", "B222BB"));
    }
}
