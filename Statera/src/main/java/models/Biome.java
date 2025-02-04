package models;

import enums.BiomeEnum;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public abstract class Biome {

  //  Attributes  //

  protected BiomeEnum type;

  protected String description;

  protected int animalProportion;

  protected int humanProportion;

  protected HashMap<BiomeEnum, Integer> cost;

  @FXML
  protected Rectangle rectangle;
  protected URL img;

  //  Methods  //

  public Biome() {
    this.cost = new HashMap<BiomeEnum, Integer>();
    this.cost.put(BiomeEnum.BUILDING, 0);
    this.cost.put(BiomeEnum.DESERT, 0);
    this.cost.put(BiomeEnum.BLOCKEDWASTELAND, 0);
    this.cost.put(BiomeEnum.FREEWASTELAND, 0);
    this.cost.put(BiomeEnum.FOREST, 0);
    this.cost.put(BiomeEnum.GRASS, 0);
    this.cost.put(BiomeEnum.JUNGLE, 0);
    this.cost.put(BiomeEnum.WATER, 0);
  }

  public abstract boolean isOccupied();

  //  Getters and Setters  //

  public BiomeEnum getType() {
    return this.type;
  }

  public Rectangle getRectangle() {
    return this.rectangle;
  }

  public void setRectangle(Rectangle rectangle) {
    this.rectangle = rectangle;
  }

  public Image getImage() {
    return new Image(img.toExternalForm());
  }

  public void setType(BiomeEnum type) {
    this.type = type;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public HashMap<BiomeEnum, Integer> getCost() {
    return this.cost;
  }

  public void setCost(HashMap<BiomeEnum, Integer> cost) {
    this.cost = cost;
  }

  public int getAnimalProportion() {
    return this.animalProportion;
  }

  public int getHumanProportion() {
    return this.humanProportion;
  }

  public String getStringCost() {
    HashMap<BiomeEnum, Integer> newCost = new HashMap<BiomeEnum, Integer>();
    for (BiomeEnum key : cost.keySet()) {
      if (cost.get(key) != 0) {
        newCost.put(key, cost.get(key));
      }
    }

    String res = "";
    for (Map.Entry m : newCost.entrySet()) {
      res = res + m.getKey() + " : " + m.getValue() + "\n";
    }
    return res;
  }
}
