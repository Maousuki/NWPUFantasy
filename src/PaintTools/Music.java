package PaintTools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music implements Runnable {

	
	//≤•∑≈Ãÿ∂®“Ù¿÷
	public static void play(String musicId) {
		try {
//			FileInputStream fileInputStream = new FileInputStream("./res/mus/"+musicId);
//			URL url = Music.class.getResource("./res/mus/"+musicId);
			File file = new File("./res/mus/"+musicId);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
			// Get a sound clip resource.
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
		} catch (Exception e) {e.printStackTrace();}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
