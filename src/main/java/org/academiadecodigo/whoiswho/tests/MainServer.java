package org.academiadecodigo.whoiswho.tests;

import org.academiadecodigo.whoiswho.server.Server;
import org.academiadecodigo.whoiswho.utilities.Characters;

import java.io.IOException;

public class MainServer {

    public static void main(String[] args) {

        System.out.println(Characters.values().length);

        try {
            Server server = new Server(8080, 2);

            server.host();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}