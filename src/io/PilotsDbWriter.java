package io;

import entity.Pilots;
import util.DbConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PilotsDbWriter {
    private List<Pilots> pilots;
    private static final String ADD = "INSERT INTO pilots (name, last_name, pilot_rank, pilot_code) VALUES (?, ?, ?, ?)";

    public PilotsDbWriter(List<Pilots> pilots) {
        this.pilots = pilots;
    }

    public void saveAll() {
        for (Pilots pilots : pilots) {
            System.out.println(pilots);
            save(pilots);
        }
    }

    private void save(Pilots pilots) {
        Connection connection = DbConnectionUtil.detConnection();
        try (PreparedStatement statement = connection.prepareStatement(ADD)) {

            statement.setString(1, pilots.getName());
            statement.setString(2, pilots.getLastName());
            statement.setString(3, pilots.getPilotRank().toString());
            statement.setString(4, pilots.getPilotCode());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}