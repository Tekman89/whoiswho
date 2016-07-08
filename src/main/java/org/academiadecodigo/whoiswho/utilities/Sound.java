package org.academiadecodigo.whoiswho.utilities;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Mariana on 11/02/16.
 */
public class Sound {

    public static void play(String pathStr) {
        URL soundURL = Sound.class.getResource(pathStr);
        AudioInputStream inputStream = null;

        try {
            if (soundURL == null) {
                //pathStr = pathStr.substring(1);
                File file = new File(pathStr);
                soundURL = file.toURI().toURL();
            }
            System.out.println("sound url" + soundURL);
            System.out.println(soundURL);
            inputStream = AudioSystem.getAudioInputStream(soundURL);

            Clip clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}