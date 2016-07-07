package org.academiadecodigo.whoiswho.utilities;

import java.util.Random;

/**
 * Created by codecadet on 07/07/16.
 */
public enum Characters {
    ELIAS,
    ANA;

    public static Characters randomCharacter(){
        int pick = new Random().nextInt(Characters.values().length);
        System.out.println(Characters.values()[pick]);
        return Characters.values()[pick];
    }
}
