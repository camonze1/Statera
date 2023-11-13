package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LandController {
    @FXML
    private Label welcomeText;
    @FXML
    private GridPane gridPane;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("oui c bien ma gueule");
    }

    @FXML
    public void initialize(int nbRows, int nbCols) {
        // Ajout des rectangles cliquables à la grille
        for (int row = 0; row < nbRows; row++) {
            for (int col  = 0; col < nbCols; col++) {
                Rectangle rectangle = createClickableRectangle();
                gridPane.add(rectangle, row, col);
            }
        }
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

