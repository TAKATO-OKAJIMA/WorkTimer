package jp.ryunosora.worktimer.system.models;

import jp.ryunosora.worktimer.system.config.ConfigReader;

import java.util.ArrayList;

public class WorkTime {

    private int workHour;
    private int workMinute;
    private int workSecond;

    private ConfigReader configReader = new ConfigReader("config/timer/worktime.txt");

    public WorkTime(){
        this.setDefaultWorkTime();
        //this.debug();
    }

    private void setDefaultWorkTime(){
        ArrayList<String> time = this.configReader.readConfig();
        this.setWorkHour(Integer.parseInt(time.get(0)));
        this.setWorkMinute(Integer.parseInt(time.get(1)));
        this.setWorkSecond(Integer.parseInt(time.get(2)));
    }

    public void setWorkHour(int workHour){
        this.workHour = workHour;
    }

    public void setWorkMinute(int workMinute){
        this.workMinute = workMinute;
    }

    public void setWorkSecond(int workSecond){
        this.workSecond = workSecond;
    }

    public int getWorkHour(){
        return this.workHour;
    }

    public int getWorkMinute(){
        return this.workMinute;
    }

    public int getWorkSecond(){
        return this.workSecond;
    }

    private void debug(){
        System.out.println(String.valueOf(this.workHour) + ":" + String.valueOf(this.workMinute) + ":" + String.valueOf(this.workSecond));
    }
}
