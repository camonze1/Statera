package controllers;

import enums.BiomeEnum;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Text;
import models.Biome;
import models.Land;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LandController {

    private BiomeEnum BiomeSelected;

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
        land.setBiome(3, 2, BiomeEnum.BUILDING);
        land.setBiome(0, 0, BiomeEnum.WATER);

        System.out.println(land.getLandSizeTotal());
        System.out.println(land.getLandSize()[0]);
        System.out.println(land.getLandSize()[1]);

        for (int row = 0; row < land.getLandSize()[0]; row++) {
            for (int col  = 0; col < land.getLandSize()[1]; col++) {

                Rectangle rectangle = new Rectangle(25, 25);

                System.out.println(row);
                System.out.println(col);

                System.out.println(this.land.getBiome(row, col).getImage());

                new ImagePattern(this.land.getBiome(row, col).getImage());

                rectangle.setFill(new ImagePattern(this.land.getBiome(row, col).getImage()));

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
        //rectangle2.setFill(this.land.getBiome(rowIndex, colIndex).getColor());

        //Image img = new Image("C:/Users/julie/OneDrive/Documents/Polytech/4a/IVE/life-on-land/Statera/src/main/java/image.png");
        rectangle2.setFill(new ImagePattern(this.land.getBiome(rowIndex, colIndex).getImage()));
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

    @FXML
    public void onClickedGrassButton(){
        BiomeSelected = BiomeEnum.GRASS;
    }
    @FXML
    public void onClickedBuildingButton(){
        BiomeSelected = BiomeEnum.BUILDING;
    }
    @FXML
    public void onClickedDesertButton(){
        BiomeSelected = BiomeEnum.DESERT;
    }
    @FXML
    public void onClickedForestButton(){
        BiomeSelected = BiomeEnum.FOREST;
    }
    @FXML
    public void onClickedJungleButton(){
        BiomeSelected = BiomeEnum.JUNGLE;
    }
    @FXML
    public void onClickedMountainButton(){
        BiomeSelected = BiomeEnum.MOUNTAIN;
    }
    @FXML
    public void onClickedWaterButton(){
        BiomeSelected = BiomeEnum.WATER;
    }
}

