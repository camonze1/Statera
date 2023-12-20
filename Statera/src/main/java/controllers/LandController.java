package controllers;

import enums.BiomeEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import models.Land;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class LandController {

  private BiomeEnum BiomeSelected;

  @FXML
  private GridPane gridPane;
  private Land land;

  @FXML
  public void initialize() {
    this.land = new Land(15, 15);

    land.setBiome(1, 1, BiomeEnum.WATER);
    land.setBiome(2, 2, BiomeEnum.DESERT);
    land.setBiome(1, 2, BiomeEnum.DESERT);
    land.setBiome(3, 2, BiomeEnum.BUILDING);
    land.setBiome(0, 0, BiomeEnum.WATER);

    for (int row = 0; row < land.getLandSize()[0]; row++) {
      for (int col = 0; col < land.getLandSize()[1]; col++) {
        Rectangle plot = new Rectangle(35, 35);
        new ImagePattern(this.land.getBiome(row, col).getImage());
        plot.setFill(new ImagePattern(this.land.getBiome(row, col).getImage()));
        plot.setOnMouseClicked(event -> handleRectangleClick(plot));
        this.land.getBiome(row, col).setRectangle(plot);
      }
    }
    show();
  }

  public void handleRectangleClick(Rectangle plot) {
    int colIndex = GridPane.getRowIndex(plot);
    int rowIndex = GridPane.getColumnIndex(plot);
    this.land.setBiome(rowIndex, colIndex, this.BiomeSelected);
    Rectangle biomePlot = new Rectangle(35, 35);
    biomePlot.setFill(new ImagePattern(this.land.getBiome(rowIndex, colIndex).getImage()));
    biomePlot.setOnMouseClicked(event -> handleRectangleClick(biomePlot));
    this.land.getBiome(rowIndex, colIndex).setRectangle(biomePlot);
    System.out.println(this.BiomeSelected);
    show();
  }

  public void show() {
    gridPane.getChildren().clear();
    for (int row = 0; row < land.getLandSize()[0]; row++) {
      for (int col = 0; col < land.getLandSize()[1]; col++) {
        gridPane.add(this.land.getBiome(row, col).getRectangle(), row, col);
      }
    }
  }


  @FXML
  public void onClickedMenu(ActionEvent event){
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/ive/statera/Menu.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public void setBiomeSelected(BiomeEnum biomeSelected) {
    System.out.println("Biome sélectionné dans GameController : " + biomeSelected);
    this.BiomeSelected = biomeSelected;
  }
}

//A FAIRE : FAIRE UN FOND DE COULEUR POUR QUE CE SOIT PLUS JOLIE
//CREER UN BOUTON MENU EN HAUT A GAUCHE DU LANDCONTROLLER POUR ALLER DANS LE MENU OU IL Y AURA LE BOUTON SELECTIONNER UN BIOME
//ET LE BOUTON REVENIR AU MENU PRINCIPAL