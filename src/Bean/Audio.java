package Bean;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio { //gestisce la sigla del gioco
	
	private static Clip clipSigla;
	
	public Audio() {
		
	}
	
	public void inizializzaSigla() {
		
		File sigla = new File("sound\\sigla.wav");
		
		AudioInputStream audio = null;
		try {
			audio = AudioSystem.getAudioInputStream(sigla);
		} catch (UnsupportedAudioFileException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		clipSigla = null;
		try {
			clipSigla = AudioSystem.getClip();
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}
		try {
			clipSigla.open(audio);
		} catch (LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void suonaSigla() { //fai suonare la sigla in loop, quando il file audio viene letto completamente lo rilegge
		clipSigla.loop(1);
	}
}
