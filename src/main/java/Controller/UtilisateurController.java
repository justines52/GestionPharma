package Controller;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;

public class UtilisateurController {

    @FXML
    private VBox gestionMedicaleMenu;
    @FXML
    private VBox stockMenu;
    @FXML
    private VBox transactionsMenu;
    @FXML
    private StackPane rootStackPane;


    // Stockage des états des sous-menus (ouvert/fermé)
    private final HashMap<VBox, Boolean> menuStates = new HashMap<>();

    @FXML
    public void initialize() {
        // Initialiser les états des sous-menus comme fermés
        menuStates.put(gestionMedicaleMenu, false);
        menuStates.put(stockMenu, false);
        menuStates.put(transactionsMenu, false);

        // Masquer tous les sous-menus dès le départ
        hideMenu(gestionMedicaleMenu);
        hideMenu(stockMenu);
        hideMenu(transactionsMenu);
    }
    public void handleSupprimerUtilisateur(ActionEvent event) {
        try {
            // Charger le fichier FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces/UtilisateurSupprimer.fxml"));
            Parent UtilisateurSupprimerView = loader.load();

            // Créer un nouveau Stage pour la vue secondaire
            Stage secondaryStage = new Stage();

            // Créer une nouvelle Scene pour la fenêtre indépendante
            Scene scene = new Scene(UtilisateurSupprimerView);
            secondaryStage.setScene(scene);

            // Configurer la fenêtre (facultatif)
            secondaryStage.setTitle("Supprimer Utilisateur");
            secondaryStage.initModality(Modality.WINDOW_MODAL); // Fenêtre modale
            secondaryStage.initOwner(rootStackPane.getScene().getWindow()); // Définir la fenêtre parent (principal)

            // Appliquer l'effet DropShadow au rootStackPane (pas à la vue secondaire)
            DropShadow dropShadow = new DropShadow();
            dropShadow.setColor(Color.rgb(58, 123, 140));

            dropShadow.setRadius(80);  // 80 pixels
            dropShadow.setSpread(0.8); // 0.8 = 80% spread
            dropShadow.setOffsetX(0);  // X offset
            dropShadow.setOffsetY(0);  // Y offset
            dropShadow.setBlurType(BlurType.GAUSSIAN);
            rootStackPane.setEffect(dropShadow); // Ajoute une ombre à la fenêtre principale

            // Afficher la fenêtre secondaire
            secondaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void handleAjouterUtilisateur(ActionEvent event) {
        try {
            // Charger le fichier FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces/AjouterUtilisateur.fxml"));
            Parent AjouterUtilisateurView = loader.load();

            // Créer un nouveau Stage pour la vue secondaire
            Stage secondaryStage = new Stage();

            // Créer une nouvelle Scene pour la fenêtre indépendante
            Scene scene = new Scene(AjouterUtilisateurView);
            secondaryStage.setScene(scene);

            // Configurer la fenêtre (facultatif)
            secondaryStage.setTitle("Ajouter Utilisateur");
            secondaryStage.initModality(Modality.WINDOW_MODAL); // Fenêtre modale
            secondaryStage.initOwner(rootStackPane.getScene().getWindow()); // Définir la fenêtre parent (principal)

            // Appliquer l'effet DropShadow au rootStackPane (pas à la vue secondaire)
            DropShadow dropShadow = new DropShadow();
            dropShadow.setColor(Color.rgb(58, 123, 140));

            dropShadow.setRadius(80);  // 80 pixels
            dropShadow.setSpread(0.8); // 0.8 = 80% spread
            dropShadow.setOffsetX(0);  // X offset
            dropShadow.setOffsetY(0);  // Y offset
            dropShadow.setBlurType(BlurType.GAUSSIAN);
            rootStackPane.setEffect(dropShadow); // Ajoute une ombre à la fenêtre principale

            // Afficher la fenêtre secondaire
            secondaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void handleModifierUtilisateur(ActionEvent event) {
        try {
            // Charger le fichier FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces/UtilisateurModifier.fxml"));
            Parent modifierUtilisateurView = loader.load();

            // Créer un nouveau Stage pour la vue secondaire
            Stage secondaryStage = new Stage();

            // Créer une nouvelle Scene pour la fenêtre indépendante
            Scene scene = new Scene(modifierUtilisateurView);
            secondaryStage.setScene(scene);

            // Configurer la fenêtre (facultatif)
            secondaryStage.setTitle("Ajouter Entrée");
            secondaryStage.initModality(Modality.WINDOW_MODAL); // Fenêtre modale
            secondaryStage.initOwner(rootStackPane.getScene().getWindow()); // Définir la fenêtre parent (principal)

            // Appliquer l'effet DropShadow au rootStackPane (pas à la vue secondaire)
            DropShadow dropShadow = new DropShadow();
            dropShadow.setColor(Color.rgb(58, 123, 140));

            dropShadow.setRadius(80);  // 80 pixels
            dropShadow.setSpread(0.8); // 0.8 = 80% spread
            dropShadow.setOffsetX(0);  // X offset
            dropShadow.setOffsetY(0);  // Y offset
            dropShadow.setBlurType(BlurType.GAUSSIAN);
            rootStackPane.setEffect(dropShadow); // Ajoute une ombre à la fenêtre principale

            // Afficher la fenêtre secondaire
            secondaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void closeSecondaryView() {
        // Vérification qu'un composant secondaire est présent
        if (rootStackPane.getChildren().size() > 1) {
            // Supprimer le dernier enfant ajouté
            Node lastNode = rootStackPane.getChildren().get(rootStackPane.getChildren().size() - 1);
            rootStackPane.getChildren().remove(lastNode);


        } else {
            System.out.println("Aucune vue secondaire à fermer.");
        }
    }
    /**
     * Gère l'affichage/masquage d'un sous-menu.
     *
     * @param menu Le sous-menu à gérer.
     */
    public void toggleSubMenu(VBox menu) {
        boolean isOpen = menuStates.get(menu);

        if (isOpen) {
            hideMenu(menu); // Fermer le menu
        } else {
            showMenu(menu); // Ouvrir le menu
        }

        // Mettre à jour l'état
        menuStates.put(menu, !isOpen);
    }

    /**
     * Affiche un sous-menu avec une animation.
     *
     * @param menu Le sous-menu à afficher.
     */
    private void showMenu(VBox menu) {
        menu.setVisible(true);
        menu.setManaged(true);

        // Fade-in animation (apparition en fondu)
        FadeTransition fadeIn = new FadeTransition(Duration.millis(300), menu);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();
    }

    /**
     * Masque un sous-menu avec une animation.
     *
     * @param menu Le sous-menu à masquer.
     */
    private void hideMenu(VBox menu) {
        // Fade-out animation (disparition en fondu)
        FadeTransition fadeOut = new FadeTransition(Duration.millis(300), menu);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);

        // Une fois l'animation terminée, retirer le menu du layout
        fadeOut.setOnFinished(event -> {
            menu.setVisible(false);
            menu.setManaged(false);
        });
        fadeOut.play();
    }

    /**
     * Bouton pour le menu 1 (Gestion Médicale).
     */
    @FXML
    public void onMenu1ButtonClicked() {
        toggleSubMenu(gestionMedicaleMenu);
    }

    /**
     * Bouton pour le menu 2 (Stock).
     */
    @FXML
    public void onMenu2ButtonClicked() {
        toggleSubMenu(stockMenu);
    }

    /**
     * Bouton pour le menu 3 (Transactions).
     */
    @FXML
    public void onMenu3ButtonClicked() {
        toggleSubMenu(transactionsMenu);
    }
}