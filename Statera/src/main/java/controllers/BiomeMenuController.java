package controllers;

import enums.BiomeEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BiomeMenuController {
  private BiomeEnum BiomeSelected;
  private LandController landController;

  public void selectBiomeAndClose(ActionEvent event) {
    landController.setBiomeSelected(this.BiomeSelected);
    Scene scene = ((Node) event.getSource()).getScene();
    Stage stage = (Stage) scene.getWindow();
    stage.close();
  }

  public void onClickedHome(ActionEvent event) {
    Scene scene = ((Node) event.getSource()).getScene();
    Stage stage = (Stage) scene.getWindow();
    stage.close();
  }

  @FXML
  public void onClickedGrassButton(ActionEvent event) {
    BiomeSelected = BiomeEnum.GRASS;
    System.out.println("Le biome que tu viens de choisir est : " + BiomeSelected);
    landController.setBiomeSelected(this.BiomeSelected);
    selectBiomeAndClose(event);
  }

  @FXML
  public void onClickedBuildingButton(ActionEvent event) {
    BiomeSelected = BiomeEnum.BUILDING;
    System.out.println("Le biome que tu viens de choisir est : " + BiomeSelected);
    selectBiomeAndClose(event);
  }

  @FXML
  public void onClickedDesertButton(ActionEvent event) {
    BiomeSelected = BiomeEnum.DESERT;
    System.out.println("Le biome que tu viens de choisir est : " + BiomeSelected);
    selectBiomeAndClose(event);
  }

  @FXML
  public void onClickedForestButton(ActionEvent event) {
    BiomeSelected = BiomeEnum.FOREST;
    System.out.println("Le biome que tu viens de choisir est : " + BiomeSelected);
    selectBiomeAndClose(event);
  }

  @FXML
  public void onClickedJungleButton(ActionEvent event) {
    BiomeSelected = BiomeEnum.JUNGLE;
    System.out.println("Le biome que tu viens de choisir est : " + BiomeSelected);
    selectBiomeAndClose(event);
  }

  @FXML
  public void onClickedMountainButton(ActionEvent event) {
    BiomeSelected = BiomeEnum.MOUNTAIN;
    System.out.println("Le biome que tu viens de choisir est : " + BiomeSelected);
    selectBiomeAndClose(event);
  }

  @FXML
  public void onClickedWaterButton(ActionEvent event) {
    BiomeSelected = BiomeEnum.WATER;
    System.out.println("Le biome que tu viens de choisir est : " + BiomeSelected);
    selectBiomeAndClose(event);
  }

  public void setLandController(LandController landController) {
    this.landController = landController;
  }
}
