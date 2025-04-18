package gestpharma.gestpharma.config;

import org.jdbi.v3.core.Jdbi;

public class DBconfig {
    private static final String url = "";
    private static final String user = "";
    private static final String password = "";

    public static Jdbi getJdbi() {
        return Jdbi.create(url, user, password);
    }
}
