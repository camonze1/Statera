package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Building extends Biome {

  public Building() {
    this.type = BiomeEnum.BUILDING;
    this.description = "This plot is a building.";
    this.waterProportion = 0;
    this.vegetationProportion = 0;
    this.buildingProportion = 1;
    this.cost.replace("Forest", 1);
    this.cost.replace("Grass", 1);
    this.cost.replace("Water", 1);
    this.color = Color.BLACK;
    this.img = new Image(getClass().getResource("/ive/statera/img/tiles/b_building.jpg").toExternalForm());
  }

  public boolean isOccupied() {
    return true;
  }

}