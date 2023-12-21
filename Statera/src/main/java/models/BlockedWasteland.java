package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.Random;

public class BlockedWasteland extends Biome {

  public BlockedWasteland() {
    this.type = BiomeEnum.BLOCKEDWASTELAND;
    this.description = "This plot is blocked.";
    this.waterProportion = 0;
    this.vegetationProportion = 0;
    this.buildingProportion = 0;
    this.color = Color.GRAY;
    this.img = new Image(getClass().getResource("/ive/statera/img/tiles/blocked_wasteland.png").toExternalForm());


//    Random r = new Random();
//    int n = r.nextInt(6);
//    if (n == 0) {
//      this.img = new Image(getClass().getResource("/ive/statera/img/tiles/free_wasteland.png").toExternalForm());
//
//    } else {
//      this.img = new Image(getClass().getResource("/ive/statera/img/tiles/blocked_wasteland.png").toExternalForm());
//
//    }
  }

  public boolean isOccupied() {
    return false;
  }

}
