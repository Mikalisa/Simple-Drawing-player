package sound;

import javax.sound.midi.MidiChannel;

public class ChannelData {

    private MidiChannel channel;

    private int velocity;
    private int pressure;
    private int bend;
    private int reverb;
    private int num;
    private int organ;
    private int Reed;
    private int guitar;


    // getters
    public MidiChannel getChannel() { return channel; }

    public ChannelData(MidiChannel channel, int num) {
        this.channel = channel;
        this.num = num;
        velocity = 64;
        pressure = 64;
        bend = 64;
        reverb = 64;
        organ = 18;
        Reed = 65;
        guitar = 25;

    }
}

