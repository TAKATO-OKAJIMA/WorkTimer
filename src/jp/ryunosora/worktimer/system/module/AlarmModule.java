package jp.ryunosora.worktimer.system.module;

import jp.ryunosora.worktimer.system.config.ConfigReader;

import java.applet.Applet;
import java.applet.AudioClip;
import java.util.ArrayList;

public class AlarmModule {

    private ArrayList<AudioClip> alarmList = new ArrayList<AudioClip>();
    private AudioClip playAlarm;
    private AudioClip workAlarm;
    private AudioClip breakAlarm;

    private ConfigReader configReader = new ConfigReader("config/audio/audio.txt");

    public AlarmModule(){
        ArrayList<String> pathList = this.configReader.readConfig();
        //this.addAlarmList("audio/CoffeeSound.wav");
        for(String path : pathList){
            this.addAlarmList(path);
        }
        this.setWorkAlarm(0);
        this.setBreakAlarm(0);
    }

    private void addAlarmList(String path ){
        ClassLoader classLoader = this.getClass().getClassLoader();
        AudioClip audioClip = Applet.newAudioClip(classLoader.getResource(path));
        this.alarmList.add(audioClip);
    }

    public void playWorkAlarm(boolean onWork){
        if (onWork){
            this.playWorkAlarm();
        }
        else{
            this.playBreakAlarm();
        }
    }

    public void setPlayAlarm(String path){
        ClassLoader classLoader = this.getClass().getClassLoader();
        AudioClip audioClip = Applet.newAudioClip(classLoader.getResource(path));
        this.playAlarm = audioClip;
    }

    public void setPlayAudioFromAudioList(int index){
        this.playAlarm = alarmList.get(index);
    }

    public void playPlayAlarm(){
        this.playAlarm.play();
    }

    public void loopPlayAlarm(){
        this.playAlarm.loop();
    }

    public void stopPlayAlarm(){
        this.playAlarm.stop();
    }

    public void setWorkAlarm(int index){
        this.workAlarm = this.alarmList.get(index);
    }

    public void playWorkAlarm(){
        this.workAlarm.play();
    }

    public void setBreakAlarm(int index){
        this.breakAlarm = this.alarmList.get(index);
    }

    public void playBreakAlarm(){
        this.breakAlarm.play();
    }
}
