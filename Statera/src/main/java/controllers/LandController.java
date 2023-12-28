package controllers;

import enums.BiomeEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import models.Land;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class LandController {

  @FXML
  private GridPane gridPane;
  private Land land;
  private BiomeEnum biomeSelected;
  private Random random = new Random();

  @FXML
  private ProgressBar environmentBalanceProgressBar;
  @FXML
  private Label environmentBalanceLabel;

  private double naturalBiomeBalance;
  private double naturalBiomeBalanceRoundedValue;
  private double buildingBiomeBalance;
  private double buildingBiomeBalanceRoundedValue;
  private double waterBiomeBalance;
  private double waterBiomeBalanceRoundedValue;


  @FXML
  public void initialize() {
    initializeLand();
  }

  public void initializeLand() {
    this.land = new Land(15, 15);
    for (int i = 0; i < 5; i++) {
      setRandomBiomeToFreeWasteland(BiomeEnum.WATER);
    }
    for (int i = 0; i < 3; i++) {
      setRandomBiomeToFreeWasteland(BiomeEnum.GRASS);
    }
    for (int i = 0; i < 2; i++) {
      setRandomBiomeToFreeWasteland(BiomeEnum.FOREST);
    }
    setRandomBiomeToFreeWasteland(BiomeEnum.DESERT);
    for (int row = 0; row < this.land.getLandSize()[0]; row++) {
      for (int col = 0; col < this.land.getLandSize()[1]; col++) {
        Rectangle plot = new Rectangle(35, 35);
        new ImagePattern(this.land.getBiome(row, col).getImage());
        plot.setFill(new ImagePattern(this.land.getBiome(row, col).getImage()));
        plot.setOnMouseClicked(event -> onPlotClick(plot));
        this.land.getBiome(row, col).setRectangle(plot);
      }
    }
    updateBalance();
    show();
  }

  public void onPlotClick(Rectangle plot) {
    int line = GridPane.getColumnIndex(plot);
    int column = GridPane.getRowIndex(plot);

    if (this.biomeSelected != null) {
      if (this.land.getBiome(line, column).getType() == BiomeEnum.FREEWASTELAND) {
        buyBiome(line, column, this.biomeSelected);
        updateBalance();
      } else {
        informationWindow("Tu ne peux pas poser une tuile qui n'est pas libre.");
      }
    }
//    System.out.println("Tu viens de poser un biome : " + this.biomeSelected);
//    System.out.println("Number of occupied plot : " + this.land.getNumberOfOccupiedPlot());
//    System.out.println("Number of non occupied plot : " + this.land.getNumberOfNonOccupiedPlot());
//    System.out.println("Number of occupied plot of water : " + this.land.getNumberOfOccupiedPlotByType(BiomeEnum.WATER));
//    System.out.println("Number of occupied plot of forest : " + this.land.getNumberOfOccupiedPlotByType(BiomeEnum.FOREST));
//    System.out.println("Number of occupied plot of jungle : " + this.land.getNumberOfOccupiedPlotByType(BiomeEnum.JUNGLE));
//    System.out.println("Number of occupied plot of desert : " + this.land.getNumberOfOccupiedPlotByType(BiomeEnum.DESERT));
//    System.out.println("Number of occupied plot of grass : " + this.land.getNumberOfOccupiedPlotByType(BiomeEnum.GRASS));
//    System.out.println("Number of occupied plot of mountain : " + this.land.getNumberOfOccupiedPlotByType(BiomeEnum.MOUNTAIN));
//    System.out.println("Number of occupied plot of building : " + this.land.getNumberOfOccupiedPlotByType(BiomeEnum.BUILDING));
//    System.out.println("Number of occupied plot of free wasteland : " + this.land.getNumberOfOccupiedPlotByType(BiomeEnum.FREEWASTELAND));
//    System.out.println("Size of the land : " + this.land.getLandSize()[0] + "x" + this.land.getLandSize()[1]);
//    System.out.println("Total size of the land : " + this.land.getLandSizeTotal());
//    System.out.println("Total number of non blocked wasteland plot  : " + this.land.getTotalOfNonBlockedWastelandPlot());
//    System.out.println("Number of natural biome : " + this.land.getNumberOfNaturalBiome());
//    System.out.println("Number of water biome : " + this.land.getNumberOfOccupiedPlotByType(BiomeEnum.WATER));
//    System.out.println("Number of building biome : " + this.land.getNumberOfOccupiedPlotByType(BiomeEnum.BUILDING));
//    System.out.println("Environment balance : " + this.land.environmentBalance());
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
  @FXML
  public void onClickedViewBalance(ActionEvent event) {
    try {

      FXMLLoader loader = new FXMLLoader(getClass().getResource("/ive/statera/ViewBalance.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root, 600, 500);
      Stage viewBalanceStage = new Stage();

      ViewBalanceController viewBalanceController = loader.getController();
      viewBalanceController.setLandController(this);

      viewBalanceStage.setTitle("View balance - Statera");
      viewBalanceStage.setScene(scene);
      viewBalanceStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void updateBalance() {
    double environmentBalance = this.land.environmentBalance();
    environmentBalanceProgressBar.setProgress(environmentBalance / 100.0);
    Double environmentBalanceRoundedValue = roundToFirstDecimal(environmentBalance);
    environmentBalanceLabel.setText("" + environmentBalanceRoundedValue + "%");

    naturalBiomeBalance = this.land.getBalanceOfNaturalBiome();
    naturalBiomeBalanceRoundedValue = roundToFirstDecimal(naturalBiomeBalance);

    buildingBiomeBalance = this.land.getBalanceOfBuildingBiome();
    buildingBiomeBalanceRoundedValue = roundToFirstDecimal(buildingBiomeBalance);

    waterBiomeBalance = this.land.getBalanceOfWaterBiome();
    waterBiomeBalanceRoundedValue = roundToFirstDecimal(waterBiomeBalance);
  }

  public void buyBiome(int line, int column, BiomeEnum biomeSelected) {
    this.land.setBiome(line, column, biomeSelected);
    setBiomeOnPlot(line, column);
    HashMap<BiomeEnum, Integer> cost = this.land.getCostOfPlot(line, column);
    for (BiomeEnum key : cost.keySet()) {
      int numberOfBiomesToRemove = cost.get(key);
      List<int[]> biomeCoordinates = this.land.getCoordinatesByBiomeType(key);

      if (biomeCoordinates.size() < numberOfBiomesToRemove) {
        informationWindow("Tu n'as pas assez de ressource pour acheter ce biome.");
        this.land.setFreeWasteland(line, column);
        setBiomeOnPlot(line, column);
        return;
      }

      for (int i = 0; i < numberOfBiomesToRemove && !biomeCoordinates.isEmpty(); i++) {
        int[] randomCoordinate = biomeCoordinates.get(random.nextInt(biomeCoordinates.size()));
        this.land.setFreeWasteland(randomCoordinate[0], randomCoordinate[1]);
        setBiomeOnPlot(randomCoordinate[0], randomCoordinate[1]);
        biomeCoordinates.remove(randomCoordinate);
      }
    }
  }

  public void setBiomeOnPlot(int line, int column) {
    Rectangle biomePlot = new Rectangle(35, 35);
    biomePlot.setFill(new ImagePattern(this.land.getBiome(line, column).getImage()));
    biomePlot.setOnMouseClicked(event -> onPlotClick(biomePlot));
    this.land.getBiome(line, column).setRectangle(biomePlot);
    show();
  }

  public void setRandomBiomeToFreeWasteland(BiomeEnum biomeType) {
    List<int[]> freeWastelandCoordinates = land.getCoordinatesByBiomeType(BiomeEnum.FREEWASTELAND);
    if (!freeWastelandCoordinates.isEmpty()) {
      int[] randomCoordinate = freeWastelandCoordinates.get(random.nextInt(freeWastelandCoordinates.size()));
      land.setBiome(randomCoordinate[0], randomCoordinate[1], biomeType);
    }
  }

  private void informationWindow(String text) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Attention");
    alert.setHeaderText(null);
    alert.setContentText(text);
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

  public void setBiomeSelected(BiomeEnum biomeSelected) {
    this.biomeSelected = biomeSelected;
  }

  private double roundToFirstDecimal(double value) {
    return Math.round(value * 10.0) / 10.0;
  }

  public ProgressBar getEnvironmentBalanceProgressBar(){
    return environmentBalanceProgressBar;
  }
  public Label getEnvironmentBalanceLabel(){
    return environmentBalanceLabel;
  }
  public double getNaturalBiomeBalance(){
    return naturalBiomeBalance;
  }
  public double getNaturalBiomeBalanceRoundedValue(){
    return naturalBiomeBalanceRoundedValue;
  }
  public double getBuildingBiomeBalance(){return buildingBiomeBalance;}
  public double getBuildingBiomeBalanceRoundedValue(){return buildingBiomeBalanceRoundedValue;}
  public double getWaterBiomeBalance(){return waterBiomeBalance;}
  public double getWaterBiomeBalanceRoundedValue(){return waterBiomeBalanceRoundedValue;}

}