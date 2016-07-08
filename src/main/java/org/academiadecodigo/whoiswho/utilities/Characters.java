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
    SR_ENGENHEIRO,
    DAVID,
    DIOGO_FUN,
    DIOGO_LX,
    DOMINGOS,
    ELIAS,
    FÁBIO_PEP,
    FERRÃO,
    FLÁVIO,
    QUEIROZ,
    HÉLIA,
    HENRY,
    IGOR,
    JOANA_PADAWAN,
    JOANA,
    CLARO,
    JOÃO_FOUNDER,
    SANTARÉM,
    JORGE,
    LAURA,
    LUIS,
    MANUEL,
    MÁRIO_MASTER,
    MÁRIO,
    NELSON,
    NUNO,
    NÚRIA,
    PARVEL,
    RALFE,
    RODRIGUEZ,
    RUIZÃO,
    SAMUEL,
    SÉRGIO,
    SOFIA,
    TOMÁS;

    public static Characters randomCharacter(){
        int pick = new Random().nextInt(Characters.values().length);
        return Characters.values()[pick];
    }
}
