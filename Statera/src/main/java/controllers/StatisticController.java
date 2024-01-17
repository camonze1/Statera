package controllers;

import enums.BiomeEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StatisticController {

  //  Attributes  //

  private LandController landController;

  @FXML
  private ProgressBar globalBalanceProgressBar;

  @FXML
  private Label globalBalanceLabel;

  @FXML
  private ProgressBar environmentBalanceProgressBar;

  @FXML
  private Label environmentBalanceLabel;

  @FXML
  private ProgressBar naturalBiomeBalanceProgressBar;

  @FXML
  private Label naturalBiomeBalanceLabel;

  @FXML
  private ProgressBar buildingBiomeBalanceProgressBar;

  @FXML
  private Label buildingBiomeBalanceLabel;

  @FXML
  private ProgressBar waterBiomeBalanceProgressBar;

  @FXML
  private Label waterBiomeBalanceLabel;

  @FXML
  private ProgressBar qualityLifeBalanceProgressBar;

  @FXML
  private Label qualityLifeBalanceLabel;

  @FXML
  private ProgressBar biosphereBalanceProgressBar;

  @FXML
  private Label biosphereBalanceLabel;

  @FXML
  private Label numberOfAnimalsInLandLabel;

  @FXML
  private Label numberOfHumansInLandLabel;


  @FXML
  private Text numberOfWaterPlotInLand;

  @FXML
  private Text numberOfGrassPlotInLand;

  @FXML
  private Text numberOfForestPlotInLand;

  @FXML
  private Text numberOfBuildingPlotInLand;

  @FXML
  private Text numberOfPublicBuildingPlotInLand;

  @FXML
  private Text numberOfDesertPlotInLand;

  @FXML
  private Text numberOfJunglePlotInLand;

  @FXML
  private Text numberOfMountainPlotInLand;

  @FXML
  private Text numberOfFreeWastelandPlotInLand;

  @FXML
  private Text numberOfTotalNonBlockedWastelandPlot;

  @FXML
  private Text numberOfUnlockBlockedWasteland;

  //  Methods  //

  public void updateViewStatisticController(LandController landController) {
    this.landController = landController;

    if (this.globalBalanceProgressBar != null && this.globalBalanceLabel != null) {
      if (this.landController.getGlobalBalance() < 0) {
        this.globalBalanceProgressBar.setProgress(0);
        this.globalBalanceLabel.setText("0.0%");
      } else {
        this.globalBalanceProgressBar.setProgress(this.landController.getGlobalBalance() / 100.0);
        this.globalBalanceLabel.setText("" + this.landController.getGlobalBalanceRoundedValue() + "%");
      }
    }

    if (this.environmentBalanceProgressBar != null && this.environmentBalanceLabel != null) {
      if (this.landController.getEnvironmentBalance() < 0) {
        this.environmentBalanceProgressBar.setProgress(0);
        this.environmentBalanceLabel.setText("0%");
      } else {
        this.environmentBalanceProgressBar.setProgress((this.landController.getEnvironmentBalance()) / 100.0);
        this.environmentBalanceLabel.setText("" + this.landController.getEnvironmentBalanceRoundedValue() + "%");
      }
    }

    if (this.naturalBiomeBalanceProgressBar != null && this.naturalBiomeBalanceLabel != null) {
      if (this.landController.getNaturalBiomeBalance() < 0) {
        this.naturalBiomeBalanceProgressBar.setProgress(0);
        this.naturalBiomeBalanceLabel.setText("0%");
      } else {
        this.naturalBiomeBalanceProgressBar.setProgress((this.landController.getNaturalBiomeBalance()) / 100.0);
        this.naturalBiomeBalanceLabel.setText("" + this.landController.getNaturalBiomeBalanceRoundedValue() + "%");
      }
    }

    if (this.buildingBiomeBalanceProgressBar != null && this.buildingBiomeBalanceLabel != null) {
      if (this.landController.getBuildingBiomeBalance() < 0) {
        this.buildingBiomeBalanceProgressBar.setProgress(0);
        this.buildingBiomeBalanceLabel.setText("0%");
      } else {
        this.buildingBiomeBalanceProgressBar.setProgress((this.landController.getBuildingBiomeBalance()) / 100.0);
        this.buildingBiomeBalanceLabel.setText("" + this.landController.getBuildingBiomeBalanceRoundedValue() + "%");
      }
    }

    if (this.waterBiomeBalanceProgressBar != null && this.waterBiomeBalanceLabel != null) {
      if (this.landController.getWaterBiomeBalance() < 0) {
        this.waterBiomeBalanceProgressBar.setProgress(0);
        this.waterBiomeBalanceLabel.setText("0%");
      } else {
        this.waterBiomeBalanceProgressBar.setProgress((this.landController.getWaterBiomeBalance()) / 100.0);
        this.waterBiomeBalanceLabel.setText("" + this.landController.getWaterBiomeBalanceRoundedValue() + "%");
      }
    }

    if (this.qualityLifeBalanceProgressBar != null && this.qualityLifeBalanceLabel != null) {
      if (this.landController.getQualityLifeBalance() < 0) {
        this.qualityLifeBalanceProgressBar.setProgress(0);
        this.qualityLifeBalanceLabel.setText("0%");
      } else {
        this.qualityLifeBalanceProgressBar.setProgress((this.landController.getQualityLifeBalance()) / 100.0);
        this.qualityLifeBalanceLabel.setText("" + this.landController.getQualityLifeBalanceRoundedValue() + "%");
      }
    }

    if (this.landController.getNumberOfAnimalsInLand() != 0) {
      this.numberOfAnimalsInLandLabel.setText("You have " + this.landController.getNumberOfAnimalsInLand() + " animals in total in your land");
    } else {
      this.numberOfAnimalsInLandLabel.setText("You have " + this.landController.getNumberOfAnimalsInLand() + " animal in total in your land");
    }

    if (this.landController.getNumberOfHumansInLand() != 0) {
      this.numberOfHumansInLandLabel.setText("You have " + this.landController.getNumberOfHumansInLand() + " humans in total in your land");
    } else {
      this.numberOfHumansInLandLabel.setText("You have " + this.landController.getNumberOfHumansInLand() + " human in total in your land");
    }

    if (this.biosphereBalanceProgressBar != null && this.biosphereBalanceLabel != null) {
      if (this.landController.getBiosphereBalance() < 0) {
        this.biosphereBalanceProgressBar.setProgress(0);
        this.biosphereBalanceLabel.setText("0.0%");
      } else {
        this.biosphereBalanceProgressBar.setProgress((this.landController.getBiosphereBalance()) / 100.0);
        this.biosphereBalanceLabel.setText("" + this.landController.getBiosphereBalanceRoundedValue() + "%");
      }
    }

    this.numberOfWaterPlotInLand.setText("There are " + this.landController.getNumberOfOccupiedPlotLandController(BiomeEnum.WATER) + " plots of water");
    this.numberOfGrassPlotInLand.setText("There are " + this.landController.getNumberOfOccupiedPlotLandController(BiomeEnum.GRASS) + " plots of grass");
    this.numberOfForestPlotInLand.setText("There are " + this.landController.getNumberOfOccupiedPlotLandController(BiomeEnum.FOREST) + " plots of forest");
    this.numberOfBuildingPlotInLand.setText("There are " + this.landController.getNumberOfOccupiedPlotLandController(BiomeEnum.BUILDING) + " plots of building");
    this.numberOfPublicBuildingPlotInLand.setText("There are " + this.landController.getNumberOfOccupiedPlotLandController(BiomeEnum.PUBLICBUILDING) + " plots of public building");
    this.numberOfDesertPlotInLand.setText("There are " + this.landController.getNumberOfOccupiedPlotLandController(BiomeEnum.DESERT) + " plots of desert");
    this.numberOfJunglePlotInLand.setText("There are " + this.landController.getNumberOfOccupiedPlotLandController(BiomeEnum.JUNGLE) + " plots of jungle");
    this.numberOfMountainPlotInLand.setText("There are " + this.landController.getNumberOfOccupiedPlotLandController(BiomeEnum.MOUNTAIN) + " plots of mountain");
    this.numberOfFreeWastelandPlotInLand.setText("There are " + this.landController.getNumberOfOccupiedPlotLandController(BiomeEnum.FREEWASTELAND) + " plots of free wasteland");
    this.numberOfTotalNonBlockedWastelandPlot.setText("There are " + landController.getTotalOfNonBlockedWastelandPlot() + " non blocked plot(s)");

  }

  //  FXML Methods  //

  @FXML
  public void home(ActionEvent event) {
    Scene scene = ((Node) event.getSource()).getScene();
    Stage stage = (Stage) scene.getWindow();
    stage.close();
  }

}
