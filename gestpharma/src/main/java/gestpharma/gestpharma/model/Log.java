package gestpharma.gestpharma.model;

import java.time.LocalDateTime;

public class Log {
    private String ID_commande;
    private String ID_log;
    private LocalDateTime date_log;
    private LogType type;

    public Log() {}

    public Log(String ID_commande, String ID_log, LocalDateTime date_log , LogType type) {
        this.ID_commande = ID_commande;
        this.ID_log = ID_log;
        this.date_log = date_log;
        this.type = type;
    }

    //getters

    public String getID_commande() {
        return ID_commande;
    }
    public String getID_log() {
        return ID_log;
    }
    public LocalDateTime getDate_log() {
        return date_log;
    }
    public LogType getType() { return type; }

    //setters

    public void setID_commande(String ID_commande) {
        this.ID_commande = ID_commande;
    }
    public void setID_log(String ID_log) {
        this.ID_log = ID_log;
    }
    public void setDate_log(LocalDateTime date_log) {
        this.date_log = date_log;
    }
    public void setType(LogType type) { this.type = type; }
}
