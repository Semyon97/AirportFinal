package util;

import entity.Pilots;
import entity.Rank;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PilotsUtil {

    public static Pilots toObject (String line){
        String [] pilotsArgs = line.split("; ");

        int id = Integer.parseInt(pilotsArgs[0]);
        String name = pilotsArgs[1];
        String lastName = pilotsArgs[2];
        Rank pilotRank = Rank.valueOf(pilotsArgs[3]);
        String pilotCode = pilotsArgs[4];

        return new Pilots(id, name, lastName, pilotRank, pilotCode);

    }

    public static Pilots toObject (ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String lastName = resultSet.getString("lastName");
        Rank pilotRank = Rank.valueOf(resultSet.getString("pilotRank"));
        String pilotCode = resultSet.getString("pilotCode");

        return new Pilots(id, name, lastName, pilotRank, pilotCode);

    }
}