package script.data;

import org.rspeer.runetek.api.commons.math.Random;

public class RNG {
    public static int randInt (int min, int max){

        Random rand = null;
        int randomNum = rand.nextInt((max - min) + 1 ) + min;
        return randomNum;
    }
}
