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
    if (environmentBalanceProgressBar != null && environmentBalanceLabel != null) {
      if (landController.getEnvironmentBalanceProgressBar().getProgress() < 0) {
        environmentBalanceProgressBar.setProgress(0);
      } else {
        environmentBalanceProgressBar.setProgress(landController.getEnvironmentBalanceProgressBar().getProgress());
        environmentBalanceLabel.setText(landController.getEnvironmentBalanceLabel().getText());
      }
    }

    if (naturalBiomeBalanceProgressBar != null && naturalBiomeBalanceLabel != null) {
      if (landController.getNaturalBiomeBalance() < 0) {
        naturalBiomeBalanceProgressBar.setProgress(0);
        naturalBiomeBalanceLabel.setText("0%");
      } else {
        naturalBiomeBalanceProgressBar.setProgress((landController.getNaturalBiomeBalance()) / 100.0);
        naturalBiomeBalanceLabel.setText("" + landController.getNaturalBiomeBalanceRoundedValue() + "%");

      }
    }

    if (buildingBiomeBalanceProgressBar != null && buildingBiomeBalanceLabel != null) {
      if (landController.getBuildingBiomeBalance() < 0) {
        buildingBiomeBalanceProgressBar.setProgress(0);
        buildingBiomeBalanceLabel.setText("0%");
      } else {
        buildingBiomeBalanceProgressBar.setProgress((landController.getBuildingBiomeBalance()) / 100.0);
        buildingBiomeBalanceLabel.setText("" + landController.getBuildingBiomeBalanceRoundedValue() + "%");
      }
    }

    if (waterBiomeBalanceProgressBar != null && waterBiomeBalanceLabel != null) {
      if (landController.getWaterBiomeBalance() < 0) {
        waterBiomeBalanceProgressBar.setProgress(0);
        waterBiomeBalanceLabel.setText("0%");
      } else {
        waterBiomeBalanceProgressBar.setProgress((landController.getWaterBiomeBalance()) / 100.0);
        waterBiomeBalanceLabel.setText("" + landController.getWaterBiomeBalanceRoundedValue() + "%");
      }
    }

    if (qualityLifeBalanceProgressBar != null && qualityLifeBalanceLabel != null) {
      if (landController.getQualityLifeBalance() < 0) {
        qualityLifeBalanceProgressBar.setProgress(0);
        qualityLifeBalanceLabel.setText("0%");
      } else {
        qualityLifeBalanceProgressBar.setProgress((landController.getQualityLifeBalance()) / 100.0);
        qualityLifeBalanceLabel.setText("" + landController.getQualityLifeBalanceRoundedValue() + "%");
      }
    }

    if (landController.getNumberOfAnimalsInLand() != 0) {
      numberOfAnimalsInLandLabel.setText("You have " + landController.getNumberOfAnimalsInLand() + " animals in total in your land");
    } else {
      numberOfAnimalsInLandLabel.setText("You have " + landController.getNumberOfAnimalsInLand() + " animal in total in your land");
    }

    if (landController.getNumberOfHumansInLand() != 0) {
      numberOfHumansInLandLabel.setText("You have " + landController.getNumberOfHumansInLand() + " humans in total in your land");
    } else {
      numberOfHumansInLandLabel.setText("You have " + landController.getNumberOfHumansInLand() + " human in total in your land");
    }
    if (landController.getNumberOfUnlockedBlockedWasteland() == 0) {
      numberOfUnlockBlockedWasteland.setText("You have unlock 0 plot of blocked wasteland");
    } else {
      numberOfUnlockBlockedWasteland.setText("You have unlock " + landController.getNumberOfUnlockedBlockedWasteland() + " plot(s) of blocked wasteland");
    }
    numberOfWaterPlotInLand.setText("There are " + landController.getNumberOfOccupiedPlotLandController(BiomeEnum.WATER) + " plot(s) of water");
    numberOfGrassPlotInLand.setText("There are " + landController.getNumberOfOccupiedPlotLandController(BiomeEnum.GRASS) + " plot(s) of grass");
    numberOfForestPlotInLand.setText("There are " + landController.getNumberOfOccupiedPlotLandController(BiomeEnum.FOREST) + " plot(s) of forest");
    numberOfBuildingPlotInLand.setText("There are " + landController.getNumberOfOccupiedPlotLandController(BiomeEnum.BUILDING) + " plot(s) of building");
    numberOfPublicBuildingPlotInLand.setText("There are " + landController.getNumberOfOccupiedPlotLandController(BiomeEnum.PUBLICBUILDING) + " plot(s) of public building");
    numberOfDesertPlotInLand.setText("There are " + landController.getNumberOfOccupiedPlotLandController(BiomeEnum.DESERT) + " plot(s) of desert");
    numberOfJunglePlotInLand.setText("There are " + landController.getNumberOfOccupiedPlotLandController(BiomeEnum.JUNGLE) + " plot(s) of jungle");
    numberOfMountainPlotInLand.setText("There are " + landController.getNumberOfOccupiedPlotLandController(BiomeEnum.MOUNTAIN) + " plot(s) of mountain");
    numberOfFreeWastelandPlotInLand.setText("There are " + landController.getNumberOfOccupiedPlotLandController(BiomeEnum.FREEWASTELAND) + " plot(s) of free wasteland");
    numberOfTotalNonBlockedWastelandPlot.setText("There are " + landController.getTotalOfNonBlockedWastelandPlot() + " non blocked plot(s)");
  }

  //  FXML Methods  //

  @FXML
  public void home(ActionEvent event) {
    Scene scene = ((Node) event.getSource()).getScene();
    Stage stage = (Stage) scene.getWindow();
    stage.close();
  }

}
