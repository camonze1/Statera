package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;

public class FreeWasteland extends Biome {

  //  Constructor  //

  public FreeWasteland() {
    this.type = BiomeEnum.FREEWASTELAND;
    this.description = "This plot is empty.";
    this.img = getClass().getResource("/ive/statera/img/tiles/free_wasteland.png");
    this.animalProportion = 0;

  }

  //  Methods  //
  
  public boolean isOccupied() {
    return false;
  }

}
