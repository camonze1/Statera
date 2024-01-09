package controllers;

import enums.BiomeEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BiomeController {

  //  Attributes  //

  private BiomeEnum biomeSelected;

  private LandController landController;

  // Buttons //

  @FXML
  private Button waterButton;
  @FXML
  private Button grassButton;
  @FXML
  private Button forestButton;
  @FXML
  private Button buildingButton;
  @FXML
  private Button publicBuildingButton;
  @FXML
  private Button desertButton;
  @FXML
  private Button jungleButton;
  @FXML
  private Button mountainButton;

  //  Methods  //

  public void selectBiomeAndClose(ActionEvent event) {
    this.landController.setBiomeSelected(this.biomeSelected);
    home(event);
  }

  public void initialize() {
    Image imageWater = new Image(getClass().getResource("/ive/statera/img/tiles/b_water.jpg").toExternalForm());
    ImageView imgWaterView = new ImageView(imageWater);
    imgWaterView.setFitWidth(30);
    imgWaterView.setFitHeight(30);
    waterButton.setGraphic(imgWaterView);
    waterButton.setTooltip(new Tooltip("Water"));

    Image imageGrass = new Image(getClass().getResource("/ive/statera/img/tiles/b_grass.jpg").toExternalForm());
    ImageView imgGrassView = new ImageView(imageGrass);
    imgGrassView.setFitWidth(30);
    imgGrassView.setFitHeight(30);
    grassButton.setGraphic(imgGrassView);
    grassButton.setTooltip(new Tooltip("Grass"));

    Image imageForest = new Image(getClass().getResource("/ive/statera/img/tiles/b_forest.jpg").toExternalForm());
    ImageView imgForestView = new ImageView(imageForest);
    imgForestView.setFitWidth(30);
    imgForestView.setFitHeight(30);
    forestButton.setGraphic(imgForestView);
    forestButton.setTooltip(new Tooltip("Forest"));

    Image imgBuilding = new Image(getClass().getResource("/ive/statera/img/tiles/b_building.jpg").toExternalForm());
    ImageView imgBuildingView = new ImageView(imgBuilding);
    imgBuildingView.setFitWidth(30);
    imgBuildingView.setFitHeight(30);
    buildingButton.setGraphic(imgBuildingView);
    buildingButton.setTooltip(new Tooltip("Building"));

    Image imagePublicBuilding = new Image(getClass().getResource("/ive/statera/img/tiles/building.png").toExternalForm());
    ImageView imgPublicBuildingView = new ImageView(imagePublicBuilding);
    imgPublicBuildingView.setFitWidth(30);
    imgPublicBuildingView.setFitHeight(30);
    publicBuildingButton.setGraphic(imgPublicBuildingView);
    publicBuildingButton.setTooltip(new Tooltip("Public Building"));

    Image imageDesert = new Image(getClass().getResource("/ive/statera/img/tiles/b_desert.jpg").toExternalForm());
    ImageView imgDesertView = new ImageView(imageDesert);
    imgDesertView.setFitWidth(30);
    imgDesertView.setFitHeight(30);
    desertButton.setGraphic(imgDesertView);
    desertButton.setTooltip(new Tooltip("Desert"));

    Image imageJungle = new Image(getClass().getResource("/ive/statera/img/tiles/b_jungle.jpg").toExternalForm());
    ImageView imgJungleView = new ImageView(imageJungle);
    imgJungleView.setFitWidth(30);
    imgJungleView.setFitHeight(30);
    jungleButton.setGraphic(imgJungleView);
    jungleButton.setTooltip(new Tooltip("Jungle"));

    Image imageMountain = new Image(getClass().getResource("/ive/statera/img/tiles/b_mountain.jpg").toExternalForm());
    ImageView imgMountainView = new ImageView(imageMountain);
    imgMountainView.setFitWidth(30);
    imgMountainView.setFitHeight(30);
    mountainButton.setGraphic(imgMountainView);
    mountainButton.setTooltip(new Tooltip("Mountain"));
  }

  //  FXML Methods  //

  @FXML
  public void home(ActionEvent event) {
    Scene scene = ((Node) event.getSource()).getScene();
    Stage stage = (Stage) scene.getWindow();
    stage.close();
  }

  @FXML
  public void onClickedGrassButton(ActionEvent event) {
    this.biomeSelected = BiomeEnum.GRASS;
    selectBiomeAndClose(event);
  }

  @FXML
  public void onClickedBuildingButton(ActionEvent event) {
    this.biomeSelected = BiomeEnum.BUILDING;
    selectBiomeAndClose(event);
  }

  @FXML
  public void onClickedPublicBuildingButton(ActionEvent event) {
    this.biomeSelected = BiomeEnum.PUBLICBUILDING;
    selectBiomeAndClose(event);
  }

  @FXML
  public void onClickedDesertButton(ActionEvent event) {
    this.biomeSelected = BiomeEnum.DESERT;
    selectBiomeAndClose(event);
  }

  @FXML
  public void onClickedForestButton(ActionEvent event) {
    this.biomeSelected = BiomeEnum.FOREST;
    selectBiomeAndClose(event);
  }

  @FXML
  public void onClickedJungleButton(ActionEvent event) {
    this.biomeSelected = BiomeEnum.JUNGLE;
    selectBiomeAndClose(event);
  }

  @FXML
  public void onClickedMountainButton(ActionEvent event) {
    this.biomeSelected = BiomeEnum.MOUNTAIN;
    selectBiomeAndClose(event);
  }

  @FXML
  public void onClickedWaterButton(ActionEvent event) {
    this.biomeSelected = BiomeEnum.WATER;
    selectBiomeAndClose(event);
  }

  //  Getters & Setters  //

  public void setLandController(LandController landController) {
    this.landController = landController;
  }
}
