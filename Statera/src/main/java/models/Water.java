package models;

import enums.BiomeEnum;
import javafx.scene.paint.Color;

public class Water extends Biome {

    private int waterValue;
    public Water() {
        this.type = BiomeEnum.WATER;
        this.description = "This plot is a water.";
        this.waterProportion = 1;
        this.vegetationProportion = 0;
        this.buildingProportion = 0;
        this.waterValue = 20;
        this.color= Color.BLUE;

    }

    public boolean isOccupied() {
        return true;
    }

    public int getWaterValue() {
        return waterValue;
    }

    public void setWaterValue(int waterValue) {
        this.waterValue = waterValue;
    }
}
