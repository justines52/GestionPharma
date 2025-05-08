package Controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;

public class SortieController {

    @FXML
    private VBox gestionMedicaleMenu; // Menu 1 : Gestion Médicale

    @FXML
    private VBox stockMenu; // Menu 2 : Stock

    @FXML
    private VBox transactionsMenu; // Menu 3 : Transactions
    @FXML
    private StackPane rootStackPane; // Conteneur principal des vues

    private final HashMap<VBox, Boolean> menuStates = new HashMap<>(); // Suivi des états des menus (ouvert/fermé)

    /**
     * Initialisation automatique après le chargement du fichier FXML.
     */
    @FXML
    public void initialize() {
        // Initialisation des états de chaque sous-menu
        if (gestionMedicaleMenu != null) menuStates.put(gestionMedicaleMenu, false);
        if (stockMenu != null) menuStates.put(stockMenu, false);
        if (transactionsMenu != null) menuStates.put(transactionsMenu, false);

        // Les menus doivent être cachés initialement
        if (gestionMedicaleMenu != null) hideMenu(gestionMedicaleMenu);
        if (stockMenu != null) hideMenu(stockMenu);
        if (transactionsMenu != null) hideMenu(transactionsMenu);
        if (rootStackPane == null) {
            System.err.println("⚠ ERREUR : rootStackPane est null ! Vérifie le fx:id dans SortieFinale.fxml.");
        } else {
            System.out.println("✅ rootStackPane est correctement initialisé.");
        }

    }
    private void loadAnchorPaneToStackPane(String fxmlPath, boolean keepPrevious) {
        try {
            // Charger la nouvelle vue depuis le fichier FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            AnchorPane newPane = loader.load();

            // Vérification de l'initialisation du StackPane
            if (rootStackPane == null) {
                System.err.println("⚠ rootStackPane est null ! Vérifie l'initialisation dans le FXML.");
                return;
            }

            if (!rootStackPane.getChildren().isEmpty() && !keepPrevious) {
                // Si on ne veut pas garder la vue précédente, on la retire délicatement avec une animation de sortie
                Node currentPane = rootStackPane.getChildren().get(rootStackPane.getChildren().size() - 1); // Dernier enfant
                FadeTransition fadeOut = new FadeTransition(Duration.millis(300), currentPane);
                fadeOut.setFromValue(1.0); // Opacité maximale
                fadeOut.setToValue(0.0);   // Disparaît progressivement

                fadeOut.setOnFinished(event -> {
                    rootStackPane.getChildren().remove(currentPane); // Retirer la vue précédente
                    rootStackPane.getChildren().add(newPane);        // Ajouter la nouvelle vue
                    playFadeIn(newPane);                             // Jouer l'animation d'apparition
                });

                fadeOut.play(); // Lancer l'animation de disparition pour la vue précédente
            } else {
                // Ajoute directement la nouvelle vue sans supprimer les vues précédentes
                rootStackPane.getChildren().add(newPane);
                playFadeIn(newPane); // Animation d'apparition pour la nouvelle vue
            }

        } catch (IOException e) {
            System.err.println("❌ Erreur lors du chargement de l'AnchorPane depuis " + fxmlPath);
            e.printStackTrace();
        }
    }

