package controllers;

import enums.BiomeEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import models.Land;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class LandController {

  @FXML
  private GridPane gridPane;
  private Land land;
  private BiomeEnum biomeSelected;

  @FXML
  public void initialize() {
    this.land = new Land(15, 15);
    this.land.setBiome(1, 1, BiomeEnum.WATER);
    this.land.setBiome(1, 2, BiomeEnum.DESERT);
    this.land.setBiome(3, 2, BiomeEnum.BUILDING);
    this.land.setBiome(2, 2, BiomeEnum.DESERT);
    this.land.setBiome(0, 0, BiomeEnum.WATER);
    for (int row = 0; row < this.land.getLandSize()[0]; row++) {
      for (int col = 0; col < this.land.getLandSize()[1]; col++) {
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

    if (this.land.getBiome(rowIndex, colIndex).getType() == BiomeEnum.FREEWASTELAND) {
      System.out.println("La tile sur laquelle tu viens de cliquer est un biome : " + this.land.getBiome(rowIndex, colIndex).getType());
      this.land.setBiome(rowIndex, colIndex, this.biomeSelected);
      Rectangle biomePlot = new Rectangle(35, 35);
      biomePlot.setFill(new ImagePattern(this.land.getBiome(rowIndex, colIndex).getImage()));
      biomePlot.setOnMouseClicked(event -> handleRectangleClick(biomePlot));
      this.land.getBiome(rowIndex, colIndex).setRectangle(biomePlot);
      System.out.println("Tu viens de poser un biome : " + this.biomeSelected);
      show();
    } else {
      if (this.biomeSelected != null) {
        showNotAllowedPopup();
      }
    }
  }

  private void showNotAllowedPopup() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Attention");
    alert.setHeaderText(null);
    alert.setContentText("Tu ne peux pas poser une tuile qui n'est pas libre.");
    alert.showAndWait();
  }

  public void show() {
    this.gridPane.getChildren().clear();
    for (int row = 0; row < this.land.getLandSize()[0]; row++) {
      for (int col = 0; col < this.land.getLandSize()[1]; col++) {
        this.gridPane.add(this.land.getBiome(row, col).getRectangle(), row, col);
      }
    }
  }

  @FXML
  public void onClickedMenu(ActionEvent event) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/ive/statera/Menu.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root, 600, 500);
      Stage menuStage = new Stage();
      MenuController menuController = loader.getController();
      menuController.setLandController(this);
      menuStage.setTitle("Menu - Statera");
      menuStage.setScene(scene);
      menuStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void setBiomeSelected(BiomeEnum biomeSelected) {
    this.biomeSelected = biomeSelected;
  }
}
