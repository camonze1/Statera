package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Grass extends Biome {

  public Grass() {
    this.type = BiomeEnum.GRASS;
    this.description = "This plot is a grass.";
    this.waterProportion = 0;
    this.vegetationProportion = 1;
    this.buildingProportion = 0;
    this.cost.replace("Wasteland", 1);
    this.color = Color.GREEN;
    this.img = new Image(getClass().getResource("/ive/statera/img/tiles/grass.png").toExternalForm());
  }

  public boolean isOccupied() {
    return true;
  }

}
