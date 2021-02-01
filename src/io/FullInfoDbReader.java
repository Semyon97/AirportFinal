package io;

import entity.Rank;
import entity.Result;
import util.DbConnectionUtil;

import javax.xml.namespace.QName;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FullInfoDbReader {
    private final List<Result> resultList = new ArrayList<>();
    private static final String SELECT_ALL = "SELECT f.flight_number, f.data, f.time, a.tail_number, a.brand, a.model,"
            + " a.passenger_capacity, p.last_name, p.name, p.pilot_code, p.pilot_rank FROM flights f JOIN aircraft a ON f.aircraft=a.id JOIN pilots p ON f.pilot = p.id";

    public void readAll() {
        Connection connection = DbConnectionUtil.detConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {

            ResultSet result = statement.executeQuery(); {

                while (result.next()) {
                    String flightNumber = result.getString("f.flight_number");
                    String data = result.getString("f.data");
                    String time = result.getString("f.time");
                    int tailNumber = result.getInt("a.tail_number");
                    String brand = result.getString("a.brand");
                    String model = result.getString("a.model");
                    int passengerCapacity = result.getInt("a.passenger_capacity");
                    String lastName = result.getString("p.last_name");
                    String name = result.getString("p.name");
                    String pilotCode = result.getString("p.pilot_code");
                    Rank pilotRank = Rank.valueOf(result.getString("p.pilot_rank"));

                    Result res = new Result(flightNumber, data, time, tailNumber, brand, model, passengerCapacity, lastName, String.format("%1.1s", name), pilotCode, pilotRank);
                    resultList.add(res);

                    System.out.println(flightNumber + ", " + data + ", " + time + ", " + tailNumber + ", " + brand + " "
                            + model + ", " + passengerCapacity + ", " + lastName + " " + String.format("%1.1s", name) + ", " + pilotCode + " (" + pilotRank + ")");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void writeResult() {
        try (FileWriter writer = new FileWriter("result\\result.csv")) {

            for (Result result : resultList) {
                writer.append(result.getFlightNumber()).append(", ");
                writer.append(result.getData()).append(", ");
                writer.append(result.getTime()).append(", ");
                writer.append(String.valueOf(result.getTailNumber())).append(", ");
                writer.append(result.getBrand()).append(", ");
                writer.append(result.getModel()).append(", ");
                writer.append(String.valueOf(result.getPassengerCapacity())).append(", ");
                writer.append(result.getName()).append(" ");
                writer.append(result.getLastName()).append("., ");
                writer.append(result.getPilotCode()).append(", ");
                writer.append(result.getPilotRank().toString());
                writer.append("\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}