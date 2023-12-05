package models;

import enums.BiomeEnum;
import javafx.scene.paint.Color;

public class Wasteland extends Biome {

    public Wasteland() {
        this.type = BiomeEnum.WASTELAND;
        this.description = "This plot is empty.";
        this.waterProportion = 0;
        this.vegetationProportion = 0;
        this.buildingProportion = 0;
        this.color= Color.GRAY;
    }

    public boolean isOccupied() {
        return false;
    }

}
