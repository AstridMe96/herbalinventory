/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audioPlayer;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author HP
 */
public class Player {
 public void play(File namaFile) {
        try {

            if (namaFile.exists()) {
                AudioInputStream jalur = AudioSystem.getAudioInputStream(namaFile);
                Clip clip = AudioSystem.getClip();
                clip.open(jalur);
                clip.start();
                
                System.out.println("Sedang playing!");
            }else{
                 
                System.out.println("audio tidak ada!!");
            }

        } catch (Exception ex) {
     //       Logger.getLogger(FramePusat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error saat play!");
        }
    }
   
}
