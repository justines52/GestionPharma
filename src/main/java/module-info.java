module gestpharma.gestpharma {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    requires jbcrypt;


    requires org.jdbi.v3.sqlobject;
    requires org.jdbi.v3.core;
    requires java.sql;

    opens gestpharma.gestpharma to javafx.fxml;
    exports gestpharma.gestpharma;
}