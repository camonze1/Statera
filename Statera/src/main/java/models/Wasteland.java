package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.Random;

public class Wasteland extends Biome {

    public Wasteland() {
        this.type = BiomeEnum.WASTELAND;
        this.description = "This plot is empty.";
        this.waterProportion = 0;
        this.vegetationProportion = 0;
        this.buildingProportion = 0;
        this.color= Color.GRAY;

        Random r = new Random();
        int n = r.nextInt(6);
        System.out.println(n);
        if (n==0){
            this.img = new Image("C:/Users/julie/OneDrive/Documents/Polytech/4a/IVE/life-on-land/Statera/src/main/resources/ive/statera/img/Game Designs/wasteland_full.png");

        }
        else {
            this.img = new Image("C:/Users/julie/OneDrive/Documents/Polytech/4a/IVE/life-on-land/Statera/src/main/resources/ive/statera/img/Game Designs/wasteland_empty.png");

        }
    }

    public boolean isOccupied() {
        return false;
    }

}
