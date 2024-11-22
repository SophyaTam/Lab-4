import java.util.Scanner;

interface VoiceInput {
    int getLoudness();
}
public class Voice {
    private static VoiceInputHelper voiceInputHelper = new VoiceInputHelper();

    public void setVidVoice() {
        int loudness = voiceInputHelper.getLoudness();
        System.out.println("Уровень громкости изменен до " + loudness);
    }
}