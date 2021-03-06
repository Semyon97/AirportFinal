import entity.Aircraft;
import entity.Flights;
import entity.Pilots;
import io.*;

import java.util.List;

import static io.FilePathConstants.*;

public class Airport {

    public static void main(String[] args) {

        PilotsFileReader reader = new PilotsFileReader(PILOTS_SOURCE_FILE);
        List<Pilots> pilots = reader.readItems();

        System.out.println("Старт записи в таблицу pilots");
        PilotsDbWriter writer = new PilotsDbWriter(pilots);
        writer.saveAll();
        System.out.println("Запись в таблицу pilots завершена");

        AircraftFileReader reader1 = new AircraftFileReader(AIRCRAFT_SOURCE_FILE);
        List<Aircraft> aircraft = reader1.readItems();

        System.out.println("Старт записи в таблицу aircraft");
        AircraftDbWriter writer1 = new AircraftDbWriter(aircraft);
        writer1.saveAll();
        System.out.println("Запись в таблицу aircraft завершена");

        FlightsFileReader reader2 = new FlightsFileReader(FLIGHTS_SOURCE_FILE);
        List<Flights> flights = reader2.readItems();

        System.out.println("Старт записи в таблицу flights");
        FlightsDbWriter writer2 = new FlightsDbWriter(flights);
        writer2.saveAll();
        System.out.println("Запись в таблицу flights завершена");

        FullInfoDbReader fullInfoDbReader = new FullInfoDbReader();
        fullInfoDbReader.readAll();

        fullInfoDbReader.writeResult();
    }
}
