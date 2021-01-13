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
        String last_name = pilotsArgs[2];
        Rank rank = Rank.valueOf(pilotsArgs[3]);
        String pilot_code = pilotsArgs[4];

        return new Pilots(id, name, last_name, rank, pilot_code);

    }

    public static Pilots toObject (ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String last_name = resultSet.getString("last_name");
        Rank rank = Rank.valueOf(resultSet.getString("rank"));
        String pilot_code = resultSet.getString("pilot_code");

        return new Pilots(id, name, last_name, rank, pilot_code);

    }
}