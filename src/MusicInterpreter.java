import jm.music.data.CPhrase;
import jm.music.data.Part;
import jm.music.data.Score;
import jm.util.Write;

import java.util.LinkedList;

import static jm.constants.Durations.*;
import static jm.constants.Pitches.*;
import static jm.constants.ProgramChanges.PIANO;
import static jm.constants.Volumes.FORTE;

public class MusicInterpreter {
    private int[] scaleNotes = { A4, B4, C4, D4, E4, F4, G4, A4};
    private CPhrase chordPhrase;
    private Part pianoPart;
    int tempo;
    Score score;

    public MusicInterpreter() {
        chordPhrase = new CPhrase();
        pianoPart = new Part("Piano", PIANO);
        tempo = 90;
        score= new Score("CA Score", tempo);
        score.setNumerator(4);
        score.setDenominator(4);
    }

    public void addChord(LinkedList<Integer> noteNumbers){
        int[] chordNotes = new int[noteNumbers.size()];
        for(int i=0; i< noteNumbers.size();i++)
            chordNotes[i] = scaleNotes[noteNumbers.get(i)];

        this.chordPhrase.addChord(chordNotes, QUARTER_NOTE);
    }

    public void saveScore(){
        this.pianoPart.addCPhrase(this.chordPhrase);
        this.score.addPart(this.pianoPart);
        Write.midi(this.score, "CAM.mid");
    }
}
