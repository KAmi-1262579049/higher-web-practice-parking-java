package ru.yandex.practicum;

import java.util.*;

// Класс ParkingLot
public class ParkingLot extends AbstractParkingLot {
    // Список всех парковочных мест
    private final List<ParkingSpot> spots = new ArrayList<>();
    // Припаркованные машины (ключ - номер автомобиля; значение - парковочное место)
    private final Map<String, ParkingSpot> parkedCars = new HashMap<>();

    // Конструктор класса ParkingLot
    public ParkingLot(int totalSpots, int electricSpots, int premiumSpots) {
        super(totalSpots, electricSpots, premiumSpots);

        int normal = totalSpots - electricSpots - premiumSpots;

        for (int i = 0; i < normal; i++) {
            spots.add(new ParkingSpot(SpotType.NORMAL));
        }
        for (int i = 0; i < electricSpots; i++) {
            spots.add(new ParkingSpot(SpotType.ELECTRIC));
        }
        for (int i = 0; i < premiumSpots; i++) {
            spots.add(new ParkingSpot(SpotType.PREMIUM));
        }
    }

    // Метод обработки события въезда автомобиля на парковку
    @Override
    public void enter(String carType, String number) throws ParkingException {
        try {
            if (parkedCars.containsKey(number)) {
                throw new ParkingException("already parked");
            }

            CarType type = CarType.from(carType);
            Car car = new Car(number, type);

            for (ParkingSpot spot : spots) {
                if (spot.canPark(car)) {
                    spot.park(car);
                    parkedCars.put(number, spot);
                    return;
                }
            }

            throw new ParkingException("no free parking spot");
        } catch (ParkingException e) {
            throw e;
        } catch (Exception e) {
            throw new ParkingException("unexpected error");
        }
    }

    // Метод обработки события выезда автомобиля с парковки
    @Override
    public void leave(String number) throws ParkingException {
        try {
            ParkingSpot spot = parkedCars.get(number);
            if (spot == null) {
                throw new ParkingException("not parked");
            }
            spot.leave();
            parkedCars.remove(number);
        } catch (ParkingException e) {
            throw e;
        } catch (Exception e) {
            throw new ParkingException("unexpected error");
        }
    }

    // Метод возвращает номера всех припаркованных автомобилей
    @Override
    public Set<String> getNumbers() {
        return new HashSet<>(parkedCars.keySet());
    }

}
