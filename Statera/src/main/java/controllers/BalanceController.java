package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BalanceController {

    private LandController landController;

    public void setLandController(LandController landController) {
        this.landController = landController;
    }

    public void onClickedHome(ActionEvent event) {
        Scene scene = ((Node) event.getSource()).getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }

    public void onClickedMenu(ActionEvent event) {
        try {
            Scene scene1 = ((Node) event.getSource()).getScene();
            Stage stage = (Stage) scene1.getWindow();
            stage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ive/statera/Menu.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 600, 500);
            Stage menuStage = new Stage();
            MenuController menuController = loader.getController();
            menuController.setLandController(this.landController);
            menuStage.setTitle("Menu - Statera");
            menuStage.setScene(scene);
            menuStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
