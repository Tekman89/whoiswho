package org.academiadecodigo.whoiswho;

import org.academiadecodigo.whoiswho.server.Server;

import java.io.IOException;

/**
 * Created by codecadet on 07/07/16.
 */
public class Main {

    public static void main(String[] args) {
        try {
            Server server = new Server(8080, 2);

            server.host();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
