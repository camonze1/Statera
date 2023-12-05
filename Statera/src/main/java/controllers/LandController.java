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

    private BiomeEnum BiomeSelected = BiomeEnum.BUILDING;

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
        land.setBiome(1, 2, BiomeEnum.DESERT);
        land.setBiome(4, 4, BiomeEnum.JUNGLE);
        land.setBiome(3, 2, BiomeEnum.BUILDING);
        land.setBiome(0, 0, BiomeEnum.WATER);

        System.out.println(land.getLandSizeTotal());
        System.out.println(land.getLandSize()[0]);
        System.out.println(land.getLandSize()[1]);

        for (int row = 0; row < land.getLandSize()[0]; row++) {
            for (int col  = 0; col < land.getLandSize()[1]; col++) {

                Rectangle rectangle = new Rectangle(25, 25);
                rectangle.setFill(this.land.getBiome(row, col).getColor());
                rectangle.setOnMouseClicked(event -> handleRectangleClick(rectangle));
                this.land.getBiome(row, col).setRectangle(rectangle);


            }
        }
        afficher();
    }


    public void handleRectangleClick(Rectangle rectangle) {

        // recupere les index de l'element rectangle
        int colIndex = GridPane.getRowIndex(rectangle);
        int rowIndex = GridPane.getColumnIndex(rectangle);

        // remplace le biome de ces index par le biome selectionne
        this.land.setBiome(rowIndex, colIndex, this.BiomeSelected);

        // creer un rectangle pour ce nouveau biome
        Rectangle rectangle2 = new Rectangle(25, 25);
        rectangle2.setFill(this.land.getBiome(rowIndex, colIndex).getColor());
        rectangle2.setOnMouseClicked(event -> handleRectangleClick(rectangle2));

        // ajoute ce nouveau rectangle a ce biome
        this.land.getBiome(rowIndex, colIndex).setRectangle(rectangle2);

        // reaffiche la grille
        afficher();

    }

    public void afficher(){
        // nettoie la grille
        gridPane.getChildren().clear();

        // affiche la grille
        for (int row = 0; row < land.getLandSize()[0]; row++) {
            for (int col  = 0; col < land.getLandSize()[1]; col++) {
                gridPane.add(this.land.getBiome(row, col).getRectangle(), row, col);
            }
        }
    }
}

