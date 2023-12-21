package controllers;

import enums.BiomeEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BiomeMenuController {
  private BiomeEnum biomeSelected;
  private LandController landController;

  public void selectBiomeAndClose(ActionEvent event) {
    this.landController.setBiomeSelected(this.biomeSelected);
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
    this.biomeSelected = BiomeEnum.GRASS;
    System.out.println("Le biome que tu viens de choisir est : " + this.biomeSelected);
    selectBiomeAndClose(event);
  }

  @FXML
  public void onClickedBuildingButton(ActionEvent event) {
    this.biomeSelected = BiomeEnum.BUILDING;
    System.out.println("Le biome que tu viens de choisir est : " + this.biomeSelected);
    selectBiomeAndClose(event);
  }

  @FXML
  public void onClickedDesertButton(ActionEvent event) {
    this.biomeSelected = BiomeEnum.DESERT;
    System.out.println("Le biome que tu viens de choisir est : " + this.biomeSelected);
    selectBiomeAndClose(event);
  }

  @FXML
  public void onClickedForestButton(ActionEvent event) {
    this.biomeSelected = BiomeEnum.FOREST;
    System.out.println("Le biome que tu viens de choisir est : " + this.biomeSelected);
    selectBiomeAndClose(event);
  }

  @FXML
  public void onClickedJungleButton(ActionEvent event) {
    this.biomeSelected = BiomeEnum.JUNGLE;
    System.out.println("Le biome que tu viens de choisir est : " + this.biomeSelected);
    selectBiomeAndClose(event);
  }

  @FXML
  public void onClickedMountainButton(ActionEvent event) {
    this.biomeSelected = BiomeEnum.MOUNTAIN;
    System.out.println("Le biome que tu viens de choisir est : " + this.biomeSelected);
    selectBiomeAndClose(event);
  }

  @FXML
  public void onClickedWaterButton(ActionEvent event) {
    this.biomeSelected = BiomeEnum.WATER;
    System.out.println("Le biome que tu viens de choisir est : " + this.biomeSelected);
    selectBiomeAndClose(event);
  }

  public void setLandController(LandController landController) {
    this.landController = landController;
  }
}
