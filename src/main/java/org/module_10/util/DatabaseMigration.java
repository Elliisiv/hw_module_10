package org.module_10.util;

import org.flywaydb.core.Flyway;
public class DatabaseMigration  {
    public void initDb( ) {
        Flyway flyway = Flyway
                .configure()
                .dataSource("jdbc:h2:/Desktop/goit/h2/10",
                        "sa",
                        "")
                .load();
        flyway.migrate();
    }
}