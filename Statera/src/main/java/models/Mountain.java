package models;

import enums.BiomeEnum;

public class Mountain extends Biome{

    public Mountain(){
        this.type = BiomeEnum.MOUNTAIN;
        this.description = "This plot is a mountain.";
        this.waterProportion = 0;
        this.vegetationProportion = 1;
        this.buildingProportion = 0;
        this.cost.replace("Forest",1);
        this.cost.replace("Grass",2);
        this.cost.replace("Water",1);
    }

    public boolean isOccupied() {
        return true;
    }

}