    /**
     * Joue une animation d'apparition pour un Node donné.
     *
     * @param node Le Node à animer.
     */
    private void playFadeIn(Node node) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(300), node);
        fadeIn.setFromValue(0.0); // Opacité initiale à 0 (invisible)
        fadeIn.setToValue(1.0);   // Montage progressif jusqu'à 100 % de visibilité
        fadeIn.play();
    }


    /**
     * Gestion du clic sur le bouton "Ajouter Sortie" - charge AjouterPharmaceutiqueP1.
     */
    @FXML
    public void handleAjouterSortie(ActionEvent event) {


        try {
            // Charger AjouterPharmaceutiqueP1.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces/AjouterPharmaceutiqueP1.fxml"));
            AnchorPane pane = loader.load();

            // Configuration de la fenêtre et de la scène
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setScene(scene);

            // Paramètres supplémentaires pour la fenêtre
            stage.initModality(Modality.APPLICATION_MODAL); // Bloque les interactions avec la fenêtre principale
            stage.setTitle("Ajouter Pharmaceutique");
            stage.setResizable(false); // Empêche le redimensionnement
            stage.show(); // Affiche la fenêtre

            // Chercher le bouton 'suivantBtn' dans la vue chargée
            JFXButton suivantBtn = (JFXButton) pane.lookup("#suivantBtn");
            if (suivantBtn != null) {
                // Action vers ajouterPharmaceutiqueP2 dans la même fenêtre
                suivantBtn.setOnAction(e -> goToAjouterPharmaceutiqueP2(stage));
                System.out.println("✅ Action configurée pour le bouton `suivantBtn`.");
            } else {
                System.err.println("❌ Le bouton `suivantBtn` est introuvable dans le fichier AjouterPharmaceutiqueP1.fxml !");
            }
            JFXButton autreBtn = (JFXButton) pane.lookup("#autreBtn");
            if (autreBtn!= null) {
                // Action vers ajouterAutre dans la même fenêtre
                autreBtn.setOnAction(e -> goToAjouterAutre(stage));
                System.out.println("✅ Action configurée pour le bouton `autreBtn`.");
            } else {
                System.err.println("❌ Le bouton `autreBtn` est introuvable dans le fichier AjouterPharmaceutiqueP1.fxml !");
            }

        } catch (IOException e) {
            // Gestion des erreurs de chargement du fichier FXML
            e.printStackTrace();
            System.err.println("❌ Erreur lors du chargement de AjouterPharmaceutiqueP1.fxml !");
        }


    }

    /**
     * Navigation vers AjouterPharmaceutiqueP2 à partir d'AjouterPharmaceutiqueP1.
     */
    @FXML
    public void goToAjouterPharmaceutiqueP2(Stage currentStage) {
        try {
            // Charger AjouterPharmaceutiqueP2.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces/AjouterPharmaceutiqueP2.fxml"));
            AnchorPane pane = loader.load();

            // Créer une nouvelle scène avec le contenu chargé
            Scene scene = new Scene(pane);

            // Remplace la scène existante dans la fenêtre actuelle
            currentStage.setScene(scene);
            currentStage.setTitle("Ajouter Pharmaceutique - Étape 2"); // Met à jour le titre de la fenêtre
            currentStage.show(); // Ré-affiche la fenêtre si nécessaire

            System.out.println("✅ AjouterPharmaceutiqueP2.fxml chargé avec succès dans la même fenêtre !");
            JFXButton autreBtn = (JFXButton) pane.lookup("#autreBtn");
            if (autreBtn!= null) {
                // Action vers ajouterAutre dans la même fenêtre
                autreBtn.setOnAction(e -> goToAjouterAutre(currentStage));
                System.out.println("✅ Action configurée pour le bouton `autreBtn`.");
            } else {
                System.err.println("❌ Le bouton `autreBtn` est introuvable dans le fichier AjouterPharmaceutiqueP1.fxml !");
            }
            JFXButton pharmaceutiqueBtn = (JFXButton) pane.lookup("#pharmaceutiqueBtn");
            if (pharmaceutiqueBtn!= null) {
                // Action vers ajouterAutre dans la même fenêtre
                pharmaceutiqueBtn.setOnAction(e -> goToAjouterPharmaceutiqueP1(currentStage));
                System.out.println("✅ Action configurée pour le bouton `pharmaceutiqueBtn`.");
            } else {
                System.err.println("❌ Le bouton `autreBtn` est introuvable dans le fichier AjouterPharmaceutiqueP1.fxml !");
            }
            JFXButton suivantBtn = (JFXButton) pane.lookup("#suivantBtn");
            if (suivantBtn != null) {
                // Action vers ajouterPharmaceutiqueP2 dans la même fenêtre
                suivantBtn.setOnAction(e -> goToAjouterPharmaceutiqueP2(currentStage));
                System.out.println("✅ Action configurée pour le bouton `suivantBtn`.");
            } else {
                System.err.println("❌ Le bouton `suivantBtn` est introuvable dans le fichier AjouterPharmaceutiqueP1.fxml !");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("❌ Erreur lors du chargement de AjouterPharmaceutiqueP2.fxml !");

        }
    }
    @FXML
    public void goToAjouterPharmaceutiqueP1(Stage currentStage) {
        try {
            // Charger AjouterPharmaceutiqueP1.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces/AjouterPharmaceutiqueP1.fxml"));
            AnchorPane pane = loader.load();

            // Créer une nouvelle scène avec le contenu chargé
            Scene scene = new Scene(pane);

            // Remplace la scène existante dans la fenêtre actuelle
            currentStage.setScene(scene);
            currentStage.setTitle("Ajouter Pharmaceutique - Étape 1"); // Met à jour le titre de la fenêtre
            currentStage.show(); // Ré-affiche la fenêtre si nécessaire

            System.out.println("✅ AjouterPharmaceutiqueP1.fxml chargé avec succès dans la même fenêtre !");
            JFXButton autreBtn = (JFXButton) pane.lookup("#autreBtn");
            if (autreBtn!= null) {
                // Action vers ajouterAutre dans la même fenêtre
                autreBtn.setOnAction(e -> goToAjouterAutre(currentStage));

                System.out.println("✅ Action configurée pour le bouton `autreBtn`.");
            } else {
                System.err.println("❌ Le bouton `autreBtn` est introuvable dans le fichier AjouterPharmaceutiqueP1.fxml !");
            }
            JFXButton pharmaceutiqueBtn = (JFXButton) pane.lookup("#pharmaceutiqueBtn");
            if (pharmaceutiqueBtn!= null) {
                // Action vers ajouterAutre dans la même fenêtre
                pharmaceutiqueBtn.setOnAction(e -> goToAjouterPharmaceutiqueP1(currentStage));
                System.out.println("✅ Action configurée pour le bouton `pharmaceutiqueBtn`.");
            } else {
                System.err.println("❌ Le bouton `autreBtn` est introuvable dans le fichier AjouterPharmaceutiqueP1.fxml !");
            }
            JFXButton suivantBtn = (JFXButton) pane.lookup("#suivantBtn");
            if (suivantBtn != null) {
                // Action vers ajouterPharmaceutiqueP2 dans la même fenêtre
                suivantBtn.setOnAction(e -> goToAjouterPharmaceutiqueP2(currentStage));
                System.out.println("✅ Action configurée pour le bouton `suivantBtn`.");
            } else {
                System.err.println("❌ Le bouton `suivantBtn` est introuvable dans le fichier AjouterPharmaceutiqueP1.fxml !");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("❌ Erreur lors du chargement de AjouterPharmaceutiqueP1.fxml !");
        }
    }
    @FXML
    public void goToAjouterAutre(Stage currentStage) {
        try {
            // Charger AjouterPharmaceutiqueP2.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces/AjouterAutre.fxml"));
            AnchorPane pane = loader.load();

            // Créer une nouvelle scène avec le contenu chargé
            Scene scene = new Scene(pane);

            // Remplace la scène existante dans la fenêtre actuelle
            currentStage.setScene(scene);
            currentStage.setTitle("Ajouter Autre "); // Met à jour le titre de la fenêtre
            currentStage.show(); // Ré-affiche la fenêtre si nécessaire

            System.out.println("✅ AjouterAutre.fxml chargé avec succès dans la même fenêtre !");
            JFXButton pharmaceutiqueBtn = (JFXButton) pane.lookup("#pharmaceutiqueBtn");
            if (pharmaceutiqueBtn!= null) {
                // Action vers ajouterAutre dans la même fenêtre
                pharmaceutiqueBtn.setOnAction(e -> goToAjouterPharmaceutiqueP1(currentStage));
                System.out.println("✅ Action configurée pour le bouton `pharmaceutiqueBtn`.");
            } else {
                System.err.println("❌ Le bouton `autreBtn` est introuvable dans le fichier AjouterPharmaceutiqueP1.fxml !");
            }
            JFXButton autreBtn = (JFXButton) pane.lookup("#autreBtn");
            if (autreBtn!= null) {
                // Action vers ajouterAutre dans la même fenêtre
                autreBtn.setOnAction(e -> goToAjouterAutre(currentStage));

                System.out.println("✅ Action configurée pour le bouton `autreBtn`.");
            } else {
                System.err.println("❌ Le bouton `autreBtn` est introuvable dans le fichier AjouterPharmaceutiqueP1.fxml !");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("❌ Erreur lors du chargement de AjouterAutre.fxml !");
        }
    }


    /**
     * Affiche ou masque un sous-menu avec animation.
     *
     * @param menu Le menu à afficher ou masquer.
     */
    public void toggleSubMenu(VBox menu) {
        if (menuStates.containsKey(menu)) {
            if (menuStates.get(menu)) hideMenu(menu); // Si menu ouvert, le cacher
            else showMenu(menu); // Sinon, l'afficher
        }
    }

    /**
     * Affiche un menu avec une animation.
     *
     * @param menu Le menu à afficher
     */
    private void showMenu(VBox menu) {
        if (menu != null) {
            FadeTransition fadeIn = new FadeTransition(Duration.millis(300), menu);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.setOnFinished(e -> {
                menu.setVisible(true);
                menu.setManaged(true);
                menuStates.put(menu, true);
            });
            fadeIn.play();
        } else {
            System.err.println("Le menu à afficher est null.");
        }
    }

    /**
     * Masque un menu avec une animation.
     *
     * @param menu Le menu à masquer
     */
    private void hideMenu(VBox menu) {
        if (menu != null) {
            FadeTransition fadeOut = new FadeTransition(Duration.millis(300), menu);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.setOnFinished(e -> {
                menu.setVisible(false);
                menu.setManaged(false);
                menuStates.put(menu, false);
            });
            fadeOut.play();
        } else {
            System.err.println("Le menu à cacher est null.");
        }
    }

    /**
     * Charge une vue donnée dans le `rootStackPane` avec une animation fluide.
     *
     * @param fxmlPath Chemin du fichier FXML à charger
     */
    private void loadView(String fxmlPath) {
        try {
            // Charger la vue
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent view = loader.load();

            // Transition d'apparition
            FadeTransition fadeTransition = new FadeTransition(Duration.millis(300), view);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);

            // Remplacer la vue dans le `rootStackPane`
            if (rootStackPane != null) {
                rootStackPane.getChildren().clear();
                rootStackPane.getChildren().add(view);

                // Jouer l'animation
                fadeTransition.play();
            } else {
                System.err.println("Le rootStackPane est null. Vérifiez l'initialisation dans le FXML.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gestion du clic sur le bouton du menu Gestion Médicale.
     */
    @FXML
    public void onMenu1ButtonClicked() {
        toggleSubMenu(gestionMedicaleMenu);
    }

    /**
     * Gestion du clic sur le bouton du menu Stock.
     */
    @FXML
    public void onMenu2ButtonClicked() {
        toggleSubMenu(stockMenu);
    }

    /**
     * Gestion du clic sur le bouton du menu Transactions.
     */
    @FXML
    public void onMenu3ButtonClicked() {
        toggleSubMenu(transactionsMenu);
    }
}