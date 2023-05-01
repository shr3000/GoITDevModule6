package dbService;

import org.flywaydb.core.Flyway;

public class InitDb {
    private final static String DB_URL ="jdbc:h2:./src/main/db/megasoftDB";
    private final static String DB_USER = "";
    private final static String DB_PASSWORD = "";

    public static void main(String[] args) {
        Flyway load = Flyway.configure().dataSource(DB_URL,  DB_USER, DB_PASSWORD).load();
        load.migrate();
    }
}
