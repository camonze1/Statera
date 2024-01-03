package controllers;

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

  //  Methods  //

  public void updateViewStatisticController(LandController landController) {
    this.landController = landController;
    String progressBarStyleRed = "-fx-accent: red;";
    if (environmentBalanceProgressBar != null && environmentBalanceLabel != null) {
      if(landController.getEnvironmentBalanceProgressBar().getProgress()<0) {
        environmentBalanceProgressBar.setStyle(progressBarStyleRed);
        environmentBalanceProgressBar.setProgress(1.0);
      }
      else{
        environmentBalanceProgressBar.setProgress(landController.getEnvironmentBalanceProgressBar().getProgress());
      }
      environmentBalanceLabel.setText(landController.getEnvironmentBalanceLabel().getText());
    }

    if (naturalBiomeBalanceProgressBar != null && naturalBiomeBalanceLabel != null) {
      if(landController.getNaturalBiomeBalance()<0) {
        naturalBiomeBalanceProgressBar.setStyle(progressBarStyleRed);
        naturalBiomeBalanceProgressBar.setProgress(1.0);
      }
      else {
        naturalBiomeBalanceProgressBar.setProgress((landController.getNaturalBiomeBalance()) / 100.0);
      }
      naturalBiomeBalanceLabel.setText("" + landController.getNaturalBiomeBalanceRoundedValue() + "%");
    }

    if (buildingBiomeBalanceProgressBar != null && buildingBiomeBalanceLabel != null) {
      if(landController.getBuildingBiomeBalance()<0) {
        buildingBiomeBalanceProgressBar.setStyle(progressBarStyleRed);
        buildingBiomeBalanceProgressBar.setProgress(1.0);
      }
      else{
        buildingBiomeBalanceProgressBar.setProgress((landController.getBuildingBiomeBalance()) / 100.0);
      }
      buildingBiomeBalanceLabel.setText("" + landController.getBuildingBiomeBalanceRoundedValue() + "%");
    }

    if (waterBiomeBalanceProgressBar != null && waterBiomeBalanceLabel != null) {
      if(landController.getWaterBiomeBalance()<0){
        waterBiomeBalanceProgressBar.setStyle(progressBarStyleRed);
        waterBiomeBalanceProgressBar.setProgress(1.0);
      }
      else {
        waterBiomeBalanceProgressBar.setProgress((landController.getWaterBiomeBalance()) / 100.0);
      }
      waterBiomeBalanceLabel.setText("" + landController.getWaterBiomeBalanceRoundedValue() + "%");
    }

    if (qualityLifeBalanceProgressBar != null && qualityLifeBalanceLabel != null) {
      if(landController.getQualityLifeBalance()<0){
        qualityLifeBalanceProgressBar.setStyle(progressBarStyleRed);
        qualityLifeBalanceProgressBar.setProgress(1.0);
      }
      else {
        qualityLifeBalanceProgressBar.setProgress((landController.getQualityLifeBalance()) / 100.0);
      }
      qualityLifeBalanceLabel.setText("" + landController.getQualityLifeBalanceRoundedValue() + "%");

    }
  }

  //  FXML Methods  //

  @FXML
  public void home(ActionEvent event) {
    Scene scene = ((Node) event.getSource()).getScene();
    Stage stage = (Stage) scene.getWindow();
    stage.close();
  }

}
