package io;

import entity.Rank;
import entity.Result;
import util.DbConnectionUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FullInfoDbReader {
    private List<Result> resultList = new ArrayList<>();

    private static final String SELECT_ALL = "SELECT f.flightNumber, f.data, f.time, a.tailNumber, a.brand, a.model,"
            + " a.passengerCapacity, p.lastName, p.name, p.pilotCode, p.pRank FROM flights f JOIN aircraft a ON f.aircraft=a.id JOIN pilots p ON f.pilot = p.id";

    public void readAll() {
        Connection connection = DbConnectionUtil.detConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {

            try (ResultSet result = statement.executeQuery()) {

                while (result.next()) {
                    String flightNumber = result.getString("f.flightNumber");
                    String data = result.getString("f.data");
                    String time = result.getString("f.time");
                    int tailNumber = result.getInt("a.tailNumber");
                    String brand = result.getString("a.brand");
                    String model = result.getString("a.model");
                    int passengerCapacity = result.getInt("a.passengerCapacity");
                    String lastName = result.getString("p.lastName");
                    String name = result.getString("p.name");
                    String pilotCode = result.getString("p.pilotCode");
                    Rank pRank = Rank.valueOf(result.getString("p.pRank"));

                    Result res = new Result(flightNumber, data, time, tailNumber, brand, model, passengerCapacity, lastName, name, pilotCode, pRank);
                    resultList.add(res);

                    System.out.println(flightNumber + ", " + data + ", " + time + ", " + tailNumber + ", " + brand + " "
                            + model + ", " + passengerCapacity + ", " + lastName + " " + name + ", " + pilotCode + " (" + pRank + ")");
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
                writer.append(result.getLastName()).append(", ");
                writer.append(result.getName()).append(", ");
                writer.append(result.getPilotCode()).append(", ");
                writer.append(result.getPilotRank().toString());
                writer.append("\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}