package controllers;

import enums.BiomeEnum;
import ive.statera.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Land;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.event.Event;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class LandController {

  //  Attributes  //

  private Land land;

  private BiomeEnum biomeSelected;

  private boolean unlockBlockedWasteland = false;

  private boolean blockUnlockWastelandButton = false;

  private int numberOfUnlockedBlockedWasteland = 0;

  private Random random = new Random();

  private double naturalBiomeBalance;

  private double naturalBiomeBalanceRoundedValue;

  private double buildingBiomeBalance;

  private double buildingBiomeBalanceRoundedValue;

  private double qualityLifeBalance;

  private double qualityLifeBalanceRoundedValue;

  private double waterBiomeBalance;

  private double waterBiomeBalanceRoundedValue;

  private double biosphereBalance;

  private double biosphereBalanceRoundedValue;

  private double environmentBalance;

  private double environmentBalanceRoundedValue;

  @FXML
  private GridPane gridPane;

  @FXML
  private ProgressBar globalBalanceProgressBar;

  @FXML
  private Label globalBalanceLabel;

  private Stage previousMenuStage;

  private Stage previousStatisticStage;


  //  Methods  //

  @FXML
  public void initialize() {
    initializeLand();
  }

  public void initializeLand() {
    this.biomeSelected = null;
    this.numberOfUnlockedBlockedWasteland = 0;
    this.blockUnlockWastelandButton = false;
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

        Tooltip tooltip = new Tooltip(this.land.getBiome(row, col).getDescription());
        Tooltip.install(plot, tooltip);

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

    if (!this.verifyEndGame()) {
      if (this.biomeSelected != null && !this.unlockBlockedWasteland) {
        if (this.land.getBiome(line, column).getType() == BiomeEnum.FREEWASTELAND) {
          this.buyBiome(line, column, this.biomeSelected);
          this.updateBalance();
          if (this.verifyEndGame()) {
            this.openEndGameWindow();
          }
        } else {
          this.informationWindow("Warning", "You cannot place a tile that is not free.");
        }
      }
      if (this.land.getBiome(line, column).getType() == BiomeEnum.BLOCKEDWASTELAND && this.unlockBlockedWasteland) {
        if (this.land.getNumberOfOccupiedPlotByType(BiomeEnum.BLOCKEDWASTELAND) <= 1) {
          this.unlockWasteland(line, column);
          this.unlockBlockedWasteland = false;
          this.blockUnlockWastelandButton = true;
        } else {
          this.unlockWasteland(line, column);
          this.updateBalance();
        }
      } else if (this.unlockBlockedWasteland && this.land.getBiome(line, column).getType() != BiomeEnum.BLOCKEDWASTELAND) {
        informationWindow("Information", "You have to click on a blocked wasteland to unlock one");
        this.unlockBlockedWasteland = false;
      }
    } else {
      this.openEndGameWindow();
    }
  }

  public void updateBalance() {

    if (this.globalBalanceProgressBar != null && this.globalBalanceLabel != null) {
      if (this.getGlobalBalance() < 0) {
        this.globalBalanceProgressBar.setProgress(0);
        this.globalBalanceLabel.setText("0.0%");
      } else {
        this.globalBalanceProgressBar.setProgress((this.getGlobalBalance()) / 100.0);
        this.globalBalanceLabel.setText("" + this.getGlobalBalanceRoundedValue() + "%");
      }
    }

    this.environmentBalance = this.land.environmentBalance();
    this.environmentBalanceRoundedValue = roundToFirstDecimal(this.environmentBalance);

    this.naturalBiomeBalance = this.land.getBalanceOfNaturalBiome();
    this.naturalBiomeBalanceRoundedValue = roundToFirstDecimal(this.naturalBiomeBalance);

    this.buildingBiomeBalance = this.land.getBalanceOfBuildingBiome();
    this.buildingBiomeBalanceRoundedValue = roundToFirstDecimal(this.buildingBiomeBalance);

    this.waterBiomeBalance = this.land.getBalanceOfWaterBiome();
    this.waterBiomeBalanceRoundedValue = roundToFirstDecimal(this.waterBiomeBalance);

    this.qualityLifeBalance = this.land.getQualityOfLifeBalance();
    this.qualityLifeBalanceRoundedValue = roundToFirstDecimal(this.qualityLifeBalance);

    this.biosphereBalance = this.land.getBiosphereBalance();
    this.biosphereBalanceRoundedValue = roundToFirstDecimal(this.biosphereBalance);
  }

  private double roundToFirstDecimal(double value) {
    return Math.round(value * 10.0) / 10.0;
  }

  public void buyBiome(int line, int column, BiomeEnum biomeSelected) {
    this.land.setBiome(line, column, biomeSelected);
    setBiomeOnPlot(line, column);
    HashMap<BiomeEnum, Integer> cost = this.land.getCostOfPlot(line, column);
    for (BiomeEnum key : cost.keySet()) {
      int numberOfBiomesToRemove = cost.get(key);
      List<int[]> biomeCoordinates = this.land.getCoordinatesByBiomeType(key);

      if (biomeCoordinates.size() < numberOfBiomesToRemove) {
        informationWindow("Warning", "You don't have enough resources to buy this biome.");
        this.land.setFreeWasteland(line, column);
        setBiomeOnPlot(line, column);
        return;
      }

      for (int i = 0; i < numberOfBiomesToRemove && !biomeCoordinates.isEmpty(); i++) {
        int[] randomCoordinate = biomeCoordinates.get(this.random.nextInt(biomeCoordinates.size()));
        this.land.setFreeWasteland(randomCoordinate[0], randomCoordinate[1]);
        setBiomeOnPlot(randomCoordinate[0], randomCoordinate[1]);
        biomeCoordinates.remove(randomCoordinate);
      }
    }
  }

  public void unlockWasteland(int line, int column) {
    double waterCoefficient = 0.10;
    double grassCoefficient = 0.10;
    double forestCoefficient = 0.10;
    double buildingCoefficient = 0.20;
    double publicBuildingCoefficient = 0.16;
    double desertCoefficient = 0.14;
    double jungleCoefficient = 0.12;
    double mountainCoefficient = 0.10;

    int requiredWater = (int) (this.numberOfUnlockedBlockedWasteland * waterCoefficient);
    int requiredGrass = (int) (this.numberOfUnlockedBlockedWasteland * grassCoefficient);
    int requiredForest = (int) (this.numberOfUnlockedBlockedWasteland * forestCoefficient);
    int requiredBuilding = (int) (this.numberOfUnlockedBlockedWasteland * buildingCoefficient);
    int requiredPublicBuilding = (int) (this.numberOfUnlockedBlockedWasteland * publicBuildingCoefficient);
    int requiredDesert = (int) (this.numberOfUnlockedBlockedWasteland * desertCoefficient);
    int requiredJungle = (int) (this.numberOfUnlockedBlockedWasteland * jungleCoefficient);
    int requiredMountain = (int) (this.numberOfUnlockedBlockedWasteland * mountainCoefficient);

    if (this.unlockBlockedWasteland && hasEnoughResources(requiredWater, requiredGrass, requiredForest, requiredBuilding, requiredPublicBuilding, requiredDesert, requiredJungle, requiredMountain) &&
        this.land.getBiome(line, column).getType() == BiomeEnum.BLOCKEDWASTELAND) {
      this.land.setFreeWasteland(line, column);
      setBiomeOnPlot(line, column);
      this.unlockBlockedWasteland = false;
      this.numberOfUnlockedBlockedWasteland++;
    } else {
      StringBuilder messageBuilder = new StringBuilder("Insufficient resources to unlock the wasteland you need: \n");
      if (requiredWater != 0) {
        messageBuilder.append(requiredWater).append(" water, \n");
      }
      if (requiredGrass != 0) {
        messageBuilder.append(requiredGrass).append(" grass, \n");
      }
      if (requiredForest != 0) {
        messageBuilder.append(requiredForest).append(" forest, \n");
      }
      if (requiredBuilding != 0) {
        messageBuilder.append(requiredBuilding).append(" building, \n");
      }
      if (requiredPublicBuilding != 0) {
        messageBuilder.append(requiredPublicBuilding).append(" public building, \n");
      }
      if (requiredDesert != 0) {
        messageBuilder.append(requiredDesert).append(" desert, \n");
      }
      if (requiredJungle != 0) {
        messageBuilder.append(requiredJungle).append(" jungle, \n");
      }
      if (requiredMountain != 0) {
        messageBuilder.append(requiredMountain).append(" mountain, \n");
      }
      messageBuilder.deleteCharAt(messageBuilder.length() - 3);
      informationWindow("Information", messageBuilder.toString());
      this.unlockBlockedWasteland = false;
    }
  }

  private boolean hasEnoughResources(int requiredWater, int requiredGrass, int requiredForest, int requiredBuilding, int requiredPublicBuilding, int requiredDesert, int requiredJungle, int requiredMountain) {
    int availableWater = this.land.getNumberOfOccupiedPlotByType(BiomeEnum.WATER);
    int availableGrass = this.land.getNumberOfOccupiedPlotByType(BiomeEnum.GRASS);
    int availableForest = this.land.getNumberOfOccupiedPlotByType(BiomeEnum.FOREST);
    int availableBuilding = this.land.getNumberOfOccupiedPlotByType(BiomeEnum.BUILDING);
    int availablePublicBuilding = this.land.getNumberOfOccupiedPlotByType(BiomeEnum.PUBLICBUILDING);
    int availableDesert = this.land.getNumberOfOccupiedPlotByType(BiomeEnum.DESERT);
    int availableJungle = this.land.getNumberOfOccupiedPlotByType(BiomeEnum.JUNGLE);
    int availableMountain = this.land.getNumberOfOccupiedPlotByType(BiomeEnum.MOUNTAIN);

    return availableWater >= requiredWater && availableGrass >= requiredGrass && availableForest >= requiredForest && availableBuilding >= requiredBuilding && availablePublicBuilding >= requiredPublicBuilding && availableDesert >= requiredDesert && availableJungle >= requiredJungle && availableMountain >= requiredMountain;
  }

  public void openEndGameWindow() {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/ive/statera/End.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root, 600, 500);
      Stage endStage = new Stage();
      EndController endController = loader.getController();
      endController.setEndController(this);
      endStage.setTitle("End game - Statera");
      endStage.setScene(scene);
      endStage.getIcons().add(new Image(Application.class.getResource("img/logo_statera.png").openStream()));
      endStage.setOnCloseRequest(Event::consume);
      endStage.initModality(Modality.APPLICATION_MODAL);
      endStage.setResizable(false);
      endStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public boolean verifyEndGame() {
    return this.land.getNumberOfOccupiedPlotByType(BiomeEnum.FREEWASTELAND) == 0;
  }

  private void informationWindow(String title, String text) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
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

  //  FXML Methods  //

  @FXML
  public void onClickedMenu(ActionEvent event) {
    try {
      if (this.previousMenuStage != null) {
        this.previousMenuStage.close();
      }
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/ive/statera/Menu.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root, 600, 500);
      Stage menuStage = new Stage();
      MenuController menuController = loader.getController();
      menuController.setLandController(this);
      if (this.blockUnlockWastelandButton) {
        menuController.blockUnlockWastelandButton();
      }
      menuStage.setTitle("Menu - Statera");
      menuStage.setScene(scene);
      menuStage.getIcons().add(new Image(Application.class.getResource("img/logo_statera.png").openStream()));
      menuStage.setResizable(false);
      menuStage.show();

      this.previousMenuStage = menuStage;

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  public void onClickedStatistics(ActionEvent event) {
    try {
      if (this.previousStatisticStage != null) {
        this.previousStatisticStage.close();
      }
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/ive/statera/Statistic.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root, 600, 500);
      Stage statisticsStage = new Stage();
      StatisticController statisticController = loader.getController();
      statisticController.updateViewStatisticController(this);
      statisticsStage.setTitle("Statistics - Statera");
      statisticsStage.setScene(scene);
      statisticsStage.getIcons().add(new Image(Application.class.getResource("img/logo_statera.png").openStream()));
      statisticsStage.setResizable(false);
      statisticsStage.show();
      this.previousStatisticStage = statisticsStage;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //  Getters and Setters  //


  public void setBiomeOnPlot(int line, int column) {
    Rectangle biomePlot = new Rectangle(35, 35);
    Tooltip tooltip = new Tooltip(this.land.getBiome(line, column).getDescription());
    Tooltip.install(biomePlot, tooltip);
    biomePlot.setFill(new ImagePattern(this.land.getBiome(line, column).getImage()));
    biomePlot.setOnMouseClicked(event -> onPlotClick(biomePlot));
    this.land.getBiome(line, column).setRectangle(biomePlot);
    show();
  }

  public void setRandomBiomeToFreeWasteland(BiomeEnum biomeType) {
    List<int[]> freeWastelandCoordinates = this.land.getCoordinatesByBiomeType(BiomeEnum.FREEWASTELAND);
    if (!freeWastelandCoordinates.isEmpty()) {
      int[] randomCoordinate = freeWastelandCoordinates.get(this.random.nextInt(freeWastelandCoordinates.size()));
      this.land.setBiome(randomCoordinate[0], randomCoordinate[1], biomeType);
    }
  }

  public int getNumberOfOccupiedPlotLandController(BiomeEnum biomeType) {
    return this.land.getNumberOfOccupiedPlotByType(biomeType);
  }

  public int getNumberOfAnimalsInLand() {
    return this.land.getNumberOfAnimals();
  }

  public int getNumberOfHumansInLand() {
    return this.land.getNumberOfHumans();
  }

  public void setBiomeSelected(BiomeEnum biomeSelected) {
    this.biomeSelected = biomeSelected;
  }

  public void setUnlockBlockedWasteland(boolean unlockBlockedWasteland) {
    this.unlockBlockedWasteland = unlockBlockedWasteland;
  }

  public double getEnvironmentBalance() {
    return this.environmentBalance;
  }

  public double getEnvironmentBalanceRoundedValue() {
    return this.environmentBalanceRoundedValue;
  }

  public double getNaturalBiomeBalance() {
    return this.naturalBiomeBalance;
  }

  public double getNaturalBiomeBalanceRoundedValue() {
    return this.naturalBiomeBalanceRoundedValue;
  }

  public double getBuildingBiomeBalance() {
    return this.buildingBiomeBalance;
  }

  public double getBuildingBiomeBalanceRoundedValue() {
    return this.buildingBiomeBalanceRoundedValue;
  }

  public double getWaterBiomeBalance() {
    return this.waterBiomeBalance;
  }

  public double getWaterBiomeBalanceRoundedValue() {
    return this.waterBiomeBalanceRoundedValue;
  }

  public double getQualityLifeBalanceRoundedValue() {
    return this.qualityLifeBalanceRoundedValue;
  }

  public double getQualityLifeBalance() {
    return qualityLifeBalance;
  }

  public double getGlobalBalance() {
    return this.land.globalBalance();
  }

  public double getGlobalBalanceRoundedValue() {
    return this.roundToFirstDecimal(this.land.globalBalance());
  }

  public Land getLand() {
    return this.land;
  }

  public int getTotalOfNonBlockedWastelandPlot() {
    return this.land.getTotalOfNonBlockedWastelandPlot();
  }

  public int getNumberOfUnlockedBlockedWasteland() {
    return this.numberOfUnlockedBlockedWasteland;
  }

  public double getBiosphereBalanceRoundedValue() {
    return this.biosphereBalanceRoundedValue;
  }

  public double getBiosphereBalance() {
    return this.biosphereBalance;
  }

}