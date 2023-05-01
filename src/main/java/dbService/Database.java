package dbService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Database {
    private Connection connection;
    private static volatile Database instance;

    private Database(String value) {
        try {
            connection = DriverManager.getConnection(value);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Database getInstance() {
        Database result = instance;
        if (result != null) {
            return result;
        }
        synchronized(Database.class) {
            if (instance == null) {
                instance = new Database("jdbc:h2:./src/main/db/megasoftDB");
            }
            return instance;
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
