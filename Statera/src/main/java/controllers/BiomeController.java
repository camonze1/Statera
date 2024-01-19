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
import models.*;

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
    Image imageWater = new Image(getClass().getResource("/ive/statera/img/tiles/water.png").toExternalForm());
    ImageView imgWaterView = new ImageView(imageWater);
    imgWaterView.setFitWidth(50);
    imgWaterView.setFitHeight(50);
    this.waterButton.setGraphic(imgWaterView);

    Image imageGrass = new Image(getClass().getResource("/ive/statera/img/tiles/grass.jpg").toExternalForm());
    ImageView imgGrassView = new ImageView(imageGrass);
    imgGrassView.setFitWidth(50);
    imgGrassView.setFitHeight(50);
    this.grassButton.setGraphic(imgGrassView);

    Image imageForest = new Image(getClass().getResource("/ive/statera/img/tiles/forest.png").toExternalForm());
    ImageView imgForestView = new ImageView(imageForest);
    imgForestView.setFitWidth(50);
    imgForestView.setFitHeight(50);
    this.forestButton.setGraphic(imgForestView);
    Forest forest = new Forest();
    this.forestButton.setTooltip(new Tooltip(forest.getStringCost()));

    Image imgBuilding = new Image(getClass().getResource("/ive/statera/img/tiles/building.png").toExternalForm());
    ImageView imgBuildingView = new ImageView(imgBuilding);
    imgBuildingView.setFitWidth(50);
    imgBuildingView.setFitHeight(50);
    this.buildingButton.setGraphic(imgBuildingView);
    Building building = new Building();
    this.buildingButton.setTooltip(new Tooltip(building.getStringCost()));

    Image imagePublicBuilding = new Image(getClass().getResource("/ive/statera/img/tiles/public_building.png").toExternalForm());
    ImageView imgPublicBuildingView = new ImageView(imagePublicBuilding);
    imgPublicBuildingView.setFitWidth(50);
    imgPublicBuildingView.setFitHeight(50);
    this.publicBuildingButton.setGraphic(imgPublicBuildingView);
    PublicBuilding publicbuilding = new PublicBuilding();
    this.publicBuildingButton.setTooltip(new Tooltip(publicbuilding.getStringCost()));

    Image imageDesert = new Image(getClass().getResource("/ive/statera/img/tiles/desert.png").toExternalForm());
    ImageView imgDesertView = new ImageView(imageDesert);
    imgDesertView.setFitWidth(50);
    imgDesertView.setFitHeight(50);
    this.desertButton.setGraphic(imgDesertView);
    Desert desert = new Desert();
    this.desertButton.setTooltip(new Tooltip(desert.getStringCost()));

    Image imageJungle = new Image(getClass().getResource("/ive/statera/img/tiles/jungle.jpg").toExternalForm());
    ImageView imgJungleView = new ImageView(imageJungle);
    imgJungleView.setFitWidth(50);
    imgJungleView.setFitHeight(50);
    this.jungleButton.setGraphic(imgJungleView);
    Jungle jungle = new Jungle();
    this.jungleButton.setTooltip(new Tooltip(jungle.getStringCost()));

    Image imageMountain = new Image(getClass().getResource("/ive/statera/img/tiles/mountain.jpg").toExternalForm());
    ImageView imgMountainView = new ImageView(imageMountain);
    imgMountainView.setFitWidth(50);
    imgMountainView.setFitHeight(50);
    this.mountainButton.setGraphic(imgMountainView);
    Mountain mountain = new Mountain();
    this.mountainButton.setTooltip(new Tooltip(mountain.getStringCost()));
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
