package controllers;

import enums.BiomeEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

  @FXML
  private ProgressBar environmentProgressBar;
  private Land land;
  private BiomeEnum biomeSelected;
  private Random random = new Random();

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
    updateEnvironmentProgressBar();
    show();
  }

  public void onPlotClick(Rectangle plot) {
    int line = GridPane.getColumnIndex(plot);
    int column = GridPane.getRowIndex(plot);

    if (this.biomeSelected != null) {
      if (this.land.getBiome(line, column).getType() == BiomeEnum.FREEWASTELAND) {
        buyBiome(line, column, this.biomeSelected);
        updateEnvironmentProgressBar();
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

  public void updateEnvironmentProgressBar() {
    double balance = this.land.environmentBalance();
    environmentProgressBar.setProgress(balance / 100.0);
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
}
