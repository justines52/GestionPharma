package gestpharma.gestpharma.config;

import org.jdbi.v3.core.Jdbi;

public class DBconfig {
    private static final String url = "jdbc:mysql://localhost:3306/gestpharma";
    private static final String user = "root";
    private static final String password = "123456";

    public static Jdbi getJdbi() {
        return Jdbi.create(url, user, password);
    }
}
