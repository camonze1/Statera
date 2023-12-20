package controllers;

import enums.BiomeEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
  private BiomeEnum BiomeSelected;

  public void Initialize() {
    System.out.println("MenuController");
  }
  private void openPreviousScene(ActionEvent event) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/ive/statera/Game.fxml"));
      Parent root = loader.load();
      LandController gameController = loader.getController();
      gameController.setBiomeSelected(BiomeSelected);
      Scene scene = new Scene(root);
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  @FXML
  public void onClickedGrassButton(ActionEvent event) {
    BiomeSelected = BiomeEnum.GRASS;
    System.out.println(BiomeSelected);
    openPreviousScene(event);
  }

  @FXML
  public void onClickedBuildingButton(ActionEvent event) {
    BiomeSelected = BiomeEnum.BUILDING;
    System.out.println(BiomeSelected);
    openPreviousScene(event);
  }

  @FXML
  public void onClickedDesertButton(ActionEvent event) {
    BiomeSelected = BiomeEnum.DESERT;
    System.out.println(BiomeSelected);
    openPreviousScene(event);
  }

  @FXML
  public void onClickedForestButton(ActionEvent event) {
    BiomeSelected = BiomeEnum.FOREST;
    System.out.println(BiomeSelected);
    openPreviousScene(event);
  }

  @FXML
  public void onClickedJungleButton(ActionEvent event) {
    BiomeSelected = BiomeEnum.JUNGLE;
    System.out.println(BiomeSelected);
    openPreviousScene(event);
  }

  @FXML
  public void onClickedMountainButton(ActionEvent event) {
    BiomeSelected = BiomeEnum.MOUNTAIN;
    System.out.println(BiomeSelected);
    openPreviousScene(event);
  }

  @FXML
  public void onClickedWaterButton(ActionEvent event) {
    BiomeSelected = BiomeEnum.WATER;
    System.out.println(BiomeSelected);
    openPreviousScene(event);
  }

  public BiomeEnum getBiomeSelected() {
    return BiomeSelected;
  }
}
