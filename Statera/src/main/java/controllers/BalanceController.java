package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

public class BalanceController {

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

  //  Methods  //

  public void setLandController(LandController landController) {
    this.landController = landController;
    if (environmentBalanceProgressBar != null && environmentBalanceLabel != null) {
      environmentBalanceProgressBar.setProgress(landController.getEnvironmentBalanceProgressBar().getProgress());
      environmentBalanceLabel.setText(landController.getEnvironmentBalanceLabel().getText());
    }

    if (naturalBiomeBalanceProgressBar != null && naturalBiomeBalanceLabel != null) {
      naturalBiomeBalanceProgressBar.setProgress((landController.getNaturalBiomeBalance()) / 100.0);
      naturalBiomeBalanceLabel.setText("" + landController.getNaturalBiomeBalanceRoundedValue() + "%");
    }

    if (buildingBiomeBalanceProgressBar != null && buildingBiomeBalanceLabel != null) {
      buildingBiomeBalanceProgressBar.setProgress((landController.getBuildingBiomeBalance()) / 100.0);
      buildingBiomeBalanceLabel.setText("" + landController.getBuildingBiomeBalanceRoundedValue() + "%");
    }

    if (waterBiomeBalanceProgressBar != null && waterBiomeBalanceLabel != null) {
      waterBiomeBalanceProgressBar.setProgress((landController.getWaterBiomeBalance()) / 100.0);
      waterBiomeBalanceLabel.setText("" + landController.getWaterBiomeBalanceRoundedValue() + "%");
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
