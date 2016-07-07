package org.academiadecodigo.whoiswho.utilities;

import java.util.Random;

/**
 * Created by codecadet on 07/07/16.
 */
public enum Characters {
    ELIAS,
    ANA,
    JORGE,
    RALFE,
    DANIEL_LX,
    JOANA,
    ANDRÉ,
    TOMÁS,
    LAURA,
    DIOGO_LX,
    FLÁVIO,
    DANIEL_FUN,
    NUNO,
    DAVID,
    NELSON,
    HÉLIA,
    PAVEL,
    LUIS,
    SOFIA,
    MANUEL,
    AMAURI,
    FÁBIO_PEP,
    DIOGO_FUN,
    IGOR,
    JOÃO_CLARO,
    HENRY,
    ANA_TOMÁS,
    JOÃO_SANTARÉM,
    SAMUEL,
    BRUNO,
    RODOLFO,
    MÁRIO,
    JOÃO_QUEIROZ,
    CATARINA,
    FERRÃO,
    ANTONINHO,
    SÉRGIO,
    JOANA_PADAWAN,
    RUI_SANTOS,
    CAMPELO,
    NÚRIA,
    DOMINGOS,
    JOÃO_FOUNDER,
    MÁRIO_MASTER;

    public static Characters randomCharacter(){
        int pick = new Random().nextInt(Characters.values().length);
        return Characters.values()[pick];
    }
}
