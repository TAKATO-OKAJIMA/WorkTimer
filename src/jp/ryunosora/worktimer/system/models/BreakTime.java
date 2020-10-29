package jp.ryunosora.worktimer.system.models;

import jp.ryunosora.worktimer.system.config.ConfigReader;

import java.util.ArrayList;

public class BreakTime {

    private int breakHour;
    private int breakMinute;
    private int breakSecond;

    private ConfigReader configReader = new ConfigReader("config/timer/breaktime.txt");

    public BreakTime(){
        this.setDefaultWorkTime();
        //this.debug();
    }

    private void setDefaultWorkTime(){
        ArrayList<String> time = this.configReader.readConfig();
        this.setBreakHour(Integer.parseInt(time.get(0)));
        this.setBreakMinute(Integer.parseInt(time.get(1)));
        this.setBreakSecond(Integer.parseInt(time.get(2)));
    }

    public void setBreakHour(int breakHour){
        this.breakHour = breakHour;
    }

    public void setBreakMinute(int breakMinute){
        this.breakMinute = breakMinute;
    }

    public void setBreakSecond(int breakSecond){
        this.breakSecond = breakSecond;
    }

    public int getBreakHour(){
        return this.breakHour;
    }

    public int getBreakMinute(){
        return this.breakMinute;
    }

    public int getBreakSecond(){
        return this.breakSecond;
    }

    private void debug(){
        System.out.println(String.valueOf(this.breakHour) + ":" + String.valueOf(this.breakMinute) + ":" + String.valueOf(this.breakSecond));
    }
}
