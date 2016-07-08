package org.academiadecodigo.whoiswho.tests;

import org.academiadecodigo.whoiswho.client.Client;

import java.io.IOException;

/**
 * Created by codecadet on 07/07/16.
 */
public class MainClient {

    public static void main(String[] args) {
        try {
            Client client = new Client(8080, "localhost");

            new Thread(client).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
