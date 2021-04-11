package com.company;

import javax.sound.midi.*;

public class MiniMiniMusicCmdLine {

    public static void main(String[] args) {
           MiniMiniMusicCmdLine mini = new MiniMiniMusicCmdLine();
           if (args.length<2) {
               System.out.println("Не забудьте аргументы для инструмента и ноты");
           } else {
               int ins = Integer.parseInt(args[0]);
               int note = Integer.parseInt(args[1]);
               mini.play(ins,note);
           }

    }

    public void play (int instrument, int notes){
         try {
             Sequencer player = MidiSystem.getSequencer();
             player.open();
             Sequence seq = new Sequence(Sequence.PPQ, 4);
             Track track = seq.createTrack();

             MidiEvent event = null;
             ShortMessage first = new ShortMessage();
             first.setMessage(192,1, instrument, 0);
             MidiEvent chanheinstrument = new MidiEvent(first,1);
             track.add(chanheinstrument);

             ShortMessage a = new ShortMessage();
             a.setMessage(144,1, notes, 100);
             MidiEvent noteOn = new MidiEvent(a,1);
             track.add(noteOn);

             ShortMessage b = new ShortMessage();
             a.setMessage(128,1, notes, 100);
             MidiEvent noteFF = new MidiEvent(b,1);
             track.add(noteFF);

             player.setSequence(seq);
             player.start();




         }catch (Exception ex) {

         }
    }


}
