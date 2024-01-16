package controllers;

import enums.BiomeEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
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
  private ProgressBar biosphereBalanceProgressBar;

  @FXML
  private Label biosphereBalanceLabel;

  @FXML
  private Label numberOfAnimalsInLandLabel;

  @FXML
  private Label numberOfHumansInLandLabel;


  @FXML
  private Label numberOfWaterPlotInLand;

  @FXML
  private Label numberOfGrassPlotInLand;

  @FXML
  private Label numberOfForestPlotInLand;

  @FXML
  private Label numberOfBuildingPlotInLand;

  @FXML
  private Label numberOfPublicBuildingPlotInLand;

  @FXML
  private Label numberOfDesertPlotInLand;

  @FXML
  private Label numberOfJunglePlotInLand;

  @FXML
  private Label numberOfMountainPlotInLand;

  @FXML
  private Label numberOfFreeWastelandPlotInLand;

  //  Methods  //

  public void updateViewStatisticController(LandController landController) {
    this.landController = landController;

    if (environmentBalanceProgressBar != null && environmentBalanceLabel != null) {
      if (landController.getEnvironmentBalance() < 0) {
        environmentBalanceProgressBar.setProgress(0);
        environmentBalanceLabel.setText("0.0%");
      } else {
        environmentBalanceProgressBar.setProgress(landController.getEnvironmentBalance()/100.0);
        environmentBalanceLabel.setText("" + landController.getEnvironmentBalanceRoundedValue() + "%");
      }
    }

    if (naturalBiomeBalanceProgressBar != null && naturalBiomeBalanceLabel != null) {
      if (landController.getNaturalBiomeBalance() < 0) {
        naturalBiomeBalanceProgressBar.setProgress(0);
        naturalBiomeBalanceLabel.setText("0.0%");
      } else {
        naturalBiomeBalanceProgressBar.setProgress((landController.getNaturalBiomeBalance()) / 100.0);
        naturalBiomeBalanceLabel.setText("" + landController.getNaturalBiomeBalanceRoundedValue() + "%");

      }
    }

    if (buildingBiomeBalanceProgressBar != null && buildingBiomeBalanceLabel != null) {
      if (landController.getBuildingBiomeBalance() < 0) {
        buildingBiomeBalanceProgressBar.setProgress(0);
        buildingBiomeBalanceLabel.setText("0.0%");
      } else {
        buildingBiomeBalanceProgressBar.setProgress((landController.getBuildingBiomeBalance()) / 100.0);
        buildingBiomeBalanceLabel.setText("" + landController.getBuildingBiomeBalanceRoundedValue() + "%");
      }
    }

    if (waterBiomeBalanceProgressBar != null && waterBiomeBalanceLabel != null) {
      if (landController.getWaterBiomeBalance() < 0) {
        waterBiomeBalanceProgressBar.setProgress(0);
        waterBiomeBalanceLabel.setText("0.0%");
      } else {
        waterBiomeBalanceProgressBar.setProgress((landController.getWaterBiomeBalance()) / 100.0);
        waterBiomeBalanceLabel.setText("" + landController.getWaterBiomeBalanceRoundedValue() + "%");
      }
    }

    if (qualityLifeBalanceProgressBar != null && qualityLifeBalanceLabel != null) {
      if (landController.getQualityLifeBalance() < 0) {
        qualityLifeBalanceProgressBar.setProgress(0);
        qualityLifeBalanceLabel.setText("0.0%");
      } else {
        qualityLifeBalanceProgressBar.setProgress((landController.getQualityLifeBalance()) / 100.0);
        qualityLifeBalanceLabel.setText("" + landController.getQualityLifeBalanceRoundedValue() + "%");
      }
    }

      if (biosphereBalanceProgressBar != null && biosphereBalanceLabel != null) {
        if (landController.getBiosphereBalance() < 0) {
          biosphereBalanceProgressBar.setProgress(0);
          biosphereBalanceLabel.setText("0.0%");
        } else {
          biosphereBalanceProgressBar.setProgress((landController.getBiosphereBalance()) / 100.0);
          biosphereBalanceLabel.setText("" + landController.getBiosphereBalanceRoundedValue() + "%");
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

      if (landController.getNumberOfHumansInLand() != 0) {
        numberOfHumansInLandLabel.setText("You have " + landController.getNumberOfHumansInLand() + " humans in total in your land");
      } else {
        numberOfHumansInLandLabel.setText("You have " + landController.getNumberOfHumansInLand() + " human in total in your land");
      }

    numberOfWaterPlotInLand.setText("There are " + landController.getNumberOfOccupiedPlotLandController(BiomeEnum.WATER) + " plots of water");
    numberOfGrassPlotInLand.setText("There are " + landController.getNumberOfOccupiedPlotLandController(BiomeEnum.GRASS) + " plots of grass");
    numberOfForestPlotInLand.setText("There are " + landController.getNumberOfOccupiedPlotLandController(BiomeEnum.FOREST) + " plots of forest");
    numberOfBuildingPlotInLand.setText("There are " + landController.getNumberOfOccupiedPlotLandController(BiomeEnum.BUILDING) + " plots of building");
    numberOfPublicBuildingPlotInLand.setText("There are " + landController.getNumberOfOccupiedPlotLandController(BiomeEnum.PUBLICBUILDING) + " plots of public building");
    numberOfDesertPlotInLand.setText("There are " + landController.getNumberOfOccupiedPlotLandController(BiomeEnum.DESERT) + " plots of desert");
    numberOfJunglePlotInLand.setText("There are " + landController.getNumberOfOccupiedPlotLandController(BiomeEnum.JUNGLE) + " plots of jungle");
    numberOfMountainPlotInLand.setText("There are " + landController.getNumberOfOccupiedPlotLandController(BiomeEnum.MOUNTAIN) + " plots of mountain");
    numberOfFreeWastelandPlotInLand.setText("There are " + landController.getNumberOfOccupiedPlotLandController(BiomeEnum.FREEWASTELAND) + " plots of free wasteland");

  }

  //  FXML Methods  //

  @FXML
  public void home(ActionEvent event) {
    Scene scene = ((Node) event.getSource()).getScene();
    Stage stage = (Stage) scene.getWindow();
    stage.close();
  }

}
