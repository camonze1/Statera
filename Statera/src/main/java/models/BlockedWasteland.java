package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class BlockedWasteland extends Biome {

  //  Constructor  //
  public BlockedWasteland() {
    this.type = BiomeEnum.BLOCKEDWASTELAND;
    this.description = "This plot is blocked.";
    this.waterProportion = 0;
    this.vegetationProportion = 0;
    this.buildingProportion = 0;
    this.color = Color.GRAY;
    this.img = new Image(getClass().getResource("/ive/statera/img/tiles/b_wasteland_blocked.jpg").toExternalForm());
  }

  //  Methods  //

  public boolean isOccupied() {
    return false;
  }

}
