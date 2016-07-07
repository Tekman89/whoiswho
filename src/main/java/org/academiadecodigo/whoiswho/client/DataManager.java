package org.academiadecodigo.whoiswho.client;

import org.academiadecodigo.whoiswho.utilities.PlayersEnum;

/**
 * Created by dmaia on 07-07-2016.
 */
public class DataManager {

    private String username;
    private String address;
    private String port;

    private Character selected;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Character getSelected() {
        return selected;
    }

    public void setSelected(Character selected) {
        this.selected = selected;
    }
}
