package controllers;

import enums.BiomeEnum;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import models.Biome;
import models.Land;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LandController {


    @FXML
    private Label texteTitre; //= new Label();

    @FXML
    private GridPane gridPane;
    Land land;


    @FXML
    public void initialize() {


        this.land = new Land(20,20);

        land.setBiome(1, 1, BiomeEnum.WATER);
        land.setBiome(2, 2, BiomeEnum.DESERT);
        land.setBiome(4, 4, BiomeEnum.JUNGLE);
        land.setBiome(3, 2, BiomeEnum.BUILDING);
        land.setBiome(1, 2, BiomeEnum.DESERT);
        land.setBiome(0, 0, BiomeEnum.WATER);

        System.out.println(land.getLandSizeTotal());
        System.out.println(land.getLandSize()[0]);
        System.out.println(land.getLandSize()[1]);

        for (int col = 0; col < land.getLandSize()[1]; col++) {
            for (int row  = 0; row < land.getLandSize()[0]; row++) {
                Rectangle rectangle = createClickableRectangle(land.getBiome(col, row));
                gridPane.add(rectangle, col, row);
            }
        }
    }

    private Rectangle createClickableRectangle(Biome biome) {
        Rectangle rectangle = new Rectangle(25, 25); // Creation des rectangles
        rectangle.setFill(biome.getColor());
        rectangle.setOnMouseClicked(event -> handleRectangleClick(rectangle));

        return rectangle;
    }

    private void handleRectangleClick(Rectangle rectangle) {
        // Ce qui se passe au click
        rectangle.setFill(Color.GREEN);
    }
}

