import java.util.Scanner;

public class Voice {
    private VoiceInput voiceInputHelper;

    public Voice(VoiceInput voiceInputHelper) {
        this.voiceInputHelper = voiceInputHelper;
    }

    public void setVidVoice() {
        int loudness = voiceInputHelper.getLoudness();
        System.out.println("Уровень громкости изменен до " + loudness);
    }

    public static void main(String[] args) {
        VoiceInput voiceInputHelper = new VoiceInputHelper();
        Voice voice = new Voice(voiceInputHelper);
        voice.setVidVoice();
    }
}