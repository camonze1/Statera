package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;

public class BlockedWasteland extends Biome {

  //  Constructor  //
  public BlockedWasteland() {
    this.type = BiomeEnum.BLOCKEDWASTELAND;
    this.description = "This plot is blocked.";
    this.img = new Image(getClass().getResource("/ive/statera/img/tiles/blocked_wasteland.png").toExternalForm());
  }

  //  Methods  //

  public boolean isOccupied() {
    return false;
  }

}
