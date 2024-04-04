import sound.Playback;
import sound.SoundSample;
import sound.SimpleSound;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


/** A class to represent sounds.
* Basically a wrapper around the int arrays we have been using with
* some of the functionality from the CSE8ALib class.
*/
public class Sound
{
    // Member variable to store the sound samples
    private int [] sound;

    /**
    * Constructor to create a new sound object from a .wav file
    * Only supports sampling rates of 22050 and 44100
    */
    public Sound(String path){
        SimpleSound sound = new SimpleSound(path);
        SoundSample[] ss = sound.getSamples();

        int rate = (int)sound.getSamplingRate();
        if(rate == 22050) {
            int[] samples = new int[ss.length];
            for(int i = 0; i < ss.length; i += 1) {
                samples[i] = ss[i].getValue();
            }
            this.sound = samples;
        }
        else if(rate == 44100) {
            int[] samples = new int[ss.length / 2];
            for(int i = 0; i < samples.length - 1; i += 2) {
                samples[i] = ss[i * 2].getValue();
            }
            this.sound = samples;
        }
        else {
            throw new RuntimeException("Unknown sampling rate from audio file: " + rate);
        }

    }

    /**
     * Constructor that creates a new Sound object from an array of ints
     * which represent the sound samples
     */
    public Sound(int[] soundIn){
        this.sound = soundIn;

    }

    /**
     * Save the sound to a file
     */
    void saveSound(int[] sound, String destinationPath) {
        SimpleSound s = new SimpleSound(sound);
        s.write(destinationPath);
    }

    /**
     * Read the sound samples from a file and return them
     */
    int[] readSoundAtNaturalRate(String path) {
        SimpleSound sound = new SimpleSound(path);
        SoundSample[] ss = sound.getSamples();
        int rate = (int)sound.getSamplingRate();
        int[] samples = new int[ss.length];
        for(int i = 0; i < ss.length; i += 1) {
            samples[i] = ss[i].getValue();
        }
        return samples;
    }

    /**
     * Play the sound.
     */
    boolean play() {
        new SimpleSound(sound).play();
        return true;
    }


    /**
     *  Play the sound while blocking other code from executing.
     *  The program will pause until the sound has played completely.
     */
    boolean blockingPlay() {
        new SimpleSound(sound).blockingPlay();
        return true;
    }

    /**
     *  Stop playing the sound.
     */
    boolean stopMusic() {
        for(Playback p: SimpleSound.globalPlaybacks) {
            p.stopPlaying();
        }
        return true;
    }

    /**
     * Visualize the sound samples in the sound object
     */
    public boolean explore() {
        new SimpleSound(sound).explore();
        return true;
    }
}
