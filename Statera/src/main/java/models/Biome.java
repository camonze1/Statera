package models;

import controllers.LandController;
import enums.BiomeEnum;

import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public abstract class Biome {

  protected BiomeEnum type;
  protected String description;
  protected int waterProportion;
  protected int vegetationProportion;
  protected int buildingProportion;
  protected HashMap<String, Integer> cost;
  @FXML
  protected Rectangle rectangle;
  protected Image img;
  protected Color color;

  public Biome() {
    this.cost = new HashMap<String, Integer>();
    this.cost.put("Building", 0);
    this.cost.put("Desert", 0);
    this.cost.put("Wasteland", 0);
    this.cost.put("Forest", 0);
    this.cost.put("Grass", 0);
    this.cost.put("Jungle", 0);
    this.cost.put("Water", 0);
  }

  public abstract boolean isOccupied();

  public BiomeEnum getType() {
    return this.type;
  }

  public Rectangle getRectangle() {
    return this.rectangle;
  }

  public void setRectangle(Rectangle rectangle1) {
    this.rectangle = rectangle1;
  }

  public Image getImage() {
    return img;
  }

  public Color getColor() {
    return this.color;
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

  public int getWaterProportion() {
    return this.waterProportion;
  }

  public void setWaterProportion(int waterProportion) {
    this.waterProportion = waterProportion;
  }

  public int getVegetationProportion() {
    return this.vegetationProportion;
  }

  public void setVegetationProportion(int vegetationProportion) {
    this.vegetationProportion = vegetationProportion;
  }

  public int getBuildingProportion() {
    return this.buildingProportion;
  }

  public void setBuildingProportion(int buildingProportion) {
    this.buildingProportion = buildingProportion;
  }

  public HashMap<String, Integer> getCost() {
    return this.cost;
  }

  public void setCost(HashMap<String, Integer> cost) {
    this.cost = cost;
  }

}
