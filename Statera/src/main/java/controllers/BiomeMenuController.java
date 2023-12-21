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

public class BiomeMenuController {
  private BiomeEnum BiomeSelected;

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
//  public void openPreviousScene(ActionEvent event) {
//    FXMLLoader loader = new FXMLLoader(getClass().getResource("/ive/statera/Game.fxml"));
//    LandController landController = loader.getController();
//    landController.setBiomeSelected(this.BiomeSelected);
//    Scene scene = ((Node) event.getSource()).getScene();
//    Stage stage = (Stage) scene.getWindow();
//    stage.close();
//  }

  public void onClickedHome(ActionEvent event) {
    Scene scene = ((Node) event.getSource()).getScene();
    Stage stage = (Stage) scene.getWindow();
    stage.close();
  }

  @FXML
  public void onClickedGrassButton(ActionEvent event) {
    BiomeSelected = BiomeEnum.GRASS;
    System.out.println("Le biome que tu viens de choisir est : " + BiomeSelected);
    openPreviousScene(event);
  }

  @FXML
  public void onClickedBuildingButton(ActionEvent event) {
    BiomeSelected = BiomeEnum.BUILDING;
    System.out.println("Le biome que tu viens de choisir est : " + BiomeSelected);
    openPreviousScene(event);
  }

  @FXML
  public void onClickedDesertButton(ActionEvent event) {
    BiomeSelected = BiomeEnum.DESERT;
    System.out.println("Le biome que tu viens de choisir est : " + BiomeSelected);
    openPreviousScene(event);
  }

  @FXML
  public void onClickedForestButton(ActionEvent event) {
    BiomeSelected = BiomeEnum.FOREST;
    System.out.println("Le biome que tu viens de choisir est : " + BiomeSelected);
    openPreviousScene(event);
  }

  @FXML
  public void onClickedJungleButton(ActionEvent event) {
    BiomeSelected = BiomeEnum.JUNGLE;
    System.out.println("Le biome que tu viens de choisir est : " + BiomeSelected);
    openPreviousScene(event);
  }

  @FXML
  public void onClickedMountainButton(ActionEvent event) {
    BiomeSelected = BiomeEnum.MOUNTAIN;
    System.out.println("Le biome que tu viens de choisir est : " + BiomeSelected);
    openPreviousScene(event);
  }

  @FXML
  public void onClickedWaterButton(ActionEvent event) {
    BiomeSelected = BiomeEnum.WATER;
    System.out.println("Le biome que tu viens de choisir est : " + BiomeSelected);
    openPreviousScene(event);
  }
}
