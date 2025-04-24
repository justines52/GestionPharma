module gestpharma.gestpharma {
    requires javafx.controls;
    requires javafx.fxml;


    requires org.kordamp.ikonli.javafx;


    requires org.jdbi.v3.sqlobject;
    requires org.jdbi.v3.core;
    requires java.sql;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.fontawesome5;

    opens gestpharma.gestpharma to javafx.fxml;
    exports gestpharma.gestpharma;
}