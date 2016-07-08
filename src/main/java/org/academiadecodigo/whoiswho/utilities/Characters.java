package org.academiadecodigo.whoiswho.utilities;

import java.util.Random;

/**
 * Created by codecadet on 07/07/16.
 */
public enum Characters {
    AMAURI,
    ANA,
    ANA_TOMÁS,
    ANDRÉ,
    ANTONINHO,
    BRUNO,
    CAMPELO,
    CATARINA,
    DANIEL_FUN,
    DANIEL_LX,
    DAVID,
    DIOGO_FUN,
    DIOGO_LX,
    DOMINGOS,
    ELIAS,
    FÁBIO_PEP,
    FERRÃO,
    FLÁVIO,
    FLÁVIO_QUEIROZ,
    HÉLIA,
    HENRY,
    IGOR,
    JOANA_PADAWAN,
    JOANA,
    JOÃO_CLARO,
    JOÃO_FOUNDER,
    JOÃO_SANTARÉM,
    JORGE,
    LAURA,
    LUIS,
    MANUEL,
    MÁRIO_MASTER,
    MÁRIO,
    NELSON,
    NUNO,
    NÚRIA,
    PAVEL,
    RALFE,
    RODOLFO,
    RUI_SANTOS,
    SAMUEL,
    SÉRGIO,
    SOFIA,
    TOMÁS;

    public static Characters randomCharacter(){
        int pick = new Random().nextInt(Characters.values().length);
        return Characters.values()[pick];
    }
}
