package controllers;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import models.Land;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LandController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label labelsize;
    @FXML
    private GridPane gridPane;
    @FXML
    private ChoiceBox<Integer> NbLignes;
    @FXML
    private ChoiceBox<Integer> NbColonnes;
    @FXML
    private Label LabelLignes;
    @FXML
    private Label LabelColonnes;
    @FXML
    private Button TailleValidation;
    Land land;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("");
    }
    @FXML
    protected void onValidateButtonClick() {
        land=new Land(NbLignes.getValue(),NbColonnes.getValue());
        LabelLignes.setVisible(false);
        LabelColonnes.setVisible(false);
        TailleValidation.setVisible(false);
        NbLignes.setVisible(false);
        NbColonnes.setVisible(false);
        labelsize.setText("Lines: "+ land.getLandSize()[0]+"\nColumns: "+ land.getLandSize()[1]);

        for (int col = 0; col < land.getLandSize()[1]; col++) {
            for (int row  = 0; row < land.getLandSize()[0]; row++) {
                Rectangle rectangle = createClickableRectangle();
                gridPane.add(rectangle, col, row);
            }
        }
    }

    @FXML
    public void initialize() {
        NbLignes.getItems().addAll(8,9,10,11,12,13,14,15,16,17,18,19,20);
        NbColonnes.getItems().addAll(8,9,10,11,12,13,14,15,16,17,18,19,20);
        // Ajout des rectangles cliquables à la grille
    }

    private Rectangle createClickableRectangle() {
        Rectangle rectangle = new Rectangle(25, 25); // Creation des rectangles
        rectangle.setFill(Color.GREY);

        // Au clic on appelle la méthode handleRectangleClick
        rectangle.setOnMouseClicked(event -> handleRectangleClick(rectangle));

        return rectangle;
    }

    private void handleRectangleClick(Rectangle rectangle) {
        // Ce qui se passe au click
        rectangle.setFill(Color.GREEN);
    }
}

