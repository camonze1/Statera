package ive.statera;

import enums.BiomeEnum;

public class Grass extends Biome {

    public Grass() {
        this.type = BiomeEnum.GRASS;
        this.description = "This plot is a grass.";
        this.waterProportion = 0;
        this.vegetationProportion = 1;
        this.buildingProportion = 0;
        this.cost.replace("Wasteland",1);
    }

    public boolean isOccupied() {
        return true;
    }

}
