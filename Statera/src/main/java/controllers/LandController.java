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
        Rectangle rectangle = new Rectangle(25, 25);
        new ImagePattern(this.land.getBiome(row, col).getImage());
        rectangle.setFill(new ImagePattern(this.land.getBiome(row, col).getImage()));
        rectangle.setOnMouseClicked(event -> handleRectangleClick(rectangle));
        this.land.getBiome(row, col).setRectangle(rectangle);
      }
    }
    show();
  }

  public void handleRectangleClick(Rectangle rectangle) {
    int colIndex = GridPane.getRowIndex(rectangle);
    int rowIndex = GridPane.getColumnIndex(rectangle);
    this.land.setBiome(rowIndex, colIndex, this.BiomeSelected);
    Rectangle biomeRectangle = new Rectangle(25, 25);
    biomeRectangle.setFill(new ImagePattern(this.land.getBiome(rowIndex, colIndex).getImage()));
    biomeRectangle.setOnMouseClicked(event -> handleRectangleClick(biomeRectangle));
    this.land.getBiome(rowIndex, colIndex).setRectangle(biomeRectangle);
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
  public void onClickedSelectLandButton(ActionEvent event) {
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

