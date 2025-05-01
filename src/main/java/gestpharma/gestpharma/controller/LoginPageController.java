package gestpharma.gestpharma.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPageController {

    @FXML
    private AnchorPane anchorPanePrincipal; // Conteneur principal

    @FXML
    private VBox vboxConnexion; // Formulaire de connexion

    @FXML
    private AnchorPane parentConnexionPane; // Parent de vboxConnexion

    @FXML
    private Button connexionButton;

    @FXML
    private TextField UsernameTextField;

    @FXML
    private PasswordField PasswordTextField;


    @FXML
    private Label connextezVousLabel;

    @FXML
    private Label aLaPharmacieLabel;

    @FXML
    private Label contactezVotreAdminLabel;

    @FXML
    private ImageView elFarkh;

    @FXML
    private ImageView pharmacie;

    @FXML
    private VBox vboxgauche; // Section gauche de l'interface
    @FXML
    private VBox vboxgaucheInterne;

    @FXML
    public void initialize() {
        Platform.runLater(() -> { // Exécution après le chargement de la scène
            Stage stage = (Stage) anchorPanePrincipal.getScene().getWindow();

            // Configuration de la fenêtre
            setupWindow(stage);

            // Rendre l'interface responsive
            makeResponsive(stage);

            // Centrer dynamiquement le formulaire de connexion (VBox au centre)
            setupVBoxCentrage();
        });
    }


    private void setupWindow(Stage stage) {
        // Définir les dimensions minimales et maximales de la fenêtre
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setMaxWidth(1920);
        stage.setMaxHeight(1080);

        // Masquer les images si la largeur de la fenêtre devient trop faible
        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.doubleValue() < 600) {
                pharmacie.setVisible(false);
                elFarkh.setVisible(false);
            } else {
                pharmacie.setVisible(true);
                elFarkh.setVisible(true);
            }
        });
    }


    private void makeResponsive(Stage stage) {
        // Ajustement dynamique des dimensions du bouton de connexion
        connexionButton.prefWidthProperty().bind(stage.widthProperty().multiply(0.3)); // 30% de la largeur
        connexionButton.prefHeightProperty().bind(stage.heightProperty().multiply(0.04)); // 4% de la hauteur

        // Champs d'identifiant et de mot de passe (mêmes dimensions que le bouton)
        UsernameTextField.prefWidthProperty().bind(connexionButton.prefWidthProperty());
        UsernameTextField.prefHeightProperty().bind(connexionButton.prefHeightProperty());

        PasswordTextField.prefWidthProperty().bind(connexionButton.prefWidthProperty());
        PasswordTextField.prefHeightProperty().bind(connexionButton.prefHeightProperty());

        // Rendre le texte des labels proportionnel à la taille de la fenêtre
        connextezVousLabel.styleProperty().bind(stage.widthProperty().multiply(0.02).asString("-fx-font-size: %.0fpx;"));
        aLaPharmacieLabel.styleProperty().bind(stage.widthProperty().multiply(0.015).asString("-fx-font-size: %.0fpx;"));
        contactezVotreAdminLabel.styleProperty().bind(stage.widthProperty().multiply(0.007).asString("-fx-font-size: %.0fpx;"));

        // Rendre les images responsives
        pharmacie.fitWidthProperty().bind(stage.widthProperty().multiply(0.2)); // 20% de la largeur
        pharmacie.fitHeightProperty().bind(stage.heightProperty().multiply(0.2)); // 20% de la hauteur
        elFarkh.fitWidthProperty().bind(stage.widthProperty().multiply(0.25));   // 25% de la largeur
        elFarkh.fitHeightProperty().bind(stage.heightProperty().multiply(0.4)); // 40% de la hauteur

        // Assurez-vous que le spacing de vboxgauche est ajusté dynamiquement
        double fixedSpacing = 10; // Valeur par défaut
        vboxgauche.spacingProperty().bind(stage.heightProperty().multiply(0.001).add(fixedSpacing));
        vboxgaucheInterne.spacingProperty().bind(stage.heightProperty().multiply(0.001).add(fixedSpacing));
    }

    /**
     * Configure le centrage dynamique du VBox contenant le formulaire de connexion.
     */
    private void setupVBoxCentrage() {
        // Ajouter des listeners sur les dimensions du parent (parentConnexionPane)
        parentConnexionPane.widthProperty().addListener((obs, oldVal, newVal) -> centerVBox());
        parentConnexionPane.heightProperty().addListener((obs, oldVal, newVal) -> centerVBox());

        // Centrage initial du VBox lors du chargement
        centerVBox();
    }

    private void centerVBox() {
        // Obtenez les dimensions du conteneur parent (AnchorPane)
        double parentWidth = parentConnexionPane.getWidth();
        double parentHeight = parentConnexionPane.getHeight();

        // Dimensions du VBox (formulaire de connexion)
        double vboxWidth = vboxConnexion.getWidth();
        double vboxHeight = vboxConnexion.getHeight();

        // Validez les dimensions avant de centrer
        if (parentWidth > 0 && parentHeight > 0 && vboxWidth > 0 && vboxHeight > 0) {
            // Centrer horizontalement
            vboxConnexion.setLayoutX((parentWidth - vboxWidth) / 2);

            // Centrer verticalement
            vboxConnexion.setLayoutY((parentHeight - vboxHeight) / 2);
        }
    }
}