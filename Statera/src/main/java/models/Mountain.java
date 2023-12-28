package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Mountain extends Biome {

  //  Constructor  //

  public Mountain() {
    this.type = BiomeEnum.MOUNTAIN;
    this.description = "This plot is a mountain.";
    this.waterProportion = 0;
    this.vegetationProportion = 1;
    this.buildingProportion = 0;
    this.cost.replace(BiomeEnum.FOREST, 1);
    this.cost.replace(BiomeEnum.GRASS, 2);
    this.cost.replace(BiomeEnum.WATER, 1);
    this.color = Color.WHITE;
    this.img = new Image(getClass().getResource("/ive/statera/img/tiles/b_mountain.jpg").toExternalForm());
    this.animalProportion = 8;
  }

  //  Methods  //

  public boolean isOccupied() {
    return true;
  }

}
