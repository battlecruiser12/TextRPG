package main;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class SoundHandler {
	String folderPath;
	boolean music;
	Clip clip;
	public SoundHandler(boolean music) {
		folderPath = "./sound/";
		this.music = music;
	}
	
	public void playSound(String fileName) {
		if(music == true && clip != null) {
		clip.stop();
		clip.close();
		}
		try {
			File soundFile = new File(folderPath + fileName);
			
			if(soundFile.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundFile);
				clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				if(music == true) {
					clip.loop(Clip.LOOP_CONTINUOUSLY);
				}
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	

	
	
}
